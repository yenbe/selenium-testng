package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_24_JavascriptExecutor {

    WebDriver driver;
    JavascriptExecutor jsExecutor;
    Random random;
    String email;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        email = "yen" + new Random().nextInt(999) + "@gmail.net";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01() throws InterruptedException {

        jsExecutor.executeScript("window.location = 'http://live.techpanda.org/' ");
        Thread.sleep(2000);
        String pagedomain = (String) jsExecutor.executeScript("return document.domain;");
        Assert.assertEquals(pagedomain,"live.techpanda.org");
        String pageURL = (String) jsExecutor.executeScript("return document.URL;");
        Assert.assertEquals(pageURL,"http://live.techpanda.org/");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Mobile']")));
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].click();", driver.findElement
                (By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']/button")));
        Thread.sleep(2000);
        String message = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(message.contains("IPhone was added to your shopping cart."));
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Customer Service']")));
        Thread.sleep(2000);
        String pageTitle = (String) jsExecutor.executeScript("return document.title;");
        Assert.assertEquals(pageTitle,"Customer Service");
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("input#newsletter")));
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + email + "')", driver.findElement(By.cssSelector("input#newsletter")));
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("button[title='Subscribe']")));
        //driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String subText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(subText.contains("Thank you for your subscription."));
        jsExecutor.executeScript("window.location = 'https://www.facebook.com/' ");

    }

    @Test
    public void TC_03() {

        driver.get("https://warranty.rode.com/login");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        // empty
        loginButton.click();
        String emptyemailmess = getElementValidationMessage("//input[@id='email']");
        Assert.assertEquals(emptyemailmess,"Please fill out this field.");
        // invalid email
        driver.findElement(By.cssSelector("input#email")).sendKeys("aaa");
        loginButton.click();
        String invalidemailmess = getElementValidationMessage("//input[@id='email']");
        Assert.assertEquals(invalidemailmess,"Please enter an email address.");

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }
    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
}

