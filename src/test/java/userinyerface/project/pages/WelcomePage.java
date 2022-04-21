package userinyerface.project.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.ConfigFileReader;

public class WelcomePage extends BasePage {
    private ConfigFileReader config = ConfigFileReader.configFileReader;
    private TextElement here = new TextElement(By.xpath("//*[@id=\"app\"]/div/div/div[4]/p/a"), "here");

    public WelcomePage() {
    }

    public void open() {
        browser.goTo(config.getApplicationUrl());
        Assert.assertEquals(browser.getDriver().getCurrentUrl(), "https://userinyerface.com/game.html%20target=", "second page doesn't open");
    }

    public void clickHere() {
        here.click();
        Assert.assertEquals(browser.getDriver().getCurrentUrl(), "https://userinyerface.com/game.html", "second page doesn't open");
    }
}
