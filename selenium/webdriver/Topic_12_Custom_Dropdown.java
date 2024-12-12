package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        selectCustomDropdown("span#number-button","ul#number-menu>li>div","15");
        selectCustomDropdown("span#files-button","ul#files-menu>li>div","Some unknown file");

    }
    private void selectCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Chờ cho dropdown có thể thao tác lên được (clickable)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss)));
        // Click vao element cho dropdown xổ ra
        driver.findElement(By.cssSelector(parentCss)).click();
        Thread.sleep(2000);
        // Chờ cho tat ca element dc load ra (presence)
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        //  Tìm item nào đúng mong đợi
        List<WebElement> allitem = driver.findElements(By.cssSelector(childCss));
        // -> 5 item
        for (WebElement item: allitem) {
            // System.out.println(item.getText());
            if (item.getText().equals(textItem)) {
                // Click len item do
                item.click();
                break;
            }
        }
    }

    @Test
    public void TC_02() {

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

