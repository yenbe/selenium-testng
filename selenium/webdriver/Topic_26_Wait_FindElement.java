package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_26_Wait_FindElement {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_FindElement() {

        driver.get("https://demo.nopcommerce.com/");

        //

    }

    @Test
    public void TC_02_FindElements() {

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        List<WebElement> elements = null;

        // 1. Nếu tìm thấy 1 element duy nhất
        elements = driver.findElements(By.cssSelector("input#small-searchterms"));
        System.out.println(elements.size());

        // 2. Neu tim thay nhieu hon 1 element
        elements = driver.findElements(By.cssSelector("input[type='text']"));
        System.out.println(elements.size());

        // Ko tim thay element nao
        elements = driver.findElements(By.cssSelector("input#aaa"));
        System.out.println(elements.size());
    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

