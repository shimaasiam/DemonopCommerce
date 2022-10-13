package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_register {
    Select s;
    public WebElement registerLink()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }
    public WebElement gender()
    {
        return Hooks.driver.findElement(By.id("gender"));
    }
    public WebElement firstName()
    {
        return Hooks.driver.findElement(By.id("FirstName"));
    }
    public WebElement lastName()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }
    public void enterFirstAndLastName(String firstname, String lastname) {
        firstName().clear();
        firstName().sendKeys(firstname);
        lastName().clear();
        lastName().sendKeys(lastname);
    }
    public void DayOfBirth()
    {
        WebElement Day = Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]"));
        s = new Select(Day);
        s.selectByIndex(12);
    }
    public void MonthOfBirth()
    {
        WebElement month = Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]"));
        s = new Select(month);
        s.selectByIndex(5);
    }
    public void YearOfBirth()
    {
        WebElement year = Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]"));
        s = new Select(year);
        s.selectByValue("1990");
    }
    public void enterEmail(String email)
    {
        WebElement emailElem = Hooks.driver.findElement(By.id("Email"));
        emailElem.clear();
        emailElem.sendKeys(email);
    }
    public void enterPasswords(String password, String confirmPwd)
    {
        WebElement pwd = Hooks.driver.findElement(By.id("Password"));
        pwd.clear();
        pwd.sendKeys(password);
        WebElement conpwd = Hooks.driver.findElement(By.id("ConfirmPassword"));
        conpwd.clear();
        conpwd.sendKeys(confirmPwd);
    }
    public WebElement registerBtn()
    {
        return Hooks.driver.findElement(By.id("register-button"));
    }
    public WebElement successMsg()
    {
        return Hooks.driver.findElement(By.className("result"));
    }
}
