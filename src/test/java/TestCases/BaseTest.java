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
    Test case 8:
    Change the URL in the BaseTest to http://jupiter2.cloud.planittesting.com
    Re-run all previous test cases, including Contact and Login test cases
    Fix any issues caused by the new code drop
     */

    private WebDriver driver;
    protected HomePage homePage;
    @BeforeEach //before test execution; browser needs to be open
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://jupiter2.cloud.planittesting.com");

        homePage = new HomePage(driver);

    }

    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }


}