package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Priority {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    }

    @Test
    public void Product_01_Creat() {
        System.out.println("Product_01_Creat");
    }
    @Test
    public void Product_02_View() {
        System.out.println("Product_02_View");
    }
    @Test
    public void Product_03_Edit() {
        System.out.println("Product_03_Edit");
    }
    @AfterClass
    public void afterClass() {

    }
}
