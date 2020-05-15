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

public class HomeWork {
    private WebDriver driver;

    @BeforeClass
    public void setUpDriver(){
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
    public void seleniumDevMustBeOpen(){

        driver.get("https://www.selenium.dev/");
        String title = driver.getTitle();
        System.out.println(title);//SeleniumHQ Browser Automation
        assertThat(title).isEqualTo("SeleniumHQ Browser Automation");


    }
    @Test
    public void seleniumDevDocomentationMustBeOpen() {
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/documentation");

        String title = driver.getTitle();
        assertThat(title).isEqualTo("The Selenium Browser Automation Project :: Documentation for Selenium");

    }
    @Test
    public void seleniumDevDocChapterMustBeOpen(){
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/documentation/en/getting_started/");

        String title=driver.getTitle();
        assertThat(title).isEqualTo("Getting started :: Documentation for Selenium");
    }

    @Test
    public void seleniumSupportMustBeOpen(){
        WebDriver.Navigation navigate =  driver.navigate();
        navigate.to("https://www.selenium.dev/support/");
        String title = driver.getTitle();
        assertThat(title).isEqualTo("Selenium Support");
        navigate.refresh();
     }

     @Test
    public void seleniumBlogMustBeOpen(){

        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/blog/");
        String title = driver.getTitle();
        assertThat(title).isEqualTo("Selenium Blog");
         navigate.back();
     }

     @Test
    public void seleniumDownloadsMustBeOpen(){
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/downloads/");
        String title = driver.getTitle();
        assertThat(title).isEqualTo("Downloads");
     }
     @Test
    public void seleniumAboutMustBeOpen(){
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/about/");
        String title = driver.getTitle();
        assertThat(title).isEqualTo("About Selenium");
     }

     @Test
    public void seleniumEventsMustBeOpen(){
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/events/");
        String title = driver.getTitle();
        assertThat(title).isEqualTo("Selenium Events");

     }

     @Test
    public void seleniumHistoryMustBeOpen(){
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/history/");
        String title = driver.getTitle();
        assertThat(title).isEqualTo("Selenium History");
     }
     @Test
    public void seleniumSponsorMustBeOpen(){
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/sponsor/");
        String title = driver.getTitle();
        assertThat(title).isEqualTo("Sponsor");
     }
     @Test
    public void seleniumGetMustBeOpen(){
        WebDriver.Navigation navigate = driver.navigate();
        navigate.to("https://www.selenium.dev/getinvolved/");
        String title = driver.getTitle();
        assertThat(title).isEqualTo("Get Involved");
     }




}
