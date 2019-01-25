package com.prestashop.tests.functional_tests.login.Positive;

import com.prestashop.utilities.FakerBase;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.prestashop.utilities.FakerBase.*;

public class Registration extends TestBase {

    @Test
    public void registration1(){

        homePage.openHomePageUrl();
        homePage.signInButton.click();
        signInPage.singUpEmail.sendKeys(FakerBase.fakeEmailAddress);
        signInPage.createAccountButton.click();
        registrationPage.register();

        Assert.assertTrue(driver.getTitle().contains("My account"));
        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='View my customer account']//span")).getText(),
                            fakeFirstName+" "+fakeLastName);
        System.out.println("Sign in credentials:\n "+ fakeFirstName+"\n"+fakeLastName+ "\n"+fakeEmailAddress+"\n"+"Password: "+fakePassword);
    }
}
