package userinyerface.project.test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import userinyerface.project.pages.*;
import userinyerface.project.pages.Button;

public class MyTest extends BaseTest {
    private TextElement thirdPageIndicator = new TextElement(By.className("personal-details"), "thirdPageIndicator");
    private Button no = new Button(By.cssSelector("[class*='button--transparent']"), "no");
    private Button helpForm = new Button(By.cssSelector("[class*='help-form__send-to-bottom-button']"), "helpForm");
    @Test
    public void Authorization() {
        WelcomePage welcomePage = new WelcomePage();
        FirstPage firstPage = new FirstPage();
        SecondPage secondPage = new SecondPage();
        welcomePage.open();
        welcomePage.clickHere();
        firstPage.dataEntry();
        secondPage.selectCategories();
        secondPage.uploadImage();
        secondPage.clickNext();
        Assert.assertTrue("third page doesn't open", thirdPageIndicator.isDisplayed());
    }

    @Test
    public void CheckPopupAndTimer() {
        WelcomePage welcomePage = new WelcomePage();
        FirstPage firstPage = new FirstPage();
        welcomePage.open();
        welcomePage.clickHere();
        firstPage.closeCookie();
        firstPage.closeHelpForm();
        firstPage.counterData();
        firstPage.updateDataTimer();
        Assert.assertFalse("cookie is displayed", no.isDisplayed());
        Assert.assertFalse("helpForm is displayed", helpForm.isDisplayed());
    }
}
