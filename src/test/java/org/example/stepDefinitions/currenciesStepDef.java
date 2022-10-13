package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class currenciesStepDef {
    P03_homePage page = new P03_homePage();

    @When("user select euro currency")
    public void user_select_euro()
    {
        page.selectEuroCurrency();
    }
    @Then("products prices will have euro symbol")
    public void products_prices_with_euro()
    {
        int x= page.productsPrices().size();
        for (int i=0; i<x;i++) {
           String price = page.productsPrices().get(i).getText();
           Assert.assertTrue((price.contains("€")));
        }
    }
}
