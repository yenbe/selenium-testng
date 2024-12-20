package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_Radio {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }


    @Test
    public void TC_01_Telerik() {

        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        // Kiem tra isEnable, isSelected
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isSelected());
        // Click checkbox
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div#demo-runner")));
        if (!driver.findElement(dualZoneCheckbox).isSelected()) {
            driver.findElement(dualZoneCheckbox).click();
        }
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());
        // de-select
        if (driver.findElement(dualZoneCheckbox).isSelected()) {
            driver.findElement(dualZoneCheckbox).click();
        }
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By DieselRadio = By.xpath("//label[text()='1.6 Diesel, 77kW']/preceding-sibling::span/input");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        if (!driver.findElement(DieselRadio).isSelected()) {
            driver.findElement(DieselRadio).click();
        }
        Assert.assertTrue(driver.findElement(DieselRadio).isSelected());

    }

    @Test
    public void TC_02() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));
        // Click all checkbox
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        // Verify all checkbox isSelected
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }
        // De-selected all checkbox
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        // Verify all checkbox de-Selected
        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }
        // Select 1 checkbox
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected() && checkbox.getAttribute("value").equals("Hepatitis")) {
                checkbox.click();
            }
        }
    }
        @Test
        public void TC_03() {
            driver.get("https://material.angular.io/components/radio/examples");
            By radioSummer = By.cssSelector("input[value='Summer']");
            if (!driver.findElement(radioSummer).isSelected()) {
                driver.findElement(radioSummer).click();
            }
            Assert.assertTrue(driver.findElement(radioSummer).isSelected());

            driver.get("https://material.angular.io/components/checkbox/examples");
            driver.findElement(By.xpath("//label[text()='Checked']/preceding-sibling::div/input")).click();
            driver.findElement(By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input")).click();
    }


        @Test
        public void TC_04_Ubuntu() {
            driver.get("https://login.ubuntu.com/");

            By newuserRadio = By.cssSelector("input#id_new_user");
            // dung duy nhat the input de click va verify dung js Executor
            jsExecutor.executeScript("arguments[0].click();", driver.findElement(newuserRadio));
            Assert.assertTrue(driver.findElement(newuserRadio).isSelected());
            By termCheckbox = By.cssSelector("input#id_accept_tos");
            jsExecutor.executeScript("arguments[0].click();", driver.findElement(termCheckbox));
            Assert.assertTrue(driver.findElement(termCheckbox).isSelected());
    }
        @Test
        public void TC_05_Docs() {
            driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

            By canthoRadio = By.xpath("//div[@data-value='Cần Thơ']");
            driver.findElement(canthoRadio).click();
            Assert.assertEquals(driver.findElement(canthoRadio).getAttribute("aria-checked"),"true");

            By quangngaiCheckbox = By.xpath("//div[@aria-label='Quảng Ngãi']");
            if (driver.findElement(quangngaiCheckbox).getAttribute("aria-checked").equals("false")) {
                driver.findElement(quangngaiCheckbox).click();
            }
            Assert.assertEquals(driver.findElement(quangngaiCheckbox).getAttribute("aria-checked"),"true");
            if (driver.findElement(quangngaiCheckbox).getAttribute("aria-checked").equals("true")) {
                driver.findElement(quangngaiCheckbox).click();
            }
        }
    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

