package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_21_Fixed_Popup {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Ngoaingu24h() throws InterruptedException {

        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.MuiDialog-paperScrollPaper")).isDisplayed());
        driver.findElement(By.cssSelector("input[autocomplete='username']")).sendKeys("yentest");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//div[@class='forgot-password']//following-sibling::div//button")).click();
        Thread.sleep(2000);
        //String message = driver.findElement(By.cssSelector("div.SnackbarItem-message")).getText();
        //System.out.println(message);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.SnackbarItem-message")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");
        driver.findElement(By.cssSelector("button.close-btn")).click();

    }

    @Test
    public void TC_02_Kyna() {

        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        Assert.assertTrue(driver.findElement(By.cssSelector("div.k-popup-account-mb-content")).isDisplayed());
        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationtest");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");
    }

    @Test
    public void TC_03_Tiki() throws InterruptedException {

        driver.get("https://tiki.vn/");

        driver.findElement(By.cssSelector("img[alt='close-icon']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
        // Kiem tra popup hien thi
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());
        driver.findElement(By.cssSelector("p.login-with-email")).click();
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][1]")).getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][2]")).getText(),"Mật khẩu không được để trống");
        driver.findElement(By.cssSelector("img.close-img")).click();
        // Kiem tra popup ko hien thi
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(),0);
    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

