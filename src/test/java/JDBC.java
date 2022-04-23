import java.sql.*;

public class JDBC {

    /*
    Please use JDBC for below tasks
    1. get connection with hr database
    2. get connection with spartan database
    3. get top 2 first names from employees table using next() and different method
    4. get top 3 phone numbers from spartans table using next() and different method
    5. get every country name from countries table
    6. get every spartan name from spartans table
    7. get me first department name from departments table
    8. get me last street address from locations table
    9. get me "ResultSet.next was not called" exception
    10. get me "Result set after last row" exception
    11. get me 10th spartans's gender
    12. get me 5th job_title from jobs table
    13. get me the first created date(not including time) in spartans table
    14. get me 5th manager_id from departments table (dont' use getString() method)
    15. get me the highest salary from employees table ( don't use getInt or getString method)
    16. get me column numbers of spartans table
    17. get me all column names from job_history table
    18. value first country in countries table is Argentina (using db_util class)
    19. value employees table has 107 row (using db_util class)
    20. get all data from locations table (using db_util class)
     */


    public static void main(String[] args) throws SQLException {

        // 1. get connection with hr database
        //    2. get connection with spartan database

        String url_hr = "jdbc:oracle:thin:@44.201.135.133:1521:XE";
        String userName_hr = "hr";
        String password_hr = "hr";

        Connection conn_hr = DriverManager.getConnection(url_hr, userName_hr, password_hr);
        Statement stmt_hr = conn_hr.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String url_sp = "jdbc:oracle:thin:@44.201.135.133:1521:XE";
        String userName_sp = "SP";
        String password_sp = "SP";

        Connection conn_sp = DriverManager.getConnection(url_sp, userName_sp, password_sp);
        Statement stmt_sp = conn_sp.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //3. get top 2 first names from employees table using next()
//        ResultSet rs_hr1 = stmt_hr.executeQuery("SELECT * from employees");
//        rs_hr1.next();
//        System.out.println(rs_hr1.getString(2));
//        rs_hr1.next();
//        System.out.println(rs_hr1.getString("LAST_NAME"));

        //4. get top 3 phone numbers from spartans table using next()
//        ResultSet rs_sp1 = stmt_sp.executeQuery("select * from spartans");
//        rs_sp1.next();
//        System.out.println(rs_sp1.getString(4));
//        rs_sp1.next();
//        System.out.println(rs_sp1.getString("PHONE"));
//        rs_sp1.next();
//        System.out.println(rs_sp1.getString(4));

        // 5. get every country name from countries table
//        ResultSet rs_hr2 = stmt_hr.executeQuery("SELECT country_name from countries");
//        while(rs_hr2.next()){
//            System.out.println(rs_hr2.getString(1));
//        }

        //  6. get every spartan name from spartans table
//        ResultSet rs_sp2 = stmt_sp.executeQuery("select name from spartans");
//        while (rs_sp2.next()){
//            System.out.println(rs_sp2.getString(1));
//        }

        // 7. get me first department name from departments table
//        ResultSet rs_hr3 = stmt_hr.executeQuery("select department_name from departments");
//        rs_hr3.next();
//        System.out.println(rs_hr3.getString(1));

        // 8. get me last street address from locations table
//        ResultSet rs_hr4 = stmt_hr.executeQuery("select STREET_ADDRESS from locations");
//        rs_hr4.last();
//        System.out.println(rs_hr4.getString(1));

        // 9. get me "ResultSet.next was not called" exception
        ResultSet rs_hr5 = stmt_hr.executeQuery("select * from employees");
//        System.out.println(rs_hr5.getString(1));

        // 10. get me "Result set after last row" exception
        rs_hr5.afterLast();
//        System.out.println(rs_hr5.getString(1));


        // 11. get me 10th spartans's gender
        ResultSet rs_sp3 = stmt_sp.executeQuery("select gender from spartans");
//        rs_sp3.absolute(10);
//        System.out.println(rs_sp3.getString(1));

        // 12. get me 5th job_title from jobs table
        ResultSet rs_hr6 = stmt_hr.executeQuery("select JOB_TITLE from jobs");
        rs_hr6.absolute(5);
//        System.out.println(rs_hr6.getString(1));

        // 13. get me the first created date(not including time) in spartans table
        ResultSet rs_sp4 = stmt_sp.executeQuery("select CREATED_AT from spartans");
        rs_sp4.next();
//        System.out.println(rs_sp4.getDate(1));


        // 14. get me 5th manager_id from departments table (dont' use getString() method)
//        ResultSet rs_hr7 = stmt_hr.executeQuery("select MANAGER_ID from departments");
//        rs_hr7.absolute(5);
//        System.out.println(rs_hr7.getInt(1));

        // 15. get me the highest salary from employees table ( don't use getInt or getString method)
//        ResultSet rs_hr7 = stmt_hr.executeQuery("select max(salary) from employees");
//        rs_hr7.next();
//        System.out.println(rs_hr7.getDouble(1));


        // 16. get me column numbers of spartans table
//        ResultSet rs_sp5 = stmt_sp.executeQuery("select * from spartans");
//        ResultSetMetaData rsmd_sp = rs_sp5.getMetaData();
//        System.out.println(rsmd_sp.getColumnCount());


        // 17. get me all column names from job_history table
        ResultSet rs_hr8 = stmt_hr.executeQuery("select * from job_history");
        ResultSetMetaData rsmd_hr = rs_hr8.getMetaData();
        int columnCount = rsmd_hr.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rsmd_hr.getColumnName(i));
        }


    }



}