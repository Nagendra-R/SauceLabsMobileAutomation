package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SauceLoginStep {
    LoginPage loginPage = new LoginPage();

    @Given("user opens the application")
    public void user_opens_the_application() {

    }

    @Then("verify user open login page")
    public void verifyUserOnOpenLoginPage() {
        Assert.assertTrue(loginPage.userOnLoginPage());
    }

    @And("scroll till end")
    public void scrollTillEnd() {
        loginPage.scrollTillEndInLoginPage();
    }

    @Then("print all usernames and password")
    public void printAllUsernamesAndPassword() {
        loginPage.printUsernamesAndPassword();
    }

    @Then("user login with {string} and {string}")
    public void userLoginWithAnd(String username, String password) {
        loginPage.doLogin(ConfigReader.getConfigValue(username),ConfigReader.getConfigValue(password));
    }



}
