package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_23_Windows_Tab {

    WebDriver driver;
    WebDriverWait expliciWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01() throws InterruptedException {

        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Lay ra ID cua window/tab ma driver dang active tai page do
        String githubWindowID = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(2000);
        // Switch qua tab Google
        switchToWindowByID(githubWindowID);
        Thread.sleep(2000);
        // Lay ra ID cua tat ca window/tab hien tai
        String googleID = driver.getWindowHandle();
        // Switch ve tab github
        switchToWindowByID(googleID);
        Thread.sleep(3000);
        // Click vao Facebook
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();

        switchToWindowByTitle("Facebook – log in or sign up");

        // Quay ve Github
        switchToWindowByTitle("Selenium WebDriver");
        driver.findElement(By.xpath("//a[text()='LAZADA']")).click();
        Thread.sleep(2000);
        switchToWindowByTitle("Lazada - Mua Sắm Hàng Chất Giá Tốt Online");

        closeallwindowWithoutParentPage(githubWindowID);
    }

    private void closeallwindowWithoutParentPage(String githubWindowID) throws InterruptedException {
        // Lay het ID cua tab/window hien tai
        Set<String> allWindowIDs = driver.getWindowHandles();
        // Dùng vòng lặp duyệt qua từng ID
        for (String id : allWindowIDs) {
            if (!id.equals(githubWindowID)) {
                driver.switchTo().window(id);
                Thread.sleep(2000);
                driver.close();
            }
        }
        driver.switchTo().window(githubWindowID);
    }

    private void switchToWindowByTitle(String expectedpageTitle) throws InterruptedException {
        // Lay het ID cua tab/window hien tai
        Set<String> allWindowIDs = driver.getWindowHandles();
        // Dùng vòng lặp duyệt qua từng ID
        for (String id : allWindowIDs) {
            // Mỗi laần duyệt cho switch vào trước
            driver.switchTo().window(id);
            Thread.sleep(2000);

            // Get ra title cua page hien tai
            String pageTitle = driver.getTitle();

            // Kiem tra Title neu dung la tab minh cần thi thoát vòng lăp
            if (pageTitle.equals(expectedpageTitle)) {
                break;
            }
        }
    }

    // Chỉ đúng với 2 tab/window
    private void switchToWindowByID(String WindowID) {
        Set<String> allwindowIDs = driver.getWindowHandles();
        for (String id: allwindowIDs) {
            if (!id.equals(WindowID)) {
                driver.switchTo().window(id);
            }
        }
    }


    @Test
    public void TC_02_Techpanda() throws InterruptedException {

        driver.get("https://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        String TechpandaID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']" +
                "//a[text()='Add to Compare']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),
                "The product Sony Xperia has been added to comparison list.");
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']" +
                "//a[text()='Add to Compare']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),
                "The product Samsung Galaxy has been added to comparison list.");
        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        switchToWindowByID(TechpandaID);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"Products Comparison List - Magento Commerce");
        driver.close();
        driver.switchTo().window(TechpandaID);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),
                "The comparison list was cleared.");
    }

    @Test
    public void TC_03() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/vi/");
        driver.findElement(By.cssSelector("span.cdo-login-button")).click();
        Thread.sleep(3000);
        switchToWindowByTitle("Login");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@aria-label='Email' and @aria-invalid='true']/" +
                "following-sibling::span")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='password' and @aria-invalid='true']/" +
                        "following-sibling::span"))
                .getText(),"This field is required");
        driver.close();
        switchToWindowByTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#searchword")).sendKeys("hello");
        driver.findElement(By.cssSelector("button.cdo-search-button")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://dictionary.cambridge.org/vi/dictionary/english/hello");
    }

    @Test
    public void TC_04_Selenium4x() throws InterruptedException {

        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        driver.switchTo().newWindow(WindowType.TAB).get("http://live.techpanda.org/index.php/customer/account/");
        driver.findElement(By.cssSelector("button[title='Login']")).click();
        switchToWindowByTitle("Mobile");
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']" +
                "//a[text()='Add to Compare']")).click();
    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

