package Pages;

import Pages.ShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CartPage {
    private WebDriver driver;
    private By totalPrice = By.className("total");


    public CartPage(final WebDriver driver){
        this.driver = driver;
    }


    private List<Product> getCartProducts() {
        List<Product> cartProductList = new ArrayList<>();
        List<WebElement> items = driver.findElements(By.className("cart-item"));
        for (var item : items) {
            Product cartProduct = new Product();
            cartProduct.setCartTitle(item.findElement(By.className("ng-binding")).getText());
            cartProduct.setCartPrice(Double.parseDouble(item.findElements(By.className("ng-binding")).get(1).getText().replace("$", "")));
            cartProduct.setCartSubtotal(Double.parseDouble(item.findElements(By.className("ng-binding")).get(2).getText().replace("$", "")));
            cartProductList.add(cartProduct);
        }
        System.out.println(cartProductList);
        return cartProductList;
    }
    public Product getCartProduct(Predicate<Product> filter){
        return getCartProducts().stream()
                .filter(filter)
                .findFirst().orElseThrow();

    }

    public Double totalPrice(){
        return Double.parseDouble(driver.findElement(totalPrice).getText().replace("Total: ", ""));
    }
}
