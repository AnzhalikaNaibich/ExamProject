package userinyerface.project.pages;
import org.openqa.selenium.By;
import utils.ConfigFileReader;

public class WelcomePage extends BasePage {
    private ConfigFileReader config = ConfigFileReader.configFileReader;
    private TextElement here = new TextElement(By.xpath("//a[@Class='start__link']"), "here");

    public WelcomePage() {
    }

    public void open() {
        browser.goTo(config.getApplicationUrl());
    }

    public void clickHere() {
        here.click();
    }
}
