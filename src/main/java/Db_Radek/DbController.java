package Db_Radek;

import java.sql.*;

public class DbController {
    private Connection connection;
    private PreparedStatement statement;

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
        String query = "SELECT Composer, Name FROM tracks";
        try {
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            //Creating a StringBuilder object to store output for JTextArea
            StringBuilder ss = new StringBuilder();

            while(result.next()){
                String composer = result.getString(1);  //index 1 refers to Name from query
                String name = result.getString(2);  //index 2 refers to Composer from query
                ss.append(composer + ": "+name);
                ss.append("\n");
            }
            String output = ss.toString();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String searchNames(String input){

        String query = "SELECT Name FROM tracks WHERE Name LIKE ? ";

        System.out.print(input);
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,"%"+input+"%");
            ResultSet result = statement.executeQuery();

            StringBuilder ss = new StringBuilder();

            while(result.next()){
                String name = result.getString(1);
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
