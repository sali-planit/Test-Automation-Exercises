package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopPage {

    private WebDriver driver;
    private By toyList = By.tagName("h4");
    private By toyPrice = By.cssSelector(".product-price.ng-binding");




    public ShopPage(final WebDriver driver) {
        this.driver = driver;
    }

    public String GetToyName(String toyName) {
        String toyNameAndPrice = "";
        List<WebElement> toys = driver.findElements(toyList);
        List<WebElement> priceTest = driver.findElements(toyPrice);
        for (WebElement e : toys) {
            if (e.getText().contains(toyName)) {
                String getToyName = e.getText();
                Integer indexNumber = toys.indexOf(e);
                for (WebElement i : priceTest) {
                    if(indexNumber.equals(priceTest.indexOf(i)))
                        toyNameAndPrice = getToyName + i.getText();

                }
            }
        }
        System.out.println(toyNameAndPrice);
        return toyNameAndPrice;

    }
}
