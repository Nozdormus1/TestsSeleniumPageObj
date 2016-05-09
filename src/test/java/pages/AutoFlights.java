/**
 * Created by НОЗДОРМУ on 09.05.2016.
 */

        package pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.ui.Select;


public class AutoFlights {

    WebDriver driver;
    By oneWay = By.id("flight-type-one-way");
    By roundTrip = By.id("flight-type-roundtrip");
    By flightOrigin = By.id("flight-origin");
    By flightDestination = By.id("flight-destination");
    By departingDate = By.id("flight-departing");
    By returningDate = By.id("flight-returning");
    By adultsCount = By.id("flight-adults");
    By childrenCount = By.id("flight-children");
    By advancedOptions = By.linkText("Advanced options");
    By flightClass = By.id("flight-advanced-preferred-class");
    By searchButton = By.id("search-button");

    public AutoFlights(WebDriver driver) {
        this.driver = driver;
    }

    //Set flight mode
    public void setFlightMode(boolean setOneWayDirection) {
        if (setOneWayDirection) {
            driver.findElement(oneWay).click();
        } else {
            driver.findElement(roundTrip).click();
        }
    }

    //Set flight origin
    public void setFlightOrigin(String strFlightOrigin) {
        driver.findElement(flightOrigin).clear();
        driver.findElement(flightOrigin).sendKeys(strFlightOrigin);
    }

    //Set flight destination
    public void setFlightDestination(String strFlightDestination) {
        driver.findElement(flightDestination).clear();
        driver.findElement(flightDestination).sendKeys(strFlightDestination);
    }

    //Set departing date
    public void setDepartingDate(String strDepartingDate) {
        driver.findElement(departingDate).clear();
        driver.findElement(departingDate).sendKeys(strDepartingDate);
    }

    //Set returning date
    public void setReturningDate(String strReturningDate) {
        driver.findElement(returningDate).clear();
        driver.findElement(returningDate).sendKeys(strReturningDate);
    }

    //Set number of adults
    public void setAdultsCount(String strAdultsCount) {
        Select adultsDropdown = new Select(driver.findElement(adultsCount));
        adultsDropdown.selectByVisibleText(strAdultsCount);
    }

    //Set number of children
    public void setChildrenCount(String strChildrenCount) {
        Select childrenDropdown = new Select(driver.findElement(childrenCount));
        childrenDropdown.selectByVisibleText(strChildrenCount);
    }

    //Click on advanced options
    public void clickAdvancedOptions() {
        driver.findElement(advancedOptions).click();
    }

    //Set flight class
    public void setFlightClass(String strFlightClass) {
        Select flightClassDropdown = new Select(driver.findElement(flightClass));
        flightClassDropdown.selectByVisibleText(strFlightClass);
    }

    //Click on search
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    /**
     * Main class
     */
    public void autoField(boolean setOneWayDirection, String strFlightOrigin, String strFlightDestination, String strDepartingDate, String strReturningDate, String strAdultsCount, String strChildrenCount, String strFlightClass) {
        //set flight mode
        this.setFlightMode(setOneWayDirection);
        //Fill flight origin
        this.setFlightOrigin(strFlightOrigin);
        //Fill flight destination
        this.setFlightDestination(strFlightDestination);
        //Fill departing date
        this.setDepartingDate(strDepartingDate);
        //Fill returning date
        if(setOneWayDirection == false) {
            this.setReturningDate(strReturningDate);
        }
        //Fill number of adults
        this.setAdultsCount(strAdultsCount);
        //Fill number of children
        this.setChildrenCount(strChildrenCount);
        //Click Advanced options hyperlink
        this.clickAdvancedOptions();
        //Fill flight class
        this.setFlightClass(strFlightClass);
        //Click Search button
        this.clickSearchButton();
    }
}