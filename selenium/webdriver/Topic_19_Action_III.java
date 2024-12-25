package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;

public class Topic_19_Action_III {

    WebDriver driver;
    Actions action;
    JavascriptExecutor jsExcutor;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
        jsExcutor = (JavascriptExecutor) driver;
    }


    @Test
    public void TC_01_Drag_And_Drop() {

        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement sourcecircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetcircle = driver.findElement(By.cssSelector("div#droptarget"));
        action.dragAndDrop(sourcecircle, targetcircle).perform();
        Assert.assertEquals(targetcircle.getText(),"You did great!");
        Assert.assertEquals(Color.fromString(targetcircle.getCssValue("background-color")).asHex().toUpperCase(),"#03A9F4");
    }

    @Test
    public void TC_02_HTML5() throws IOException {

        driver.get("https://automationfc.github.io/drag-drop-html5/");

        String jqueryDragDropContent = getContentFile(projectPath + "\\dragDrop\\dragAndDrop.js");
        jsExcutor.executeScript(jqueryDragDropContent);

    }
    @Test
    public void TC_04_ScrolltoElement()  {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        action.scrollToElement(driver.findElement(By.cssSelector("button#register-button"))).perform();
    }
    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }
    @AfterClass
    public void afterClass() {

        //driver.quit();
    }
}

