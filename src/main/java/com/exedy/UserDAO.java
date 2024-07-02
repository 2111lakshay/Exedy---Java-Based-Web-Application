package com.exedy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class UDB {
	private String url = "jdbc:mysql://localhost:3306/project";
	private String username = "root";
	private String password = "";

	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, username, password);
	}
}

public class UserDAO {
	private UDB udb = new UDB();

	public boolean isValidUser(String username, String password) throws SQLException {
	    try (Connection connection = udb.getConnection()) {
	        String query = "SELECT username FROM userdetails WHERE username=? AND password=?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, username);
	        statement.setString(2, password);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            return true;  // Credentials match a user in the database
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;  // Credentials do not match any user in the database
	}


	
	public User getUserByUsername(String username) throws SQLException {
        User user = null;

        try (Connection connection = udb.getConnection()) {
            String query = "SELECT * FROM userdetails WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("userid");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String fullName = resultSet.getString("fullname");
                String userType = resultSet.getString("usertype");

                user = new User(id, username, password, email, fullName, userType);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
	
	public boolean registerUser(String username, String password, String email, String fullname, String usertype) {
	    try (Connection connection = udb.getConnection()) {
	        String query = "INSERT INTO userdetails (username, password, email, fullname, usertype) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, username);
	        statement.setString(2, password);
	        statement.setString(3, email);
	        statement.setString(4, fullname);
	        statement.setString(5, usertype);
	        int rowsAffected = statement.executeUpdate();
	        
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public String getUserType(int userId) {
	    String userType = null;
	    
	    try (Connection connection = udb.getConnection()){
	        String query = "SELECT usertype FROM userdetails WHERE userid=?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, userId);
	        
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            userType = resultSet.getString("usertype");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return userType;
	}




}
