package TestCases;

import Pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    /*
    Contact Test Cases
    Test Case 1:
    From the home page go to the contact page
    Populate the email field with thisisnotavalidemail
    Verify that the email error is displayed with text Please enter a valid email

    Test Case 2:
    From the home page go to the contact page
    Click on the Submit button
    Validate that the mandatory errors for missing fields equal
    Forename is required
    Email is required
    Message is required
    Populate mandatory fields
    Validate that the mandatory errors are no longer displayed

    Test case 3:
    From the home page go to the contact page
    Populate the mandatory fields
    Click Submit button
    Verify Thanks message text


    */

    private WebDriver driver;
    protected HomePage homePage;
    @BeforeEach //before test execution; browser needs to be open
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://jupiter.cloud.planittesting.com/");

        homePage = new HomePage(driver);

    }

//    @AfterEach
//    public void closeBrowser(){
//        driver.quit();
//    }


}