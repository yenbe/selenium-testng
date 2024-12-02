package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Element_Excercise {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // Ap dung cho tat ca cac loai element
        // element.isDisplayed();

    // Kiem tra 1 element da dc chon hay chua (checkbox, radio, dropdown)
        // element.isSelected();

    // Kiem tra 1 element co cho phep thao tac len hay ko? (cho phep sua du lieu hay ko?)
    // true = cho phép
    // false = bi disable
    // Test tính năng phân quyền
        // element.isEnabled();
    @Test
    public void TC_01_Display() {
       driver.get("https://automationfc.github.io/basic-form/index.html");
       if (driver.findElement(By.id("mail")).isDisplayed()) {
           driver.findElement(By.id("mail")).sendKeys("Automation Test");
           System.out.println("Email textbox is displayed");
       } else {
           System.out.println("Email textbox is not displayed");
       }
       if (driver.findElement(By.id("under_18")).isDisplayed()){
           driver.findElement(By.id("under_18")).click();
           System.out.println("Age under 18 is displayed");
       } else {
           System.out.println("Age under 18 is not displayed");
       }
       if (driver.findElement(By.id("edu")).isDisplayed()) {
            driver.findElement(By.id("edu")).sendKeys("Automation Test");
            System.out.println("Education textbox is displayed");
        } else {
            System.out.println("Education textbox is not displayed");
        }
        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            driver.findElement(By.xpath("//h5[text()='Name: User5']/following-sibling::a")).click();
            System.out.println("Name User 5 Text is displayed");
        } else {
            System.out.println("Name User 5 Text is not displayed");
        }
    }

    @Test
    public void TC_02_Enable() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.id("mail")).isEnabled()) {
            System.out.println("Email textbox is enabled");
        } else {
            System.out.println("Email textbox is disabled");
        }
        if (driver.findElement(By.id("slider-2")).isEnabled()) {
            System.out.println("slider-2 is enabled");
        } else {
            System.out.println("slider-2 is disabled");
        }
        if (driver.findElement(By.id("development")).isEnabled()) {
            System.out.println("development is enabled");
        } else {
            System.out.println("development is disabled");
        }
    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.id("under_18")).click();
        driver.findElement(By.id("java")).click();
        if (driver.findElement(By.id("under_18")).isSelected()) {
            System.out.println("Age under 18 is Selected");
        } else {
            System.out.println("Age under 18 is deSelected");
        }
        if (driver.findElement(By.id("java")).isSelected()) {
            System.out.println("java checkbox is Selected");
        } else {
            System.out.println("java checkbox is deSelected");
        }
        driver.findElement(By.id("under_18")).click();
        driver.findElement(By.id("java")).click();
        if (driver.findElement(By.id("under_18")).isSelected()) {
            System.out.println("Age under 18 is Selected");
        } else {
            System.out.println("Age under 18 is deSelected");
        }
        if (driver.findElement(By.id("java")).isSelected()) {
            System.out.println("java checkbox is Selected");
        } else {
            System.out.println("java checkbox is deSelected");
        }
    }
    @Test
    public void TC_04_Register_Mailchimp() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
        By signupButton = By.id("create-account-enabled");

        driver.findElement(By.id("email")).sendKeys("yen@gmail.com");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();

        Thread.sleep(3000);
        // Empty
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());

        //Lowercase
        driver.findElement(By.id("new_password")).sendKeys("abc");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());

        //uppercase
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("ABC");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());

        // Number
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("123");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());

        //special
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("@!");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());

        //username
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("auto");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());

        //8 char
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("Automation");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());

        // Full
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("Selenium@1");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signupButton));
        driver.findElement(signupButton).click();
        Thread.sleep(3000);

        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.id("marketing_newsletter")).isSelected());

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

