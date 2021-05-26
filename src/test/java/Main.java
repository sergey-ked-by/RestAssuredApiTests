import browserService.ReadProperties;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Waits;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadProperties readProperties = new ReadProperties();
        String baseURL = readProperties.getURL();
        String browserType = readProperties.getBrowserName().toLowerCase();
        WebDriver driver = null;


        switch (browserType) {
            case "chrome":
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setHeadless(readProperties.getHeadless());

                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                System.out.println("Browser is not supported.");
                break;
        }

//        driver.get(baseURL);
//
//        Waits waits = new Waits(driver);
//        By selector = By.xpath("//input[@aria-label='Пошук']");
//        waits.isElementDisplayed(selector);
//        WebElement input = waits.getElementBy(selector);
//        input.click();
//        driver.quit();

//        driver.get("https://www.avito.ru/rossiya");
//        Waits waits = new Waits(driver);
//        By selector = By.xpath("//span[normalize-space()='31 136 097']");
//        WebElement element = waits.getElementBy(selector);
//        String parameter = element.getText();
//        System.out.println(parameter);
//        driver.quit();

//        driver.get("https://dev.by/");
//        Waits waits = new Waits(driver);
//        By selector = By.xpath("//a[text()='Вход']");
//        WebElement element = waits.getElementBy(selector);
//        String parameter = element.getCssValue("color");
//        System.out.println(parameter);
//        driver.quit();

//        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
//        Waits waits = new Waits(driver);
//        By visibilityOfElement = By.xpath("//h1[text()='Drag and Drop example for Selenium Tests']");
//        waits.isElementDisplayed(visibilityOfElement);
//
//        By selectorOne = By.cssSelector(".ui-widget-content.ui-draggable.ui-draggable-handle");
//        By selectorTwo = By.xpath("//div[@id='droppable']");
//        WebElement elementOne = waits.getElementBy(selectorOne);
//        WebElement elementTwo = waits.getElementBy(selectorTwo);
//
//        Actions actions = new Actions(driver);
//        actions
//                .dragAndDrop(elementOne, elementTwo)
//                .build()
//                .perform();
//
//        driver.quit();

        driver.get("https://pagination.js.org/");
        Waits waits = new Waits(driver, 1);
        By visibilityOfElement = By.xpath("//div[normalize-space()='Normal']");
        waits.isElementDisplayed(visibilityOfElement);

        By listOne = By.xpath("//div[@class='data-container']/ul/li");
        By listTwo = By.xpath("//div[@class='paginationjs-pages']/ul/li");

        List<WebElement> elements = waits.getElementsBy(listOne);
        List<WebElement> pages = waits.getElementsBy(listTwo);

        String text = elements.get(6).getText();
        System.out.println(text);

        pages.get(2).click();
        waits.isElementDismissed(elements.get(5));

        elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
        text = elements.get(6).getText();
        System.out.println(text);

        driver.quit();


    }
}
