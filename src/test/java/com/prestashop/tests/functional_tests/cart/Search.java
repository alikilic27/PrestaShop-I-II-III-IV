package com.prestashop.tests.functional_tests.cart;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends TestBase {
    @Test
    public void search() {

        homePage.openHomePageUrl();
        homePage.signInButton.click();
        signInPage.signIn("username","password");
        signInPage.search("searchItem1");

        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Blouse')]")).
                getText().toLowerCase().replace("\"",""), ConfigurationReader.getProperty("searchItem1").toLowerCase());

    }
}
