package userinyerface.project.test;
import org.testng.annotations.Test;
import userinyerface.project.pages.FirstPage;
import userinyerface.project.pages.SecondPage;
import userinyerface.project.pages.WelcomePage;

public class MyTest extends BaseTest {
    WelcomePage welcomePage = new WelcomePage();
    FirstPage firstPage = new FirstPage();
    SecondPage secondPage = new SecondPage();

    @Test
    public void Authorization() throws InterruptedException {
        welcomePage.open();
        welcomePage.clickHere();
        firstPage.dataEntry();
        secondPage.selectCategories();
        secondPage.uploadImage();
        secondPage.clickNext();
    }

    @Test
    public void CheckPopupAndTimer() {
        welcomePage.open();
        welcomePage.clickHere();
        firstPage.closeCookie();
        firstPage.closeHelpForm();
        firstPage.counterData();
        firstPage.updateDataTimer();
    }
}
