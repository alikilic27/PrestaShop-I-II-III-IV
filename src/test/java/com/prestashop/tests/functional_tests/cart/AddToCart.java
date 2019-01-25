package com.prestashop.tests.functional_tests.cart;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends TestBase {

    @Test
    public void addToCart(){

        homePage.openHomePageUrl();
        homePage.signInButton.click();
        signInPage.signIn("username","password");
        signInPage.search("searchItem1");

        actions.moveToElement(searchPage.itemNumber(1)).perform();
        searchPage.addToCart().click();
        itemPage.controlClick.click();

        Assert.assertEquals(itemPage.itemNameTempWindow.getText(), ConfigurationReader.getProperty("searchItem1"));
        Assert.assertEquals(itemPage.itemQuantityTempWindow.getText(),"1");
        itemPage.continueShopping.click();
        actions.moveToElement(searchPage.itemNumber(1)).perform();
        searchPage.addToCart().click();
        itemPage.controlClick.click();
        Assert.assertEquals(itemPage.itemQuantityTempWindow.getText(),"2");

    }
}
