package TestCases;

import Pages.LoginPage;
import Pages.ShopPage;
import Pages.Product;
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
//    @Test
//
//    public void verifyPrice(){
//        String toyName = "Handmade Doll";
//        String Price = "$10.99";
//        ShopPage shopPage = homePage.clickShopButton();
//
//        assertThat(shopPage.GetToyName(toyName), equalTo(Price));
//
//    }
    @Test
    @DisplayName("Test Automation Exercise 6")
    public void validateTeddyBearPrice() throws Exception {
        ShopPage shopPage = homePage.clickShopButton();
        Product product = shopPage.getProduct("Stuffed Frog");
        assertThat(10.99, equalTo(product.getPrice()));
    }

}
