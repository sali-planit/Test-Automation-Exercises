package Pages;

import components.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ShopPage extends BasePage{

    private WebDriver driver;
    private By cartCount = By.cssSelector(".cart-count.ng-binding");

    public ShopPage(final WebDriver driver) {
        super(driver);
    }


    private List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        List<WebElement> items = driver.findElements(By.className("product"));
        for (var item : items) {
            Product product = new Product();
            product.setTitle(item.findElement(By.cssSelector(".product-title")).getText());
            product.setPrice(Double.parseDouble(item.findElement(By.cssSelector(".product-price")).getText().replace("$", "")));
            product.setRating(Integer.parseInt(item.findElement(By.cssSelector(".star-level")).getText()));
            product.setBuy(item.findElement(By.className("btn")));
            productList.add(product);
        }

        return productList;
    }

    public Product getProduct(Predicate<Product> filter){
        return getProducts().stream()
                .filter(filter)
                .findFirst().orElseThrow();

    }

    public Integer cartQuantity(){
        return Integer.parseInt(driver.findElement(cartCount).getText());
    }

    public Product buyLoop(String prodTitle, Integer prodQuantity) {
        for (int i = 0; i < prodQuantity; i++){
            getProduct(prod -> prod.getTitle().equals(prodTitle)).getBuy().click();
        }
        return null;
    }
}
