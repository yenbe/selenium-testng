package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_31_Explicit_Ajax {

    WebDriver driver;
    WebDriverWait explicitWait;
    String uploadFileFolder = System.getProperty("user.dir") + File.separator + "uploadfile" + File.separator;
    String ninhbinh = "ninhbinh.jpg";
    String beach = "beach.jpg";

    String ninhbinhPath = uploadFileFolder + ninhbinh;
    String beachPath = uploadFileFolder + beach;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    @Test
    public void TC_01() {

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        // Verify calendar is displayed
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

        // Wait va verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe
                (By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"), "No Selected Dates to display.")));

        // Wait and click element
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='11']"))).click();
        // Wait icon loading bien mat
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

        // Wait va verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe
                (By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"), "Tuesday, February 11, 2025")));

    }

    @Test
    public void TC_02() {

        driver.get("https://gofile.io/home");
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated
                        (By.cssSelector("main#index_main>div#index_loader>div.animate-spin"))));
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(ninhbinhPath + "\n" + beachPath );



    }


    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

