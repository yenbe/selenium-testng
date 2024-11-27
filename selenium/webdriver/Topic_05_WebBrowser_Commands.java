package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.sql.Driver;
import java.time.Duration;

public class Topic_05_WebBrowser_Commands {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        System.out.println("Driver ID = " + driver.toString());
    }
    @Test
    public void TC_01_Browser() {

        driver.get("https://www.facebook.com/");//**
        // Lay ra URL o page hien tai
        driver.getCurrentUrl();
        System.out.println("URL Page = " + driver.getCurrentUrl());
        // Lay ra Title page hien tai
        driver.getTitle();
        System.out.println("Title = " + driver.getTitle());
        // Lay ra Window ID o page hien tai
        driver.getWindowHandle();
        System.out.println("Window ID = " + driver.getWindowHandle());
        //Lay ra tat ca window id o cac tab/window
        driver.getWindowHandles();
        // Lay ra source code page hien tai
        driver.getPageSource();
        System.out.println("Page Source Code = " + driver.getPageSource());


        // Alert - Frame/iFrame - Window/Tab
        driver.switchTo();
        // Alert
        driver.switchTo().alert();//**

        // Frame/ iFrame
        // switch vao frame hoac iframe
        driver.switchTo().frame("");
        // switch tu trang cha tro lai (chi co 1 frame)
        driver.switchTo().defaultContent();
        // switch tu frame con ra frame cha (co nhieu frame long nhau)
        driver.switchTo().parentFrame();

        // Window/Tab
        driver.switchTo().window(""); //truyen vao gia tri window id
        driver.switchTo().newWindow(WindowType.TAB).get("https://live.techpanda.org/");
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://live.techpanda.org/");

        // Set timeout de tim element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//**

        // Cookie
        driver.manage().getCookies();

        // browser : full, max, min
        driver.manage().window().maximize();//**
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();

        // Set browser kich thuoc bnh
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().getSize();

        // Set browser nam o vi tri nao
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        // Selenium Log browser,network,drive
        driver.manage().logs().get(LogType.BROWSER);
        driver.manage().logs().get(LogType.DRIVER);
        driver.manage().logs().get(LogType.CLIENT);
        driver.manage().logs().get(LogType.PERFORMANCE);
        driver.manage().logs().get(LogType.SERVER);
        driver.manage().logs().getAvailableLogTypes();

        // Quay lai trang truoc do
        driver.navigate().back();

        // Chuyen tiep den trang phia trc
        driver.navigate().forward();

        // Refresh lai trang hien tai
        driver.navigate().refresh();

        // Mo 1 URL moi
        driver.navigate().to("");
        //driver.navigate().to(new URL(""));

    }



        @AfterClass
    public void afterClass() {

        driver.quit();
    }
}

