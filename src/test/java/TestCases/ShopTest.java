package TestCases;

import Pages.LoginPage;
import Pages.ShopPage;
import Pages.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ShopTest extends BaseTest{

    /*
    Shop Test Cases
    Test case 6:
    From the home page go to the shop page
    Validate a given price for a given product title. For example given Teddy Bear validate that the price is 12.99
     */
    @Disabled
    @Test
    @DisplayName("Test Automation Exercise 6")
    public void validateTeddyBearPrice() throws Exception {
        ShopPage shopPage = homePage.clickShopButton();
        Product product = shopPage.getProduct("Stuffed Frog");
        assertThat(product.getPrice(), equalTo(10.99));
    }

    /*
    Test case 7:
    From the home page go to the shop page
    Buy the first product you find with a given price. For example buy a product with price 9.99
    Validate that the cart menu displays 1
     */
    @Test
    @DisplayName("Test Automation Exercise 7")
    public void verifyCart() throws Exception {
        ShopPage shopPage = homePage.clickShopButton();
        Product product = shopPage.getProductPrice(9.99);
        product.getBuy().click();
        assertThat(shopPage.cartQuantity(), equalTo("1"));
    }
    
}
