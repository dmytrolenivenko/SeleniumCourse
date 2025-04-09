package com.omni;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorVlaidation extends BaseTest{

    @Test
    public void wrongLogin() {
        launchApplication();
        landingPage.goTo();
        landingPage.login("wrong@email.com", "wrongpassword");
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
    }   
    

}
