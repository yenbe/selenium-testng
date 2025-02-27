package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_Listener {
    public WebDriver getDriver(){
        return driver;
    }

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @Test
    public void TC_01_Login() throws InterruptedException {

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("input[type= 'email']")).sendKeys("aa12@gmail.com");
        driver.findElement(By.cssSelector("input[type= 'password']")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();
        //driver.switchTo().alert().accept();
        Thread.sleep(2000);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='account-cart-wrapper']" +
                "//span[text()='Account']"))).click();
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Log Out']"))).click();
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
