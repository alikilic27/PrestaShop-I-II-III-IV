package com.prestashop.tests.functional_tests.login.Positive;

import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

     @Test
    public void loginPositive(){
         homePage.openHomePageUrl();
         homePage.signInButton.click();
         signInPage.signIn("username","password");
       Assert.assertTrue(driver.getTitle().contains("My account"));
    }
}
