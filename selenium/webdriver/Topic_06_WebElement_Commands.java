package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class Topic_06_WebElement_Commands {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_01_Element() {
        // Tuong tac truc tiep len element
        driver.findElement(By.cssSelector(""));

        // Thao tac nhieu lan len 1 element -> khai bao bien
        WebElement element = driver.findElement(By.cssSelector("input#name"));

        // Xoa du lieu trong 1 editable element (nhập)
        // Textbox/Textarea/Dropdown
        element.clear();

        // Nhap du lieu vao 1 editable element (nhập)
        element.sendKeys("");

        // 1. Element cha dung 1 loai locator - element con dung 1 loai locator
        driver.findElement(By.cssSelector(""))
                .findElement(By.xpath(""));

        // 2. Cha va con chung 1 loai locator
        driver.findElement(By.cssSelector(""));

        // Tim 1 element voi locator la tham so truyen vao
        driver.findElement(By.cssSelector(""));

        // Tim nhieu element voi locator la tham so truyen vao
        driver.findElements(By.cssSelector(""));

        // Click len clickalbe element (button, checkbox, radio, link, image, dropdown, icon)
        element.click();

        // Sumbit thong tin de gui len server
        // Gia lap hanh vi Enter của End User (Register/ Login/ Search/...)
        element.submit();

        // Verify thong tin/ du lieu da action
        // Kiem tra 1 element co hien thi hay ko
        // Ap dung cho tat ca cac loai element
        element.isDisplayed();

        // Kiem tra 1 element da dc chon hay chua (checkbox, radio, dropdown)
        element.isSelected();

        // Kiem tra 1 element co cho phep thao tac len hay ko? (cho phep sua du lieu hay ko?)
        // true = cho phép
        // false = bi disable
        // Test tính năng phân quyền
        element.isEnabled();

        // Lấy dữ liệu
        // Lấy ra text của element
        element.getText();
        element.getAttribute("placeholder"); //lấy đc text: Search store

        // Shadow DOM
        element.getShadowRoot();
        // Dev FrontEnd
        element.getAriaRole();
        element.getDomAttribute("");
        element.getDomProperty("");
        element.getAccessibleName();

        // Font/ Background/ Color/
        element.getCssValue("");

        // Lấy ra chiều rộng/ chiều cao của element
        element.getSize();

        // Lấy vị trí của element (góc trên bên trái so với browser)
        element.getLocation();

        // Rectangle elementRect = element.getRect();
        // elementRect.getDimension(); // = getSize
        // elementRect.getPoint(); // = getLocation

        // Lấy ra tên thẻ của element (By.id/class/name)
        element.getTagName();

        // Take screenshot (Chụp hình lỗi)
        element.getScreenshotAs(OutputType.FILE);
        element.getScreenshotAs(OutputType.BYTES);
        element.getScreenshotAs(OutputType.BASE64);
    }



        @AfterClass
    public void afterClass() {

        driver.quit();
    }
}

