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
import java.util.Date;

public class Topic_32_Mix {

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Element_Found() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Wait voi Explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
        // Wait voi Implicit
        driver.findElement(By.cssSelector("input#email"));

    }

    @Test
    public void TC_02_Element_NotFound() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        // Wait voi Implicit
        driver.findElement(By.cssSelector("input#a"));
    }

    @Test
    public void TC_03_Element_NotFound_Explicit() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        // Wait voi Explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#a")));
    }
    @Test
    public void TC_03_Element_NotFound_Explicit_WebElemet() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        // Wait voi Explicit
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#a"))));
    }
    @Test
    public void TC_04_Element_NotFound_Mix() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        // Wait voi Explicit
        System.out.println("Start = " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#e")));
        } catch (Exception e) {
            System.out.println("End = " + getDateTimeNow());
            throw new RuntimeException(e);
        }


    }
    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

