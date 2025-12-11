package com.automation.tests;

import automation.Base.BaseClass;
import automation.utils.JsonReader;
import automation.utils.TestListener;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
@Listeners(TestListener.class)
public class RegisterTests extends BaseClass {
    @Test
    public void newUserOnboarding() throws InterruptedException {
        registerPage.newUserRegister();
    }
    @Test
    public void userLogin() throws InterruptedException {
        registerPage.userLogin();
    }
}
