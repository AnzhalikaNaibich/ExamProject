package userinyerface.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SecondPage extends BasePage {
    private Button unselectAll = new Button(By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div/div[1]/div/div[3]/div/div[21]/div/span[1]/label/span/span"), "unselectAll");
    private Button uploadButton = new Button(By.xpath("//*[@id=\"app\"]/div//p/a"), "uploadButton");
    private Button nextSecondPage = new Button(By.cssSelector("[class*='button--stroked']"), "nextSecondPage");
    private By imageIndicator = By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div/div[1]/div/div[2]/div/div[1]/div/div[2]");
    public SecondPage() {
    }

    public void selectCategories() {
        unselectAll.click();
        List <WebElement> interests = browser.getDriver().findElements(By.cssSelector("[class*='checkbox small']"));
            Random random = new Random();
        for (int i = 0; i < 3; i++) {
            interests.get(random.nextInt(interests.size()-1)).click();
        }
    }

    public void uploadImage() {
        uploadButton.click();
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(imageIndicator));
    }

    public void clickNext() {
        nextSecondPage.click();
    }
}
