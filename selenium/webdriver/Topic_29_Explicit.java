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

public class Topic_29_Explicit {

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01() {

        // Wait cho 1 element hien thi (trong HTML va UI)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));

        // Wait cho 1 element ko hien thi , ko con trong HTML (truoc do co hien thi)
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // Wait cho 1 element ko hien thi ( còn hoặc ko còn trong HTML)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // Wait cho element được phép click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // Wait cho Alert xuất hiện trong HTML
        explicitWait.until(ExpectedConditions.alertIsPresent());

        // Wait cho 1 elemet đã được chọn thành công (button/radio/dropdown)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // Wait cho 1 elemet đã được chọn thành công
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), true));

        // Wait cho 1 elemet chưa được chọn thành công
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), false));

        // Wait cho frame/iframe xuất hiện và switch vào
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));

        // Wait cho 1 list element bằng bao nhiêu item
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""), 6));

        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""), 7)); // ít hơn
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""), 5)); // nhiều hơn

        // Wait cho số Window/Tab bằng bao nhiêu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));

        // Wait cho 1 đoạn text bằng tuyệt đối
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""), "Hello"));
        



    }


    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

