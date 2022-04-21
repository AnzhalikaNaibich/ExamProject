package userinyerface.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Random;

public class FirstPage extends BasePage {
    private Button no = new Button(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/button"), "no");
    private Button helpForm = new Button(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/button/span[2]"), "helpForm");
    private TextElement timer = new TextElement(By.className("timer"), "timer");
    private TextElement password = new TextElement(By.xpath("//input[@placeholder='Choose Password']"), "password");
    private TextElement email = new TextElement(By.xpath("//input[@placeholder='Your email']"), "email");
    private TextElement domain = new TextElement(By.xpath("//input[@placeholder='Domain']"), "domain");
    private Button tld = new Button(By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div/div[1]/div/div[3]/form/div[1]/div[3]/div[4]/div/div[1]/div[2]"), "tld");
    private Button com = new Button(By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div/div[1]/div/div[3]/form/div[1]/div[3]/div[4]/div/div[2]/div[9]"), "com");
    private Button checkbox = new Button(By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div/div[1]/div/div[3]/form/div[2]/span/label/span"), "checkbox");
    private Button nextFirstPage = new Button(By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div/div[1]/div/div[3]/form/div[3]/div[1]/a"), "nextFirstPege");

    public FirstPage() {
    }

    public void dataEntry() {
        Random random = new Random();
        int n = random.nextInt(1000000);
        String string1 = "ABCDIFGHUJKLMNOPQRSTUVWXYZ";
        String string2 = "abcdefghijklmnopqrstuvwxyz";
        char x1 = string1.charAt(random.nextInt(string1.length()));
        char x2 = string1.charAt(random.nextInt(string1.length()));
        char x3 = string2.charAt(random.nextInt(string2.length()));
        char x4 = string2.charAt(random.nextInt(string2.length()));
        char x5 = string2.charAt(random.nextInt(string2.length()));

        password.clear();
        password.sendKeys("" + x1 + x2 + x3 + x4 + x5 + n);
        email.clear();
        email.sendKeys("" + x1 + x2 + x3 + x4 + x5 + n);
        domain.clear();
        domain.sendKeys("gmail");
        tld.click();
        com.click();
        checkbox.click();
        nextFirstPage.click();
        Assert.assertEquals(browser.getDriver().getCurrentUrl(), "https://userinyerface.com/game.html", "second page doesn't open");
    }

    public void closeCookie() {
        no.click();
        Assert.assertFalse(no.isDisplayed(), "popup is displayed");
    }

    public void closeHelpForm() {
        helpForm.click();
        Assert.assertFalse(no.isDisplayed(), "popup is displayed");
    }

    public void counterData() {
        String valueTimer = timer.getText();
        System.out.println("значение таймера " + valueTimer);
        Assert.assertNotNull(valueTimer, "value timer doesn't found");
    }

    public void updateDataTimer() {
        JavascriptExecutor js = (JavascriptExecutor) browser.getDriver();
        js.executeScript("timer.duration._milliseconds = 0");
    }

}

