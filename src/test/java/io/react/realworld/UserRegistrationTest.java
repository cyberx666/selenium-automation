package io.react.realworld;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRegistrationTest {


    private WebDriver driver;


    @BeforeClass
    public void setUpDiver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(400,TimeUnit.MILLISECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void registrationTest(){
        driver.get("https://react-redux.realworld.io/");
        //#main > div > nav > div > ul > li:nth-child(3) > a
        //WebElement signUpButton = driver.findElement(By.cssSelector("#main > div > nav > div > ul > li:nth-child(3) > a"));
        //WebElement signUpButton = driver.findElement(By.linkText("Sign up"));
        WebElement signUpButton = driver.findElement(By.cssSelector("a[href='#register']"));
        signUpButton.click();

        // String currentUrl = driver.getCurrentUrl();
       // assertThat(currentUrl.contains("register"));

        WebElement signUpHeader = driver.findElement(By.cssSelector(".auth-page h1"));
        assertThat(signUpHeader.getText()).isEqualTo("Sign Up");

        WebElement signUpForm = driver.findElement(By.cssSelector(".auth-page form"));
        assertThat(signUpForm.isDisplayed()).isTrue();

        String userName = "ruserrealapp" + new Random().nextInt(10000);
        String email = userName+ "@i.ua";
        String password = "12345678";

        WebElement userNameField = signUpForm.findElement(By.cssSelector("input[type='text']"));
        userNameField.clear();
        userNameField.sendKeys(userName);

        WebElement emailField = signUpForm.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = signUpForm.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement signInButton = signUpForm.findElement(By.cssSelector("button[type='submit']"));
        signInButton.click();

        WebElement userInfo = driver.findElement(By.cssSelector("[href='#@" +userName+"']"));
        assertThat(userInfo.isDisplayed()).isTrue();


    }
    @Test
    public void
    loginTest(){
        String user = "ruserrealapp";
        String email = "ruserrealapp@i.ua";
        String password = "12345678";

    }

}
