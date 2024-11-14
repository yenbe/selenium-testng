package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Locator {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

    }

    @Test
    public void TC_01_ID() {

        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.id("search")).sendKeys("TV");
        driver.findElement(By.id("firstname")).sendKeys("Yến");

    }

    @Test
    public void TC_02_Class() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");
        driver.findElement(By.className("header-language-background"));
        driver.findElement(By.className("copyright"));

    }
    @Test
    public void TC_03_Name() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");
        driver.findElement(By.name("lastname"));
        driver.findElement(By.name("q"));

    }
    @Test
    public void TC_04_Link() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        // Chi dung duoc voi duong link co text (text tren UI ko phai text duoi HTML
        // Truền hết chuỗi text vao
        driver.findElement(By.linkText("SITE MAP"));

    }
    @Test
    public void TC_05_Partical_Link() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");
        // Chi dung duoc voi duong link co text (text tren UI ko phai text duoi HTML
        // Truyen het ca chuoi text hoac 1 phan text cung chay dc
        driver.findElement(By.partialLinkText("SITE MAP"));
        driver.findElement(By.partialLinkText("SITE"));

    }
    @Test
    public void TC_06_Tagname() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");
        // Tim nhieu Element giong nhau
        int a = driver.findElements(By.tagName("input")).size();
        System.out.println("Tong so input = " + a);

    }
    @Test
    public void TC_07_Css() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        // Css voi ID

        driver.findElement(By.cssSelector("input[id='search']"));
        driver.findElement(By.cssSelector("#search"));
        driver.findElement(By.cssSelector("input#search"));

        // Css voi Class

        driver.findElement(By.cssSelector("div[class='header-language-background']"));
        driver.findElement(By.cssSelector("div.header-language-background"));
        driver.findElement(By.cssSelector(".header-language-background"));

        // Ngoai le : Class co nhieu gia tri ben trong phan cach boi dau khoang trang
        driver.findElement(By.cssSelector("input[class='input-text validate-email required-entry']"));
        driver.findElement(By.cssSelector("input.input-text.validate-email.required-entry"));
        driver.findElement(By.cssSelector("input.input-text"));

        // Css voi name

        driver.findElement(By.cssSelector("input[name='firstname'"));

        int radio = driver.findElements(By.cssSelector("input[type='radio']")).size();
        System.out.println("Tong so radio = " + radio);

        // Css voi Link (Css ko dung dc voi text)

        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/catalog/seo_sitemap/category/']"));

        // Css voi partical link
        driver.findElement(By.cssSelector("a[href^='http://live.techpanda.org/']"));
        driver.findElement(By.cssSelector("a[href*='index.php/catalog/seo_sitemap/']"));
        driver.findElement(By.cssSelector("a[href$='category/']"));

        // Css voi tagname

        int a = driver.findElements(By.cssSelector("input")).size();
        System.out.println("Tong so input = " + a);
    }
    @Test
    public void TC_08_XPath() {
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");

        // Xpath voi ID

        driver.findElement(By.xpath("//input[@id='search']"));

        // Xpath voi Class
        // Xpath voi name
        // Xpath voi link (Co the dung dc voi text)
        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/catalog/seo_sitemap/category/']"));
        driver.findElement(By.xpath("//a[text()='Site Map']"));
        // Xpath voi partical link
        driver.findElement(By.xpath("//a[starts-with(@href,'http://live.techpanda.org/')]"));
        driver.findElement(By.xpath("//a[contains(@href,'org/index.php/catalog/seo_sitemap/')]"));
        // Xpath ko support voi ends-with
        //driver.findElement(By.xpath("//a[ends-with(@href,'category/')]"));
        // Xpath voi tagname
        int a = driver.findElements(By.xpath("//input")).size();
        System.out.println("Tong so input = " + a);

    }

    @AfterClass
    public void afterClass() {

        // driver.quit();
    }
}

