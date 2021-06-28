package TestCases;

import Pages.LoginPage;
import TestCases.BaseTest;
import Pages.ContactPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Assertions;



public class ContactTest extends BaseTest {

    /*
    Contact Test Cases
    Test Case 1:
    From the home page go to the contact page
    Populate the email field with thisisnotavalidemail
    Verify that the email error is displayed with text Please enter a valid email

    Test Case 2:
    From the home page go to the contact page
    Click on the Submit button
    Validate that the mandatory errors for missing fields equal
    Forename is required
    Email is required
    Message is required
    Populate mandatory fields
    Validate that the mandatory errors are no longer displayed

    Test case 3:
    From the home page go to the contact page
    Populate the mandatory fields
    Click Submit button
    Verify Thanks message text


    */
    //@Disabled("Test completed")
    @Test
    @DisplayName("Test Automation Exercise 1")
    public void testErrorShown(){
        ContactPage contactPage = homePage.clickContactButton();//clicks contact button


        contactPage.setEmail("notavalidemail");
        Assertions.assertEquals (contactPage.getEmailError(),
                "Please enter a valid email",
                "Unable to find error message");


    }
    //@Disabled("Test completed")
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

    //@Disabled
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


