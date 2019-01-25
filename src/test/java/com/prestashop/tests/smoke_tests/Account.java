package com.prestashop.tests.smoke_tests;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Account extends TestBase {

    @Test
    public  void smokeTestAccount(){
        homePage.openHomePageUrl();
        homePage.signInButton.click();
        signInPage.signIn("username","password");

        Assert.assertTrue(driver.getTitle().contains("My account"));
        Assert.assertTrue(myAccountPage.signedInUser.isDisplayed());
        myAccountPage.information.click();

        Assert.assertTrue(driver.getTitle().contains("Identity"));

        Assert.assertEquals(identityPage.firstName.getAttribute("value")+" "+identityPage.lastName.getAttribute("value"),
                                        myAccountPage.signedInUser.getText() );
        identityPage.save.click();

        Assert.assertTrue(identityPage.errorMessage.isDisplayed());

        identityPage.backToAccount.click();

        Assert.assertTrue(driver.getTitle().contains("My account"));

        myAccountPage.myAddresses.click();

        driver.findElement(By.xpath("//span[.='Add a new address']/..")).click();
        Assert.assertEquals(identityPage.firstName.getAttribute("value")+" "+identityPage.lastName.getAttribute("value"),
                myAccountPage.signedInUser.getText() );
        identityPage.firstName.clear();
        driver.findElement(By.id("submitAddress")).click();
        Assert.assertTrue(identityPage.errorMessage.isDisplayed());

    }
}
