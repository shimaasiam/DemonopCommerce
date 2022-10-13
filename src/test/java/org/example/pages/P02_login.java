package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {
    public WebElement loginLink()
    {
        return Hooks.driver.findElement(By.className("ico-login"));
    }
    public void enterEmailAndPassword(String email, String pwd)
    {
        WebElement emailElem = Hooks.driver.findElement(By.id("Email"));
        emailElem.clear();
        emailElem.sendKeys(email);
        WebElement pwdElem = Hooks.driver.findElement(By.id("Password"));
        pwdElem.clear();
        pwdElem.sendKeys(pwd);
    }
    public WebElement loginBtn()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class= \"button-1 login-button\"]"));
    }
    public WebElement myAccountTab()
    {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));
    }
    public WebElement loginErrorMsg()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class= \"message-error validation-summary-errors\"]"));
    }
}
