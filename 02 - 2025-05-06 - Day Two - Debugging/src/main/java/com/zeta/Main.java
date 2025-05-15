package com.zeta;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "dilip", "malani");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Personal");
            while(result.next()) {
                System.out.println("[id: " + result.getInt(1) + ", name: " + result.getString(2) + "]");
            }
            connection.close();
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}