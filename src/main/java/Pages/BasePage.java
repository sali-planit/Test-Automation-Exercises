package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    private By findContact = By.id("nav-contact");
    private By findLogin = By.id("nav-login");
    private By findShop = By.id("nav-shop");
    private By findCart = By.id("nav-cart");

    public BasePage(final WebDriver driver){
        this.driver = driver;
    }

    public ContactPage clickContactButton(){
        driver.findElement(findContact).click();
        return new ContactPage(driver);
    }

    public LoginPage clickLoginButton(){
        driver.findElement(findLogin).click();
        return new LoginPage(driver);
    }

    public ShopPage clickShopButton(){
        driver.findElement(findShop).click();
        return new ShopPage(driver);
    }
    public CartPage clickCartButton(){
        driver.findElement(findCart).click();
        return new CartPage(driver);
    }

}
