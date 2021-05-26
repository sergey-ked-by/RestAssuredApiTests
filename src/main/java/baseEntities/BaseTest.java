package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    ReadProperties readProperties;

    public BaseTest(){}

    @BeforeMethod
    public void setUp(){
        this.driver = new BrowserService().getDriver();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
