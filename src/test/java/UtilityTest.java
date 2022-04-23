// 18. verify first country in countries table is Argentina (using db_util class)

import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.DB_Util;
public class UtilityTest {

    @BeforeClass
    public void setUp(){
        String url_hr = "jdbc:oracle:thin:@44.201.135.133:1521:XE";
        String userName_hr = "hr";
        String password_hr = "hr";

        DB_Util.createConnection(url_hr, userName_hr, password_hr);
    }

    @AfterClass
    public void teardown(){
        DB_Util.destroy();
    }


    @Test
    public void firstCountry(){
        String expectedValue = "Argentina";
        DB_Util.runQuery("select COUNTRY_NAME from countries where rownum = 1");
        String actualResult = DB_Util.getCellValue(1,1);
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedValue);
    }

    // 19. verify employees table has 107 row
    @Test
    public void test2(){
        int expectedValue = 107;
        DB_Util.runQuery("select * from employees");
        int actualValue = DB_Util.getRowCount();
        Assert.assertEquals(actualValue, expectedValue);
    }

    // 20. get all data from locations table
    @Test
    public void getAllData(){
        DB_Util.runQuery("select * from locations");
        DB_Util.displayAllData();
    }








}
