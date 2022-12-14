package jdbc_tests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBUtilPractice {

    @Test
    public void test1(){

        DBUtils.createConnection();

        String querry= "SELECT first_name,last_name, salary, job_id from employees where rownum <6";

        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(querry);

        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());

        }

        DBUtils.destroy();
    }
}
