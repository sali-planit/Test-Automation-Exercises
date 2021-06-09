package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    private WebDriver driver;
    private By UserNameField = By.id("loginUserName");
    private By passwordField = By.id("loginPassword");
    private By userLoggedIn = By.id("nav-user");
    private By loginButton = By.cssSelector(".btn.btn-primary");
    private By logoutMenuButton = By.id("nav-logout");
    private By logoutButton = By.xpath("//*[@class='btn btn-success']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String userName){
        driver.findElement(UserNameField).sendKeys(userName);
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
        return driver.findElement(UserNameField).getAttribute("value");

    }
    public void clickLogoutMenu(){
        driver.findElement(logoutMenuButton).click();
    }
    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }
    public boolean userLoggedInVisible(){
        try {
            driver.findElement(userLoggedIn);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }



}
