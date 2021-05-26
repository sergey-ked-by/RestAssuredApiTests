package browserService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserService {
    WebDriver driver;

    //driver = new ChromeDriver();

    public WebDriver getDriver() {
        return driver;
    }
}
