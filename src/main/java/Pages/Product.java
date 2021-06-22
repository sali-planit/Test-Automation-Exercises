package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product {
    private WebDriver driver;
    String title;
    Double price;
    //Integer rating;
    WebElement buy;

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setPrice(Double price){
        this.price = price;
    }
}
