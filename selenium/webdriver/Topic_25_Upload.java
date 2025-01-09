package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_25_Upload {

    WebDriver driver;
    String uploadFileFolder = System.getProperty("user.dir") + File.separator + "uploadfile" + File.separator;
    String ninhbinh = "ninhbinh.jpg";
    String beach = "beach.jpg";

    String ninhbinhPath = uploadFileFolder + ninhbinh;
    String beachPath = uploadFileFolder + beach;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Single_File() throws InterruptedException {

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By inputBy = By.xpath("//input[@type='file']");

        // Load file lên
        driver.findElement(inputBy).sendKeys(ninhbinhPath);
        Thread.sleep(2000);
        driver.findElement(inputBy).sendKeys(beachPath);
        Thread.sleep(2000);

        // Verify da load file len
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= '" + beach + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='ninhbinh.jpg']")).isDisplayed());

        // Click de upload file len
        List<WebElement> startButtons = driver.findElements(By.cssSelector("td button.start"));
        for (WebElement startButton : startButtons) {
            startButton.click();
            Thread.sleep(2000);
        }

        // Verify upload file thanh cong
        Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + ninhbinh +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + beach +"']")).isDisplayed());

    }

    @Test
    public void TC_02_Multiple_File() throws InterruptedException {

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By inputBy = By.xpath("//input[@type='file']");

        // Load file lên
        driver.findElement(inputBy).sendKeys(ninhbinhPath + "\n" + beachPath);
        Thread.sleep(2000);


        // Verify da load file len
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= '" + beach + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='ninhbinh.jpg']")).isDisplayed());

        // Click de upload file len
        List<WebElement> startButtons = driver.findElements(By.cssSelector("td button.start"));
        for (WebElement startButton : startButtons) {
            startButton.click();
            Thread.sleep(2000);
        }

        // Verify upload file thanh cong
        Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + ninhbinh +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + beach +"']")).isDisplayed());


    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

