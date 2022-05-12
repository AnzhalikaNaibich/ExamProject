package userinyerface.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SecondPage extends BasePage {
    private Button unselectAll = new Button(By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div/div[1]/div/div[3]/div/div[21]/div/span[1]/label/span"), "unselectAll");
    private Button uploadButton = new Button(By.xpath("//*[@id=\"app\"]/div//p/a"), "uploadButton");
    private Button nextSecondPage = new Button(By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div/div[2]/div/div/div[1]/button"), "nextSecondPage");

    public SecondPage() {
    }

    public void selectCategories() {
        unselectAll.click();

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            Button selectInterests = new Button(By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div/div[1]/div/div[3]/div/div[" + random.nextInt(1, 20) + "]/div/span[1]/label/span"), "selectInterests");
            selectInterests.click();
        }
    }

    public void uploadImage() throws InterruptedException {
        uploadButton.click();
        Thread.sleep(15000);
    }

    public void clickNext() {
        nextSecondPage.click();
    }
}
