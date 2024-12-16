package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_Button {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01() {

        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By loginButton = By.cssSelector("button.fhs-btn-login");
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());
        String loginBackgroundcolor = driver.findElement(loginButton).getCssValue("background-color");

        Color logincolor = Color.fromString(loginBackgroundcolor);
        Assert.assertEquals(logincolor.asHex().toUpperCase(),"#000000");

        driver.findElement(By.id("login_username")).sendKeys("yen@gmail.com");
        driver.findElement(By.id("login_password")).sendKeys("123456");
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");
    }

    @Test
    public void TC_02() {
        driver.get("https://play.goconsensus.com/u5d5156df");
        Assert.assertFalse(driver.findElement(By.cssSelector("button[data-testid='lead form continue']")).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("button[data-testid='lead form continue']")).getCssValue("background-color")).asHex().toUpperCase(),"#673AB7");
    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

