package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_26_Wait_Element_Status {

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Visible() {

        driver.get("https://www.facebook.com/");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email"))).sendKeys("aaa");


    }

    @Test
    public void TC_02_Invisible() {

        driver.get("https://www.facebook.com/");

    }

    @Test
    public void TC_03_Presence() {

        driver.get("https://www.facebook.com/");

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

