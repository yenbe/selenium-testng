package webdriver;

import graphql.schema.diffing.Edge;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_11_Default_Dropdown {

    WebDriver driver;
    Select select;

    @BeforeClass
    public void beforeClass() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:/Users/Admin/AppData/Local/Microsoft/Edge/User Data/");
        edgeOptions.addArguments("--profile-directory=Profile 1");
        driver = new EdgeDriver(edgeOptions);
        // driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void TC_01_Facebook_SignUp() {

        driver.get("https://www.facebook.com/r.php");

        select = new Select(driver.findElement(By.id("day")));
        // Chon 1 item
        select.selectByVisibleText("25");
        // Verify du lieu chon da dung chua?
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"25");
        // Verify dropdown co phai multiple hay ko?
        // Neu la multiple -> true, single -> false
        Assert.assertFalse(select.isMultiple());
        // Verify tong so item trong dropdown
        Assert.assertEquals(select.getOptions().size(),31);

        select = new Select(driver.findElement(By.id("month")));
        select.selectByVisibleText("Nov");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Nov");

        select = new Select(driver.findElement(By.id("year")));
        select.selectByVisibleText("1997");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1997");


    }

    @Test
    public void TC_02_NopCM() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");

        String email = "yen" + new Random().nextInt(999) + "@gmail.com";

        driver.findElement(By.xpath("//a[text()='Register']")).click();
        driver.findElement(By.id("FirstName")).sendKeys("yen");
        driver.findElement(By.id("LastName")).sendKeys("dao");
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("DateOfBirthDay")));
        select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
        select.selectByVisibleText("1");
        Assert.assertEquals(select.getOptions().size(),32);
        select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
        select.selectByVisibleText("May");
        Assert.assertEquals(select.getOptions().size(),13);
        select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
        select.selectByVisibleText("1980");
        Assert.assertEquals(select.getOptions().size(),112);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

        driver.findElement(By.cssSelector("a.ico-account")).click();
        // select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(),"1");
        // select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(),"May");
        // select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(),"1980");

    }

    @Test
    public void TC_03_Rode() {
        driver.get("https://www.rode.com/wheretobuy");

        new Select(driver.findElement(By.id("country"))).selectByVisibleText("Vietnam");
        driver.findElement(By.id("map_search_query")).sendKeys("Ho chi minh");
        driver.findElement(By.cssSelector("button.btn-default")).click();

        List <WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));
        Assert.assertEquals(dealers.size(),16);

        for (WebElement element: dealers) {
            System.out.println(element.getText());
        }

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

