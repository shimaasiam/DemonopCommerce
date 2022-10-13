package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class loginStepDef {
    P02_login login = new P02_login();
    SoftAssert soft = new SoftAssert();

    @Given("user go to login page")
    public void user_go_to_login() {
        login.loginLink().click();
    }
    @When("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void user_login_With(String type, String email, String pwd)
    {
        login.enterEmailAndPassword(email,pwd);
    }
    @And("user press on login button")
    public void user_press_login_button()
    {
        login.loginBtn().click();
    }
    @Then("user login to the system successfully")
    public void user_login_successfully()
    {
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        soft.assertTrue(login.myAccountTab().isDisplayed());
        soft.assertAll();
    }
    @Then("user could not login to the system")
    public void user_could_not_login()
    {
        // assert the error message contains unsuccessful
        String actualMsg = login.loginErrorMsg().getText();
        String expectedMsg = "Login was unsuccessful.";
        soft.assertTrue(actualMsg.contains(expectedMsg));
        // assert the color of message
        String MsgColor = login.loginErrorMsg().getCssValue("color");
        String expectedColorAsHex = Color.fromString(MsgColor).asHex();
        String expectedMsgColor = "#e4434b";
        soft.assertEquals(expectedColorAsHex,expectedMsgColor);
        soft.assertAll();
    }
}
