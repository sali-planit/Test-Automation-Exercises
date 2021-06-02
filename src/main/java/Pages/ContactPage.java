package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class ContactPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By emailField = By.id("email");
    private By emailError = By.id("email-err");
    private By forenameField = By.id("forename");
    private By forenameError = By.id("forename-err");
    private By messageField = By.id("message");
    private By messageError = By.id("message-err");
    private By submitButton = By.linkText("Submit");
    private By verifyText = By.cssSelector(".alert.alert-success");
    private String forename = "JoeMama";



    public ContactPage(WebDriver driver){
        this.driver = driver;
    }
    public void waitToLoad(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setForename(){
        driver.findElement(forenameField).sendKeys(forename);
    }
    public String getForename(){
        return driver.findElement(forenameField).getAttribute("value");

    }


    public void setMessage(String message){
        driver.findElement(messageField).sendKeys(message);
    }

    public String getEmailError(){
        return driver.findElement(emailError).getText();
    }
    public String getForenameError(){
        return driver.findElement(forenameError).getText();
    }
    public String getMsgError(){
        return driver.findElement(messageError).getText();
    }
    public void closeBrowser(){
        driver.quit();
    }

    public boolean forenameErrorVisible(){
        try {
            driver.findElement(forenameError);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public boolean emailErrorVisible(){
        try {
            driver.findElement(emailError);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public boolean msgErrorVisible(){
        try {
            driver.findElement(messageError);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public String submitVerify(){
        return driver.findElement(verifyText).getText();
    }
//    public String sucText(){
////        return "Thanks " + getForename() +", we appreciate your feedback.";
////    }

}
