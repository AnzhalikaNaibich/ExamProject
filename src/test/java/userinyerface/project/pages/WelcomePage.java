package userinyerface.project.pages;

import org.openqa.selenium.By;
import utils.ConfigFileReader;

public class WelcomePage extends BasePage {
    private ConfigFileReader config = ConfigFileReader.configFileReader;
    private TextElement here = new TextElement(By.xpath("//*[@id=\"app\"]/div/div/div[4]/p/a"), "here");

    public WelcomePage() {
    }

    public void open() {
        browser.goTo(config.getApplicationUrl());
    }

    public void clickHere() {
        here.click();
    }
}
