package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_I {

    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }


    @Test
    public void TC_01_Hover() throws InterruptedException {

        driver.get("https://automationfc.github.io/jquery-tooltip/");
        action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");

    }

  //  @Test
  //  public void TC_02() throws InterruptedException {

    //    driver.get("http://www.myntra.com/");

   //     action.moveToElement(driver.findElement(By.xpath("//a[text()='Kids' and @class = 'desktop-main']"))).perform();
   //     Thread.sleep(2000);
   //     driver.findElement(By.xpath("//a[text()='Home & Bath']")).click();
  //      Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Kids Home Bath']")).getText(),"Kids Home Bath");

   // }

    @Test
    public void TC_03() throws InterruptedException {
        driver.get("https://www.fahasa.com/");
        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//span[text()='Đồ Chơi']"))).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Đồ Chơi Giáo Dục']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Đồ Chơi Giáo Dục']")).isDisplayed());

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

