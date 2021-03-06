package userinyerface.project.test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import userinyerface.framework.browser.Browser;
import java.util.concurrent.TimeUnit;
import utils.ConfigFileReader;

public class BaseTest {
    private ConfigFileReader config = ConfigFileReader.configFileReader;

    @BeforeClass
    public void before(){
        WebDriver driver = Browser.BROWSER.getDriver();
                driver.manage().timeouts().implicitlyWait(15,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
