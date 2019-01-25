package com.prestashop.tests.functional_tests.cart;

import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOut extends TestBase {

    @Test
    public void checkOut() throws InterruptedException {
        homePage.openHomePageUrl();
        homePage.signInButton.click();
        signInPage.signIn("username","password");
        signInPage.search("searchItem1");

        actions.moveToElement(searchPage.itemNumber(1)).perform();
        searchPage.addToCart().click();
        itemPage.proceedToCheckout.click();
        searchPage.proceedToCheckoutInSummary.click();
        searchPage.proceedToCheckoutInAddress.click();
        searchPage.proceedToCheckoutInShipping.click();
        Assert.assertTrue(searchPage.error_YouMustAgree.getText().contains("You must agree"));
        searchPage.closeErrorMessage.click();
        Thread.sleep(1000);
        searchPage.checkBox_IAgree.click();
        searchPage.proceedToCheckoutInShipping.click();
        searchPage.payByCheck.click();
        searchPage.confirmOrder.click();
        Assert.assertTrue(searchPage.orderPlacedSuccessMessage.getText().contains("is complete"));

    }
}
