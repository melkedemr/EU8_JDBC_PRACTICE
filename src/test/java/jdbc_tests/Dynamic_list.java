package jdbc_tests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class Dynamic_list {

    String dbURL = "jdbc:oracle:thin:@34.230.72.55:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("SELECT * from departments");

        //to get column
        ResultSetMetaData rsmd= resultSet.getMetaData();

        int colCount= rsmd.getColumnCount();

        List<Map<String,Object>> querryData= new ArrayList<>();

        while(resultSet.next()){
            Map<String, Object> row = new LinkedHashMap<>();

            for (int i = 1; i <= colCount ; i++) {
                row.put(rsmd.getColumnName(i),resultSet.getObject(i));

            }

            querryData.add(row);

        }
        for (Map<String, Object>row : querryData) {
            System.out.println(row.toString());

        }

        System.out.println(querryData);




        resultSet.close();
        statement.close();
        connection.close();
    }




}


