package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class hoverCategoriesStepDef {
    P03_homePage home = new P03_homePage();
    int random;
    String category, subcategory;
    @When("user select random category from menu and hover on it")
    public void user_select_random_category_and_hover()
    {
        random = new Random().nextInt(7);
        Actions hover = new Actions(Hooks.driver);
        hover.moveToElement(home.menuCategories().get(random)).perform();

    }
    @And("user select sub category of selected category and click on it")
    public void user_select_subcategory_and_hover()
    {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        if(!home.menusubCategory(random).isEmpty()){
            int subRandom = new Random().nextInt(3);
            subcategory = home.menusubCategory(random).get(subRandom).getText().toLowerCase().trim();
            home.menusubCategory(random).get(subRandom).click();
        }
        else {
            category = home.menuCategories().get(random).getText().toLowerCase().trim();
            home.menuCategories().get(random).click();
        }
    }

    @Then("user will view sub category details and verify title")
    public void user_view_subCategory_details() {
        String pageName= home.pageTitle().getText().toLowerCase().trim();
        if(!home.menusubCategory(random).isEmpty()){
            Assert.assertEquals(subcategory,pageName);
        }
        else {
            Assert.assertEquals(category,pageName);
        }
    }
}
