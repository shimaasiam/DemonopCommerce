package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class registerStepDef {
    P01_register register = new P01_register();
    SoftAssert soft = new SoftAssert();

    @Given("user go to register page")
    public void user_go_to_register_page()
    {
        register.registerLink().click();
    }
    @When("user select gender type")
    public void user_select_gender_type()
    {
        register.gender().click();
    }
    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void user_enter_firstname_and_lastname(String firstname,String lastname)
    {
        register.enterFirstAndLastName(firstname,lastname);
    }
    @And("user enter date of birth")
    public void user_enter_date_of_birth()
    {
        register.DayOfBirth();
        register.MonthOfBirth();
        register.YearOfBirth();
    }
    @And("^user enter email \"(.*)\" field$")
    public void user_enter_email_field(String email)
    {
        register.enterEmail(email);
    }
    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void user_fills_password_fields(String pwd,String conpwd)
    {
        register.enterPasswords(pwd,conpwd);
    }
    @And("user clicks on register button")
    public void user_clicks_register_button()
    {
        register.registerBtn().sendKeys(Keys.ENTER);
    }
    @Then("success message is displayed")
    public void success_message_displayed()
    {
        // assert the displayed success registeration message
        String actualResult = register.successMsg().getText();
        String expectedResult = "Your registration completed";
        soft.assertTrue(actualResult.contains(expectedResult));
        // assert the color of message
        String MsgColor = register.successMsg().getCssValue("color");
        String colorAsHex = Color.fromString(MsgColor).asHex();
        String expectedColor = "#4cb17c";
        soft.assertEquals(colorAsHex,expectedColor);
        soft.assertAll();

    }
}
