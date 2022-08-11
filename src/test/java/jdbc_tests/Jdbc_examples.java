package jdbc_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class Jdbc_examples {

    String dbURL = "jdbc:oracle:thin:@34.230.72.55:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @DisplayName("ResultSet Methods")
    @Test
   public void test1() throws SQLException {
       Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
       Statement statement= connection.createStatement();
       ResultSet resultSet= statement.executeQuery("SELECT * from departments");

       //resultSet.next();

       //System.out.println(resultSet.getString(2));

       //display departments table in 10 - Administration - 200 - 1700 format
       while(resultSet.next()){

           System.out.println(resultSet.getInt(1)+"-"
                   +resultSet.getString(2)+"-"+resultSet.getString(3)+
                   "-"+resultSet.getInt(4));
       }

       resultSet=statement.executeQuery("select * from regions");

       while(resultSet.next()){
           System.out.println(resultSet.getInt(1)+"-"+resultSet.getString(2));
       }

       resultSet.close();
       statement.close();
       connection.close();
   }
   @Test
    public void test2() throws SQLException {
       Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
       Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       ResultSet resultSet= statement.executeQuery("SELECT * from departments");

//how many rows we have
        resultSet.last();

        int rowCount= resultSet.getRow();

        System.out.println(rowCount);

        resultSet.beforeFirst();

        while(resultSet.next()){
            System.out.println(resultSet.getString(2));
        }

       resultSet.close();
       statement.close();
       connection.close();
   }
    @Test
    public void test3() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * from employees");

        DatabaseMetaData dbMetadata=connection.getMetaData();

        System.out.println("dbMetadata.getUserName() = " + dbMetadata.getUserName());
        System.out.println("dbMetadata.getDatabaseProductName() = " + dbMetadata.getDatabaseProductName());
        System.out.println("dbMetadata.getDatabaseProductVersion() = " + dbMetadata.getDatabaseProductVersion());
        System.out.println("dbMetadata.getDriverName() = " + dbMetadata.getDriverName());
        System.out.println("dbMetadata.getDriverVersion() = " + dbMetadata.getDriverVersion());

        ResultSetMetaData rsmd= resultSet.getMetaData();

        //how many columns
        int colCount= rsmd.getColumnCount();
        System.out.println("colCount = " + colCount);

        //get column names
        System.out.println(rsmd.getColumnName(1));
        System.out.println(rsmd.getColumnName(2));
        System.out.println(rsmd.getColumnName(3));

        //get column names dynamically
        for (int i = 1; i <= colCount; i++) {
            System.out.println(rsmd.getColumnName(i));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
