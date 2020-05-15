package com.hillel.auto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class SeleniumDevTests {

    private WebDriver driver;

    @BeforeClass
    public void setUpDiver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
     @Test
    public void seleniumDevSiteShouldBeOpen(){
        //WebDriverManager.chromedriver().setup();

       // WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        String title = driver.getTitle();
        System.out.println(title);
        assertThat(title).isEqualTo("SeleniumHQ Browser Automation");
        //assertEquals(title, "SeleniumHQ Browser Automation");

       WebDriver.Window window = driver.manage().window();
       window.fullscreen();




    }
    @Test
    public void seleniumProjectsShouldBeOpen(){
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/projects/");
        navigate.back();
        navigate.forward();
        navigate.refresh();
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals(title, "Selenium Projects");
    }

}
