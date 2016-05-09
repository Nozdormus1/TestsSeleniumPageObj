/**
 * Created by НОЗДОРМУ on 09.05.2016.
 */

import java.util.concurrent.TimeUnit;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import pages.AutoFlights;
        import org.junit.*;

public class TestFlightsFill {

    WebDriver driver;
    AutoFlights objFlights;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/Flights");
    }

    @Test
    public void test_Home_Page_Appear_Correct(){
        //Create Flights Page object
        objFlights = new AutoFlights(driver);
        //fill Flight Page
        objFlights.autoField(false, "Kiev", "Lviv", "01/02/2017", "01/02/2017", "2", "0", "Business");
    }
}
