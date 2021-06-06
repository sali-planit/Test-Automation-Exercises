package TestCases;

import Pages.LoginPage;
import TestCases.BaseTest;
import Pages.ContactPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Assertions;



public class ContactTest extends BaseTest {

    @Disabled("Test completed")
    @Test
    @DisplayName("Test Automation Exercise 1")
    public void testErrorShown(){
        ContactPage contactPage = homePage.clickContactButton();//clicks contact button


        contactPage.setEmail("notavalidemail");
        Assertions.assertEquals (contactPage.getEmailError(),
                "Please enter a valid email",
                "Unable to find error message");


    }
    @Disabled("Test completed")
    @Test
    @DisplayName("Test Automation Exercise 2")
    public void submitErrorShown(){
        ContactPage contactPage = homePage.clickContactButton();//clicks contact button

        contactPage.clickSubmit();

        Assertions.assertEquals (contactPage.getForenameError(),
                "Forename is required",
                "Unable to find email error message");
        Assertions.assertEquals (contactPage.getEmailError(),
                "Email is required",
                "Unable to find email error message");
        Assertions.assertEquals (contactPage.getMsgError(),
                "Message is required",
                "Unable to find msg error message");
        contactPage.setForename();
        contactPage.setEmail("notavalidemail@valid.com");
        contactPage.setMessage("test automation is FUN!!!");

        Assertions.assertFalse(contactPage.forenameErrorVisible());
        Assertions.assertFalse(contactPage.emailErrorVisible());
        Assertions.assertFalse(contactPage.msgErrorVisible());

    }

    @Disabled
    @Test
    @DisplayName("Test Automation Exercise 3")
    public void verifySubmit(){
        ContactPage contactPage = homePage.clickContactButton();
        contactPage.setForename();
        String successText = "Thanks " + contactPage.getForename() +", we appreciate your feedback.";
        contactPage.setEmail("notavalidemail@valid.com");
        contactPage.setMessage("test automation is FUN!!!");
        contactPage.clickSubmit();
        Assertions.assertEquals(contactPage.submitVerify(), successText, "Unable to locate success message");

    }


}


