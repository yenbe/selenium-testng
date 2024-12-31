package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Frame_Iframe {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01() throws InterruptedException {

        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("img[alt='Campus Safety Survey']")).click();
        Thread.sleep(5000);
        // Swicth to iframe
        // dung index
        // driver.switchTo().frame(2);
        // dung name or id
        //driver.switchTo().frame("frame-one85593366");
        // dung element
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));
        // Chon du lieu cho dropdown
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Junior");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("Off Campus");
        By GenderBy = By.cssSelector("input#RESULT_RadioButton-4_1");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(GenderBy));
        Assert.assertTrue(driver.findElement(GenderBy).isSelected());
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='container']//a[text()='Log in']")).click();
        driver.findElement(By.cssSelector("button#login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");
    }

    @Test
    public void TC_02_Toidicodedao() {

        driver.get("https://toidicodedao.com/");

        driver.switchTo().frame(driver.findElement(By.cssSelector("div.fb_iframe_widget iframe")));

        By follower = By.xpath("//a[text()='Tôi đi code dạo']/parent::div/following-sibling::div[text()]");
        Assert.assertEquals(driver.findElement(follower).getText(),"405,560 followers");
    }

    @Test
    public void TC_03() throws InterruptedException {

        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='login_page']")));
        driver.findElement(By.cssSelector("input[name='fldLoginUserId'")).sendKeys("yentest");
        driver.findElement(By.cssSelector("a.login-btn")).click();
        Thread.sleep(10000);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456");
        driver.findElement(By.cssSelector("a#loginBtn")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("p.error-msg")).getText(),"Customer ID/IPIN (Password) is invalid. Please try again.");

    }
    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

