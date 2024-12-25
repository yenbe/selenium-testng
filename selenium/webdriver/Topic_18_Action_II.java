package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Action_II {

    WebDriver driver;
    Actions action;
    String osName = System.getProperty("os.name");
    Keys keys;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
        if (osName.startsWith("Windows")) {
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }
    }


    @Test
    public void TC_01_ClikandHold_Block() {

        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allnumber = driver.findElements(By.cssSelector("ol#selectable>li"));

        action.clickAndHold(allnumber.get(0)).moveToElement(allnumber.get(3)).release().perform();

        List<WebElement> numberslected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(numberslected.size(),4);

    }

    @Test
    public void TC_02_Clickandhold_Random() {

        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allnumber = driver.findElements(By.cssSelector("ol#selectable>li"));

        // Nhấn phím Ctrl xuống (chưa nhả)
        action.keyDown(keys).perform();
        action.click(allnumber.get(0)).click(allnumber.get(9)).click(allnumber.get(14)).click(allnumber.get(19)).perform();
        // Nha phim Ctrl
        action.keyUp(keys).perform();
        List<WebElement> numberslected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(numberslected.size(),4);

    }
    @Test
    public void TC_03_DoubleClick() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");
    }

    @Test
    public void TC_04_RightClick() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        Thread.sleep(2000);
        By quit = By.cssSelector("li.context-menu-icon-quit");
        Assert.assertTrue(driver.findElement(quit).isDisplayed());
        action.moveToElement(driver.findElement(quit)).perform();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-visible.context-menu-hover")).isDisplayed());
        action.click(driver.findElement(quit)).perform();

        driver.switchTo().alert().accept();
        Assert.assertFalse(driver.findElement(quit).isDisplayed());

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

