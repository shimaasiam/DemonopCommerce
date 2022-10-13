package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class P03_homePage {
    public void selectEuroCurrency()
    {
        WebElement currencyEle = Hooks.driver.findElement(By.id("customerCurrency"));
        Select s = new Select(currencyEle);
        s.selectByVisibleText("Euro");
    }
    public List<WebElement> productsPrices()
    {
        List<WebElement> proPrices = null;
        proPrices = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        return proPrices;
    }
    public void enterSearchWord(String prodName)
    {
        WebElement searchElem = Hooks.driver.findElement(By.id("small-searchterms"));
        searchElem.clear();
        searchElem.sendKeys(prodName);
    }
    public WebElement searchBtn()
    {
        return Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }

    public List<WebElement> searchResults()
    {
        List<WebElement> prodResults = null;
        prodResults = Hooks.driver.findElements(By.cssSelector("div[class=\"product-item\"]"));
        return prodResults;
    }
    public WebElement productSku(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"additional-details\"]"));
    }

    public List<WebElement> menuCategories()
    {
        List<WebElement> menuCat = null;
            menuCat = Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
            return  menuCat;
    }
    public List<WebElement> menusubCategory(int randomNum)
    {
        randomNum = randomNum+1;
        List<WebElement> menuSubCat = null;
        menuSubCat = Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+randomNum+"]/ul[@class=\"sublist first-level\"]/li"));
        return  menuSubCat;
    }
    public WebElement pageTitle()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class =\"page-title\"] h1"));
    }
    public List<WebElement> sliderItems()
    {
        List<WebElement> slider= null;
        return slider = Hooks.driver.findElements(By.cssSelector("a[class= \"nivo-imageLink\"]"));
    }
    public ArrayList<String> windowsTabs()
    {
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        return tabs;
    }
    public WebElement facebookLink()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
    }
    public WebElement twitterLink()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }
    public WebElement rssLink()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }
    public WebElement youtubeLink()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }
    public List<WebElement> featuredProducts()
    {
        List<WebElement> featurePro= null;
        return featurePro = Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }
    public WebElement wishSuccessMessage()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }
    public WebElement wishlistTab()
    {
        return Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]"));
    }
    public WebElement productQuantity()
    {
        return Hooks.driver.findElement(By.className("qty-input"));
    }

}
