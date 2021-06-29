package TestCases;

import Pages.LoginPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseTest {
    /*
    Test Case 4:
    From the home page click the login menu
    In the login dialog enter username as anyvaluewilldo and password as letmein
    Click the Login button
    Verify that the username appears in the menu bar
     */
    //@Disabled
    @Test
    @DisplayName("Test Automation Exercise 4")
    public void verifyLogin() {
        String userName = "anyvaluewilldo";
        String password = "letmein";

        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickTermsButton();
        loginPage.clickLogin();

        assertThat(loginPage.displayedUserName(), equalTo(userName));
    }
    /*
    Test Case 5: From the home page go to the contact page
    Click the login button
    In the login dialog enter username as anyvaluewilldo and password as letmein
    Click the Login button
    Click the logout menu
    Click the logout button
    Validate that the username is not displayed
     */
    @Disabled
    @Test
    @DisplayName("Test Automation Exercise 5")
    public void verifyLogout(){
        String userName = "anyvaluewilldo";
        String password = "letmein";

        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickTermsButton();
        loginPage.clickLogin();
        loginPage.clickLogoutMenu();
        loginPage.clickLogoutButton();
        assertThat(loginPage.displayedUserName(), equalTo(""));
    }


}
