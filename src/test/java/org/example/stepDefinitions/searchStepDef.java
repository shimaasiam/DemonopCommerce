package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class searchStepDef {
    P03_homePage home = new P03_homePage();
    SoftAssert soft = new SoftAssert();

    @When("user enter {string} in search")
    public void user_enter_search_word(String prodName) {
        home.enterSearchWord(prodName);
    }
    @And("user press on search button")
    public void user_press_search_button() {
        home.searchBtn().click();
    }

    @Then("search results will have {string} displayed")
    public void search_results_will_have_displayed(String searchWord) {
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));

        int x = home.searchResults().size();
        for (int i=0;i<x;i++)
        {
            String actualSearchResultName = home.searchResults().get(i).getText().toLowerCase();
            soft.assertTrue((actualSearchResultName.contains(searchWord)));
        }
        soft.assertAll();
    }

    @Then("user could click on product search result")
    public void user_click_on_search_result() {
        // assert that return results has only one item with searched sku
        Assert.assertEquals(home.searchResults().size(),1);
        // open the product details
        home.searchResults().get(0).click();
    }
    @And("search result details will have {string} displayed")
    public void search_result_details_have_displayed(String skuSearchWord) {
        String actualSearchResultSku= home.productSku().getText();
        Assert.assertTrue(actualSearchResultSku.contains(skuSearchWord));
    }
}
