package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class homeSlidersStepDef {
    P03_homePage home = new P03_homePage();

    @When("user select Nokia slider")
    public void user_select_nokia_slider()
    {
        home.sliderItems().get(0).click();
    }

    @Then("user could view Nokia details page")
    public void user_view_nokia_details() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020");
    }

    @When("user select iPhone slider")
    public void user_select_iPhone_slider() {
        home.sliderItems().get(1).click();
    }
    @Then("user could view iPhone details page")
    public void user_view_iphone_details()
    {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6");
    }
}
