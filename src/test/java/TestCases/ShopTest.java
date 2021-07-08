package TestCases;

import Pages.CartPage;
import Pages.ShopPage;
import Pages.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Product product = shopPage.getProduct( prod -> prod.getTitle().equals("Stuffed Frog"));
        assertThat(product.getPrice(), equalTo(10.99));
    }

    /*
    Test case 7:
    From the home page go to the shop page
    Buy the first product you find with a given price. For example buy a product with price 9.99
    Validate that the cart menu displays 1
     */
    @Disabled
    @Test
    @DisplayName("Test Automation Exercise 7")
    public void checkCartCounter() {
        ShopPage shopPage = homePage.clickShopButton();
        Integer cartCounter = shopPage.cartQuantity();
        Product product = shopPage.getProduct( prod -> prod.getPrice().equals(10.99));
        product.getBuy().click();
        assertThat(shopPage.cartQuantity(), equalTo(cartCounter + 1));
    }

    /*
    Test case 9:
    From the home page go to the shop page
    Buy a product with 5 stars
    Validate that the cart menu displays 1
     */
    @Disabled
    @Test
    @DisplayName("Test Automation Exercise 9")
    public void getFiveStarProduct(){
        ShopPage shopPage = homePage.clickShopButton();
        Integer cartCounter = shopPage.cartQuantity();
        Product product = shopPage.getProduct( prod -> prod.getRating().equals(5));
        product.getBuy().click();
        assertThat(shopPage.cartQuantity(), equalTo(cartCounter + 1));
    }
    /*
    Cart Page Tests
    Test case 10:
    Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
    Go to the cart page
    Verify the price for each product
    Verify that each product’s sub total = product price * quantity
    Verify that total = sum(sub totals)
     */
    @Test
    @DisplayName("Test Automation Exercise 10")
    public void checkCart(){
        ShopPage shopPage = homePage.clickShopButton();
        shopPage.buyLoop("Stuffed Frog", 2);
        shopPage.buyLoop("Fluffy Bunny", 5);
        shopPage.buyLoop("Valentine Bear", 3);
        CartPage cartPage = homePage.clickCartButton();
        assertThat(cartPage.getCartProduct(prod -> prod.getCartTitle().equals("Stuffed Frog")).getCartPrice(), equalTo(10.99));
        assertThat(cartPage.getCartProduct(prod -> prod.getCartTitle().equals("Fluffy Bunny")).getCartPrice(), equalTo(8.99));
        assertThat(cartPage.getCartProduct(prod -> prod.getCartTitle().equals("Valentine Bear")).getCartPrice(), equalTo(13.99));
        assertThat(cartPage.getCartProduct(prod -> prod.getCartTitle().equals("Stuffed Frog")).getCartSubtotal(), equalTo(10.99*2));
        assertThat(cartPage.getCartProduct(prod -> prod.getCartTitle().equals("Fluffy Bunny")).getCartSubtotal(), equalTo(8.99*5));
        assertThat(cartPage.getCartProduct(prod -> prod.getCartTitle().equals("Valentine Bear")).getCartSubtotal(), equalTo(13.99*3));
        assertThat(cartPage.totalPrice(), equalTo((10.99*2)+(8.99*5)+(13.99*3)));
    }

}
