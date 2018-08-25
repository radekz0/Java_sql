package Db_Radek;

import java.sql.*;

public class DbController {
    private Connection connection;
    private Statement statement;

    DbController(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chinook.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNames(){
        String query = "SELECT Name FROM tracks LIMIT 50";
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            //Creating a StringBuilder object to store output for JTextArea
            StringBuilder ss = new StringBuilder();

            while(result.next()){
                String name = result.getString(1);  //index 1 refers to Name from query
                ss.append(name);
                ss.append("\n");
            }
            String output = ss.toString();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
