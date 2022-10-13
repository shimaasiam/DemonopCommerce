package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class followUsStepDef {
    P03_homePage home= new P03_homePage();
    @When("^user press on site \"(.*)\" link$")
    public void user_press_social_link(String followSocial) throws InterruptedException {
        Thread.sleep(2000);
        switch (followSocial){
            case "facebook":
                home.facebookLink().click();
                break;
            case "twitter":
                home.twitterLink().click();
                break;
            case "rss":
                home.rssLink().click();
                break;
            case "youtube":
                home.youtubeLink().click();
                break;
        }
        Thread.sleep(7000);
    }
    @Then("^URL \"(.*)\" open successfully$")
    public void facebook_open_success(String expectedURL)
    {
        Hooks.driver.switchTo().window(home.windowsTabs().get(1));
        String actualTabUrl= Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualTabUrl,expectedURL);
        Hooks.driver.close();
        Hooks.driver.switchTo().window(home.windowsTabs().get(0));
    }
}
