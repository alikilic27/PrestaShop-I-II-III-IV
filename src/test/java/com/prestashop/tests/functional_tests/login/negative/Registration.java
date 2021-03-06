package com.prestashop.tests.functional_tests.login.negative;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends TestBase {

      @Test
    public void registration1(){
          homePage.openHomePageUrl();
          homePage.signInButton.click();
          //input invalid email type
          signInPage.singUpEmail.sendKeys("asdf");
          signInPage.createAccountButton.click();
          Assert.assertTrue(driver.findElement(By.xpath("//li[.='Invalid email address.']")).isDisplayed());
      }

    @Test
    public void registration2(){
        homePage.openHomePageUrl();
        homePage.signInButton.click();
        //input valid email address but already registered one.
        signInPage.singUpEmail.sendKeys("a111@gmail.com");
        signInPage.createAccountButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'has already been registered')]")).isDisplayed());
    }
}
