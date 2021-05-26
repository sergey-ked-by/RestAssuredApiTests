package utils;

import browserService.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.util.List;

public class Waits {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public Waits(WebDriver driver, int timeOut) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, timeOut);
    }

    public Waits(WebDriver driver) {
        this.driver = driver;
        ReadProperties readProperties = new ReadProperties();
        webDriverWait = new WebDriverWait(driver, readProperties.getTimeOut());
    }

    public WebElement isElementLocated(By by) {
        try {
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException ex) {
            return null;
        }
    }
    public Boolean isElementDismissed(WebElement webElement) {
        try {
            return webDriverWait.until(ExpectedConditions.stalenessOf(webElement));
        } catch (TimeoutException ex) {
            return null;
        }
    }

    public WebElement getElementBy(By by) {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException ex) {
            return null;
        }
    }

    public boolean isElementDisplayed(By by) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public List<WebElement> getElementsBy(By by) {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (TimeoutException ex) {
            return null;
        }
    }
}
