package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_Random_Popup {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Javacode() throws InterruptedException {

        driver.get("https://www.javacodegeeks.com/");

        By popup = By.xpath("//div[@data-title='Newsletter-Books Anime Brief' " +
                "and not(contains(@style,'display:none'))]");
        if (driver.findElements(popup).size() > 0 && driver.findElements(popup).get(0).isDisplayed()) {
            System.out.println("--- GO TO IF----");
            driver.findElement(By.xpath("//a[@onclick='return lepopup_close();' " +
                    "and not(@class='lepopup-inherited lepopup-inherited')]")).click();
            Thread.sleep(2000);
        }
        // ko hien thi thi action tiep
        System.out.println("----x IF------");
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("agile testing");
        driver.findElement(By.cssSelector("form#search span.tie-icon-search")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());
    }

    @Test
    public void TC_02_VNK() throws InterruptedException {

        driver.get("https://vnk.edu.vn/");

        By popupvnk = By.cssSelector("div.pum-container");
        if (driver.findElements(popupvnk).size() > 0 && driver.findElements(popupvnk).get(0).isDisplayed()) {
            System.out.println("--- GO TO IF----");
            driver.findElement(By.cssSelector("button.popmake-close")).click();
            Thread.sleep(2000);
        }
        driver.findElement(By.xpath("//a[text()='Giới thiệu']")).click();

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

