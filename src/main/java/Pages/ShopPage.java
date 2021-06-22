package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShopPage {

    private WebDriver driver;

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
            //product.setBuy(item.findElement(By.className("btn")));
            productList.add(product);

        }

        return productList;
    }

    public Product getProduct(String toyName){
        List<Product>productList = getProducts();
        List<Product> matchedToy = productList.stream()
                .filter(prod -> prod.title.equals(toyName))
                .collect(Collectors.toList());
        System.out.println(matchedToy.get(0).price);
        Product product = matchedToy.get(0);

        return product;
    }


}
