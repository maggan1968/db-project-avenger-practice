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
        ResultSet rs_hr1 = stmt_hr.executeQuery("SELECT first_name from employees");
        rs_hr1.next();
        System.out.println(rs_hr1.getString(1));
        rs_hr1.next();
        System.out.println(rs_hr1.getString(1));


    }



}