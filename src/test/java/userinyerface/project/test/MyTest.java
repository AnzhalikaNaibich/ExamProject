package userinyerface.project.test;
import org.testng.annotations.Test;
import userinyerface.project.pages.FirstPage;
import userinyerface.project.pages.SecondPage;
import userinyerface.project.pages.WelcomePage;

public class MyTest extends BaseTest {

    @Test
    public void Authorization() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.open();
        welcomePage.clickHere();

        FirstPage firstPage = new FirstPage();
        firstPage.dataEntry();

        SecondPage secondPage = new SecondPage();
        secondPage.selectCategories();
        secondPage.uploadImage();
        secondPage.clickNext();
    }

}
