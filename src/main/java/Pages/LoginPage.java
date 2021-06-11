package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private WebDriver driver;

    private By userNameField = By.id("loginUserName");
    private By passwordField = By.id("loginPassword");
    private By userLoggedIn = By.id("nav-user");
    private By loginButton = By.cssSelector(".btn.btn-primary");
    private By logoutMenuButton = By.id("nav-logout");
    private By logoutButton = By.cssSelector(".btn.btn-success");

    public LoginPage(final WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public String displayedUserName(){
        return driver.findElement(userLoggedIn).getText();
    }
    public String getUserName(){
        return driver.findElement(userNameField).getAttribute("value");

    }
    public void clickLogoutMenu(){
        driver.findElement(logoutMenuButton).click();
    }
    public void clickLogoutButton(){
        List<WebElement> logoutButtons = driver.findElements(logoutButton);
        logoutButtons.get(1).click();
    }





}
