package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShopPage {

    private WebDriver driver;
    private By cartCount = By.cssSelector(".cart-count.ng-binding");
    public ShopPage(final WebDriver driver) {
        this.driver = driver;
    }


    private List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        List<WebElement> items = driver.findElements(By.className("product"));
        for (var item : items) {
            Product product = new Product();
            product.setTitle(item.findElement(By.cssSelector(".product-title")).getText());
            product.setPrice(Double.parseDouble(item.findElement(By.cssSelector(".product-price")).getText().replace("$", "")));
            product.setBuy(item.findElement(By.className("btn")));
            productList.add(product);
        }

        return productList;
    }

    public Product getProduct(Predicate<Product> filter){
        List<Product> products = getProducts().stream()
                .filter(filter)
                .collect(Collectors.toList());
        Product product = products.get(0);
        return product;
    }



    public Integer cartQuantity(){
        return Integer.parseInt(driver.findElement(cartCount).getText());
    }
}
