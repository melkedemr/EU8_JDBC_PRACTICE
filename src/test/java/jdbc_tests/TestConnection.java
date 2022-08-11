package jdbc_tests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        String dbURL = "jdbc:oracle:thin:@34.230.72.55:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("SELECT * from regions");

       /* resultSet.next();//move pointer to the first row- horizontally move the pointer

        //get the cell
        System.out.println(resultSet.getString("region_name"));
        //getting info with index(starts 1)
        System.out.println(resultSet.getString(2));

         //1 - Europe
        System.out.println(resultSet.getInt(1)+"-"+resultSet.getString(2));*/

        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+"-"+resultSet.getString(2));
        }













resultSet.close();
statement.close();
connection.close();

    }
}
