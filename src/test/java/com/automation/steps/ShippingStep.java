package com.automation.steps;

import com.automation.pages.ShippingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShippingStep {
    ShippingPage shippingPage = new ShippingPage();


    @Then("verify user on shipping details page")
    public void verifyUserOnShippingDetailsPage() {
        Assert.assertTrue(shippingPage.checkUserOnShippingPage());
    }

    @When("fill the firstname {string} lastname {string} and postalcode {string}")
    public void fillTheFirstnameLastnameAndPostalCode(String firstname, String lastname, String code) {
        shippingPage.fillDetails(firstname,lastname,code);
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        shippingPage.clickOnContinueButton();
    }

    @Then("verify user on verification page")
    public void verifyUserOnVerificationPage() {
        Assert.assertTrue(shippingPage.verifyOnDescription());
    }

    @When("user click on finish button")
    public void userClickOnFinishButton() {
        shippingPage.scrollAndClickOnFinishButton();
    }

    @Then("verify user successful message {string}")
    public void verifyUserSuccessfulMessage(String finalMessage) {
        Assert.assertTrue(shippingPage.checkOrderConfirmation(finalMessage));
    }

}
