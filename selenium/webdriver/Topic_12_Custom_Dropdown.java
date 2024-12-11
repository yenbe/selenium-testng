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
        selectSpeedDropdown("Slower");
        selectSpeedDropdown("Slow");
        selectSpeedDropdown("Fast");
    }
    private void selectSpeedDropdown(String textItem) throws InterruptedException {
        // Chờ cho dropdown có thể thao tác lên được (clickable)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#speed-button>span.ui-selectmenu-icon")));
        // Click vao element cho dropdown xổ ra
        driver.findElement(By.cssSelector("span#speed-button")).click();
        Thread.sleep(2000);
        // Chờ cho tat ca element dc load ra (presence)
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#speed-menu>li>div")));
        //  Tìm item nào đúng mong đợi
        List<WebElement> allitem = driver.findElements(By.cssSelector("ul#speed-menu>li>div"));
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

