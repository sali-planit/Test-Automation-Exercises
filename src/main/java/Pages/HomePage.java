package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By findContact = By.id("nav-contact");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public ContactPage clickContactButton(){
        driver.findElement(findContact).click();
        return new ContactPage(driver);
    }

}