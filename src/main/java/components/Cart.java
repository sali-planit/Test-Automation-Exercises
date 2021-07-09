package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
    String cartTitle;
    Double cartPrice;
    Double cartSubtotal;
    int Quantity;

    public Double getCartSubtotal() {
        return cartSubtotal;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void setCartSubtotal(Double cartSubtotal) {
        this.cartSubtotal = cartSubtotal;
    }
    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public String getCartTitle() {
        return cartTitle;
    }

    public void setCartTitle(String cartTitle) {
        this.cartTitle = cartTitle;
    }

}
