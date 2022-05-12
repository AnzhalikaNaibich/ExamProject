package userinyerface.framework.browser.elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import userinyerface.framework.browser.Browser;
import utils.ConfigFileReader;

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

        private WebElement findElement(){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            return driver.findElement(locator);
        }

        public void click() {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                findElement().click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void sendKeys(String text) {
            try {
                findElement().sendKeys(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getText() {
            try {
                return findElement().getText();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public String getAttribute(String name) {
            try {
                return findElement().getAttribute(name);
            } catch (Exception e) {
                e.printStackTrace(); //Logger.error("element" + name + "hasn't be found");
            }
            return null;
        }

        public String getHref() {
            return getAttribute("href");
        }

        public void clear() {
            try {
                findElement().clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }