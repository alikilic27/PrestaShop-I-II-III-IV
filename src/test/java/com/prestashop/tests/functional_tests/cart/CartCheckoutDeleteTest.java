package com.prestashop.tests.functional_tests.cart;

import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartCheckoutDeleteTest extends TestBase {

    @Test
    public void cartCheckoutDeleteTest() throws InterruptedException {

        homePage.openHomePageUrl();
        actions.moveToElement(searchPage.itemNumber(2)).perform();
        searchPage.addToCart().click();
        itemPage.continueShopping.click();
        actions.moveToElement(searchPage.itemNumber(4)).perform();
        searchPage.addToCart().click();
        itemPage.proceedToCheckout.click();
        Assert.assertEquals(orderPage.cartItemCountInfotmation.getText(),"Your shopping cart contains: 2 Products");
        orderPage.iconTrash(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(orderPage.cartItemCountInfotmation.getText(),"Your shopping cart contains: 1 Product");
        Thread.sleep(1000);
        orderPage.iconTrash(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(orderPage.alertMessage.getText(),"Your shopping cart is empty.");

    }
}
