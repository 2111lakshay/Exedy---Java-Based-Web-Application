 package com.exedy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminDAO {
  

    public boolean view(String username, String password) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","")) {
            String query = "SELECT username FROM admindetails WHERE username=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getUserDetails() throws ClassNotFoundException {
        List<User> userList = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","")) {
            String query = "SELECT * FROM userdetails";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("userid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String fullname = resultSet.getString("fullname");
                String usertype = resultSet.getString("usertype");

                User user = new User(id, username, password, email, fullname, usertype);
                userList.add(user);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    public boolean convertToAnalyst(int id) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","")){
    		String query = "update userdetails set usertype='analyst' where userid =?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    
    public boolean convertToUser(int id) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","")){
    		String query = "update userdetails set usertype='user' where userid =?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    
    public boolean deleteUser(int id) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","")) {
            String deleteUser = "DELETE FROM userdetails WHERE userid = ?";
            String deleteProducts = "DELETE FROM products WHERE userid = ?";
            
            // Check if there are any products associated with the user
            String checkProducts = "SELECT COUNT(*) AS count FROM products WHERE userid = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkProducts);
            checkStatement.setInt(1, id);
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();
            int productCount = resultSet.getInt("count");
            
            // Prepare the delete statements
            PreparedStatement userStatement = connection.prepareStatement(deleteUser);
            userStatement.setInt(1, id);
            
            PreparedStatement productStatement = connection.prepareStatement(deleteProducts);
            productStatement.setInt(1, id);
            
            // Execute the delete statements based on the product count
            int userRowsAffected = userStatement.executeUpdate();
            int productRowsAffected = 0;
            
            if (productCount > 0) {
                productRowsAffected = productStatement.executeUpdate();
            }
            
            return userRowsAffected > 0 || productRowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    
    public List<User> getAnalystDetails() throws ClassNotFoundException {
        List<User> userList = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","")) {
            String query = "SELECT * FROM userdetails where usertype=? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "analyst");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("userid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String fullname = resultSet.getString("fullname");
                String usertype = resultSet.getString("usertype");

                User user = new User(id, username, password, email, fullname, usertype);
                userList.add(user);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
