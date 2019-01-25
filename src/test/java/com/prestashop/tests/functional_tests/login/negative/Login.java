package com.prestashop.tests.functional_tests.login.negative;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    public void negativeLogin1(){
        homePage.openHomePageUrl();
        homePage.signInButton.click();
        signInPage.submit.click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[.='An email address required.']")).isDisplayed());
    }

    @Test
    public void negativeLogin2(){
        homePage.openHomePageUrl();
        homePage.signInButton.click();
        signInPage.signIn("invalidUsername","invalidPassword");
        Assert.assertTrue(driver.findElement(By.xpath("//ol/li")).isDisplayed());
    }
}
