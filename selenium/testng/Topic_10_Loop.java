package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Loop {

    WebDriver driver;
    String firtname = "Yen";
    String lastname = "be";
    String fullname = firtname + " " + lastname;
    String password = "123456";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }


    @Test(invocationCount = 3)
    public void TC_01_Register() throws InterruptedException {

        driver.get("http://live.techpanda.org/");
        String emailAddress = "yenbe" + new Random().nextInt(999) + "@gmail.vn";
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        driver.findElement(By.id("firstname")).sendKeys(firtname);
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        driver.findElement(By.id("email_address")).sendKeys(emailAddress);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");
        String ContactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']" +
                "/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(ContactInfo.contains(fullname));
        Assert.assertTrue(ContactInfo.contains(emailAddress));

        driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        System.out.println(emailAddress);
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}

