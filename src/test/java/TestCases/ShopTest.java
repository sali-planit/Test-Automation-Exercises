package TestCases;

import Pages.CartPage;
import Pages.ShopPage;
import components.Cart;
import components.Product;
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
        var shopPage = homePage.clickShopButton();
        Product shopFrog = shopPage.getProduct(p -> p.getTitle().equals("Stuffed Frog"));
        Product shopBunny = shopPage.getProduct(p -> p.getTitle().equals("Fluffy Bunny"));
        Product shopBear = shopPage.getProduct(p -> p.getTitle().equals("Valentine Bear"));
        shopPage.buyLoop("Stuffed Frog", 2);
        shopPage.buyLoop("Fluffy Bunny", 5);
        shopPage.buyLoop("Valentine Bear", 3);
        var cartPage = homePage.clickCartButton();
        Cart cartFrog = cartPage.getCartProduct(i -> i.getCartTitle().equals(shopFrog.getTitle()));
        Cart cartBunny = cartPage.getCartProduct(i -> i.getCartTitle().equals(shopBunny.getTitle()));
        Cart cartBear = cartPage.getCartProduct(i -> i.getCartTitle().equals(shopBear.getTitle()));
        assertThat("Stuffed Frog Quantity",cartFrog.getQuantity(), equalTo(2));
        assertThat("Stuffed Frog Price", cartFrog.getCartPrice(), equalTo(shopFrog.getPrice()));
        assertThat("Stuffed Frog SubTotal", cartFrog.getCartSubtotal(), equalTo(shopFrog.getPrice() * cartFrog.getQuantity()));

        assertThat("Fluffy Bunny Quantity",cartBunny.getQuantity(), equalTo(5));
        assertThat("Fluffy Bunny Price", cartBunny.getCartPrice(), equalTo(shopBunny.getPrice()));
        assertThat("Fluffy Bunny SubTotal", cartBunny.getCartSubtotal(), equalTo(shopBunny.getPrice() * cartBunny.getQuantity()));

        assertThat("Valentine Bear Quantity", cartBear.getQuantity(), equalTo(3));
        assertThat("Valentine Bear Price", cartBear.getCartPrice(), equalTo(shopBear.getPrice()));
        assertThat("Valentine Bear SubTotal", cartBear.getCartSubtotal(), equalTo(shopBear.getPrice() * cartBear.getQuantity()));

        assertThat("Total Price", cartPage.totalPrice(), equalTo(cartFrog.getCartSubtotal() + cartBunny.getCartSubtotal() + cartBear.getCartSubtotal()));
    }

}
