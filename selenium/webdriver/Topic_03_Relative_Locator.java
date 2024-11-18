package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Relative_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void TC_01_Relative_Locator() {
        driver.get("https://live.techpanda.org/index.php/catalogsearch/advanced/");

        // 1. khai bao bien : khi du lieu dc su dung nhieu lan
        //String emailAdd ="yendt05@gmail.com";
        //By emailTextboxBy = By.cssSelector("");
        //WebElement emailTextboxElement = driver.findElement(emailTextboxBy);
        // 2. Kong khai bao bien
        // Khi chi dung 1 lan
        //driver.findElement(emailTextboxBy).sendKeys("");

        WebElement priceForme = driver.findElement(RelativeLocator.with(By.tagName("input"))
                .toLeftOf(By.id("price_to"))
                .below(By.name("sku"))
                .above(By.id("tax_class_id")));
        System.out.println(priceForme);
        priceForme.sendKeys("20");



    }

    @Test
    public void TC_02() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

