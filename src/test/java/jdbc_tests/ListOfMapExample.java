package jdbc_tests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMapExample {


        String dbURL = "jdbc:oracle:thin:@34.230.72.55:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        @Test
        public void test1(){

            List<Map<String,Object>> querryData= new ArrayList<>();

            Map<String, Object> row1= new HashMap<>();
            row1.put("first_name","Steven");
            row1.put("last_name","King");
            row1.put("salary",24000);
            row1.put("job_id","AD_PRES");

            System.out.println(row1.toString());

            Map<String, Object> row2= new HashMap<>();
            row1.put("first_name","Nina");
            row1.put("last_name","Kochhar");
            row1.put("salary",17000);
            row1.put("job_id","AD_VP");

            System.out.println(row2.toString());

            querryData.add(row1);
            querryData.add(row2);

            //get Stevens last name

            System.out.println(querryData.get(0).get("last_name"));
            System.out.println(querryData.get(0).get("salary"));
        }
       @Test
    public void test2() throws SQLException {

           Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
           Statement statement= connection.createStatement();
           ResultSet resultSet= statement.executeQuery("SELECT first_name, last_name, salary, job_id from employees");

           //to get column
           ResultSetMetaData rsmd= resultSet.getMetaData();

           //to move first row
           resultSet.next();

           List<Map<String,Object>> querryData= new ArrayList<>();

           Map<String, Object> row1= new HashMap<>();
           row1.put(rsmd.getColumnName(1),resultSet.getString(1));
           row1.put(rsmd.getColumnName(2),resultSet.getString(2));
           row1.put(rsmd.getColumnName(3),resultSet.getString(3));
           row1.put(rsmd.getColumnName(4),resultSet.getString(4));

           //System.out.println(row1.toString());

           resultSet.next();

           Map<String, Object> row2= new HashMap<>();
           row2.put(rsmd.getColumnName(1),resultSet.getString(1));
           row2.put(rsmd.getColumnName(2),resultSet.getString(2));
           row2.put(rsmd.getColumnName(3),resultSet.getString(3));
           row2.put(rsmd.getColumnName(4),resultSet.getString(4));

           //System.out.println(row2.toString());

           querryData.add(row1);
           querryData.add(row2);

           //get Stevens last name

           System.out.println(querryData);




           resultSet.close();
           statement.close();
           connection.close();
       }




}
