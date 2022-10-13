package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.example.pages.P03_homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class wishListStepDef {
    P03_homePage home= new P03_homePage();
    SoftAssert soft = new SoftAssert();

    @When("user press on add product to wishlist")
    public void user_press_wishlist_button()
    {
        home.featuredProducts().get(2).click();
    }

    @Then("success message is displayed with green color")
    public void success_message_displayed_with_green_color() {
        String actualMsg = home.wishSuccessMessage().getText();
        soft.assertTrue(actualMsg.contains("The product has been added to your wishlist"));

        String MsgColor = home.wishSuccessMessage().getCssValue("background-color");
        String colorAsHex = Color.fromString(MsgColor).asHex();
        String expectedColor = "#4bb07a";
        soft.assertEquals(colorAsHex,expectedColor);
        soft.assertAll();
    }

    @And("user press on wishlist tab")
    public void user_press_wishlist_tab(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(home.wishlistTab()));
        JavascriptExecutor executor = (JavascriptExecutor)Hooks.driver;
        executor.executeScript("arguments[0].click();", home.wishlistTab());
    }
    @Then("user could view product in wishlist with quantity")
    public void user_view_wishlist_with_quantity()
    {
        String quantityValue = home.productQuantity().getAttribute("value");
        int quantity = Integer.parseInt(quantityValue);
        Assert.assertTrue(quantity>0);

    }
}
