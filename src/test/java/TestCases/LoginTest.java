package TestCases;

import Pages.LoginPage;
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
    @Test
    @DisplayName("Test Automation Exercise 4")
    public void verifyLogin() {
        String userName = "anyvaluewilldo";
        String password = "letmein";

        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        assertThat(userName, equalTo(loginPage.displayedUserName()));
    }
}
