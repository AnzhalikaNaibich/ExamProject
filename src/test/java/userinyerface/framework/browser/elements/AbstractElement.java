package userinyerface.framework.browser.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import userinyerface.framework.browser.Browser;
import utils.ConfigFileReader;
import utils.Logger;

public abstract class AbstractElement {
    private static ConfigFileReader config = ConfigFileReader.configFileReader;
    private By locator;
    private String name;
    private WebDriver driver;
    private WebDriverWait wait;

    public AbstractElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
        driver = Browser.BROWSER.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(config.getTimeWait()));
    }

    private WebElement findElement() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return driver.findElement(locator);
    }

    public void click() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            findElement().click();
            Logger.info("clickable");
        } catch (Exception e) {
            Logger.error("button doesn't clickable");
        }
    }

    public void sendKeys(String text) {
        try {
            findElement().sendKeys(text);
            Logger.info("text" + text + "is send");
        } catch (Exception e) {
            Logger.error("text" + text + "doesn't send");
        }
    }

    public String getText() {
        try {
            return findElement().getText();
        } catch (Exception e) {
            Logger.error("text doesn't be found");
            ;
        }
        return null;
    }

    public String getAttribute(String name) {
        try {
            return findElement().getAttribute(name);
        } catch (Exception e) {
            Logger.error("element" + name + "doesn't found");
        }
        return null;
    }

    public String getHref() {
        return getAttribute("href");
    }

    public void clear() {
        try {
            findElement().clear();
            Logger.info("the field is empty");
        } catch (Exception e) {
            Logger.error("the field doesn't be clear");
        }
    }

    public Boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (Exception e) {
            Logger.error("element" + name + "doesn't found");
        }
        return false;
    }
}