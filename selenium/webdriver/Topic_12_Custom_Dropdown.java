package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void TC_01_JQuery() throws InterruptedException {

        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

        selectCustomDropdown("span#speed-button", "ul#speed-menu>li>div","Fast");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Fast");
        selectCustomDropdown("span#number-button","ul#number-menu>li>div","15");
        selectCustomDropdown("span#files-button","ul#files-menu>li>div","Some unknown file");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(),"Some unknown file");

    }
    @Test
    public void TC_02_React() throws InterruptedException {

        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectCustomDropdown("div.selection.dropdown","div.item>span","Matt");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Matt");
    }
    @Test
    public void TC_03_VueJS() throws InterruptedException {

        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.btn-group")).getText(),"Second Option");
        selectCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","First Option");
    }
    @Test
    public void TC_04_Editable() throws InterruptedException {

        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        enterCustomDropdown("input.search","div.item>span","Bahrain");
        enterCustomDropdown("input.search","div.item>span","Belgium");

    }

    private void selectCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Chờ cho dropdown có thể thao tác lên được (clickable)
        // Click vao element cho dropdown xổ ra
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        Thread.sleep(2000);
        // Chờ cho tat ca element dc load ra (presence)
        //  Tìm item nào đúng mong đợi
        List<WebElement> allitem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        for (WebElement item: allitem) {
            if (item.getText().equals(textItem)) {
                // Click len item do
                item.click();
                break;
            }
        }
    }
    private void enterCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Chờ cho dropdown có thể nhập được (visible)
        // Sendkey vao dropdown
        WebElement dropdownTextbox = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss)));
        dropdownTextbox.clear();
        dropdownTextbox.sendKeys(textItem);
        Thread.sleep(2000);
        // Chờ cho tat ca element dc load ra (presence)
        //  Tìm item nào đúng mong đợi
        List<WebElement> allitem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        for (WebElement item: allitem) {
            if (item.getText().equals(textItem)) {
                // Click len item do
                item.click();
                break;
            }
        }
    }
    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

