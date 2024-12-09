package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Textbox_Textarea {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void TC_01_Techpanda() throws InterruptedException {

        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();

        String firtname = "Yen";
        String lastname = "be";
        String fullname = firtname + " " + lastname;
        String emailAddress = "yenbe" + new Random().nextInt(999) + "@gmail.vn";
        String password = "123456";
        String thoughtReview = "ok\nhihi";
        String summaryreview = "ok";
        String nickname = "Yenbe";


        driver.findElement(By.id("firstname")).sendKeys(firtname);
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        driver.findElement(By.id("email_address")).sendKeys(emailAddress);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");
        String ContactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(ContactInfo.contains(fullname));
        Assert.assertTrue(ContactInfo.contains(emailAddress));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.id("review_field")).sendKeys(thoughtReview);
        driver.findElement(By.id("summary_field")).sendKeys(summaryreview);
        driver.findElement(By.id("nickname_field")).clear();
        driver.findElement(By.id("nickname_field")).sendKeys(nickname);
        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");

    }

    @Test
    public void TC_02_OrangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String firtname = "Yen";
        String lastname = "be";
        String username = "yen" + new Random().nextInt(999);
        String password = "1234567a";
        String Number = "1111-222-333-444";
        String Comment = "yen\ntest";

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[text()='PIM']/parent::a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firtname);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastname);
        String employeeID = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
                .getAttribute("value");
        driver.findElement(By.cssSelector("span.oxd-switch-input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(username);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(6000);

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"),firtname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"),lastname);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div//input")).getAttribute("value"),employeeID);

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();
        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(Number);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(Comment);
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(7000);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),Number);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"),Comment);

        driver.findElement(By.cssSelector("span.oxd-userdropdown-tab")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"),firtname);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"),lastname);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div//input"))
                .getAttribute("value"),employeeID);
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div//input")).isEnabled());

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),Number);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"),Comment);


    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

