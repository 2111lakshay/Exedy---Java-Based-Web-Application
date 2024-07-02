package com.exedy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class PDB {

    public Connection getConnection() throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return DriverManager.getConnection(url, username, password);
    }
    private String url = "jdbc:mysql://localhost:3306/project";
    private String username = "root";
    private String password = "";
    
}

public class ProductDAO {
    private PDB pdb = new PDB();
    
    public Product getProductById(int productId) {
        try (Connection connection = pdb.getConnection()) {
            String query = "SELECT * FROM products WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                double functionality = resultSet.getDouble("functionality");
                double performance = resultSet.getDouble("performance");
                double usability = resultSet.getDouble("usability");
                double cost = resultSet.getDouble("cost");
                double value = resultSet.getDouble("value");
                double environmentalImpact = resultSet.getDouble("environmental_impact");
                double customerFeedback = resultSet.getDouble("customer_feedback");

                return new Product(productId, productName, functionality, performance, usability, cost, value, environmentalImpact, customerFeedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // return null if product not found
    }



    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        try (Connection connection = pdb.getConnection()) {
            String query = "SELECT * FROM products";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("product_name");
                double functionality = resultSet.getDouble("functionality");
                double performance = resultSet.getDouble("performance");
                double usability = resultSet.getDouble("usability");
                double cost = resultSet.getDouble("cost");
                double value = resultSet.getDouble("value");
                double environmentalImpact = resultSet.getDouble("environmental_impact");
                double customerFeedback = resultSet.getDouble("customer_feedback");

                Product product = new Product(productId, productName, functionality, performance, usability, cost, value, environmentalImpact, customerFeedback);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
    
    public List<Product> getAllProducts(int Id) {
        List<Product> productList = new ArrayList<>();

        try (Connection connection = pdb.getConnection()) {
            String query = "SELECT * FROM products where id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("product_name");
                double functionality = resultSet.getDouble("functionality");
                double performance = resultSet.getDouble("performance");
                double usability = resultSet.getDouble("usability");
                double cost = resultSet.getDouble("cost");
                double value = resultSet.getDouble("value");
                double environmentalImpact = resultSet.getDouble("environmental_impact");
                double customerFeedback = resultSet.getDouble("customer_feedback");

                Product product = new Product(productId, productName, functionality, performance, usability, cost, value, environmentalImpact, customerFeedback);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
    
    
    public boolean updateProduct(Product product) {
        // SQL query to update the product in the database
        String updateQuery = "UPDATE products SET product_name=?, functionality=?, performance=?, usability=?, cost=?, value=?, environmental_impact=?, customer_feedback=? WHERE id=?";

        try (Connection connection = pdb.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            // Set the values for the prepared statement
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getFunctionality());
            statement.setDouble(3, product.getPerformance());
            statement.setDouble(4, product.getUsability());
            statement.setDouble(5, product.getCost());
            statement.setDouble(6, product.getValue());
            statement.setDouble(7, product.getEnvironmentalImpact());
            statement.setDouble(8, product.getCustomerFeedback());
            statement.setInt(9, product.getProductId());

            // Execute the update query
            int rowsAffected = statement.executeUpdate();

            // Return true if at least one row was affected, indicating a successful update
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void addProduct(Product product) {
        String insertQuery = "INSERT INTO products (product_name, functionality, performance, usability, cost, value, environmental_impact, customer_feedback, userid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = pdb.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getFunctionality());
            statement.setDouble(3, product.getPerformance());
            statement.setDouble(4, product.getUsability());
            statement.setDouble(5, product.getCost());
            statement.setDouble(6, product.getValue());
            statement.setDouble(7, product.getEnvironmentalImpact());
            statement.setDouble(8, product.getCustomerFeedback());
            statement.setInt(9, product.getUserid());

            statement.executeUpdate();

            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    
    public boolean deleteProductFromDatabase(String productId) {
        try (Connection connection = pdb.getConnection()) {
            String query = "DELETE FROM products WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, productId);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean addFeedback(int productId, int userId, String feedback) {
        String query = "INSERT INTO customer_feedback (product_id, user_id, user_name, feedback_text) VALUES (?, ?, ?, ?) " +
                       "ON DUPLICATE KEY UPDATE feedback_text = ?";
        String usernameQuery = "SELECT username FROM userdetails WHERE userid = ?";
        try (Connection connection = pdb.getConnection();
             PreparedStatement statement = connection.prepareStatement(usernameQuery))
        {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("username");

                try (PreparedStatement insertStatement = connection.prepareStatement(query)) {
                    insertStatement.setInt(1, productId);
                    insertStatement.setInt(2, userId);
                    insertStatement.setString(3, username);
                    insertStatement.setString(4, feedback);
                    insertStatement.setString(5, feedback);

                    int rowsAffected = insertStatement.executeUpdate();
                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
    public List<Feedback> getReviewsByProductId(int productId) {
        List<Feedback> reviews = new ArrayList<>();

        try (Connection connection = pdb.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer_feedback WHERE product_id = ?")) {
            statement.setInt(1, productId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int feedbackId = resultSet.getInt("feedback_id");
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                String feedbackText = resultSet.getString("feedback_text");
                String feedbackDate = resultSet.getString("feedback_date");

                Feedback feedback = new Feedback(feedbackId, productId, userId, userName, feedbackText, feedbackDate);
                reviews.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }


}
