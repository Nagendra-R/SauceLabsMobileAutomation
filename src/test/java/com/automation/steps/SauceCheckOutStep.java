package com.automation.steps;

import com.automation.pages.CheckOutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceCheckOutStep {
    CheckOutPage checkOutPage = new CheckOutPage();

    @When("click on checkoutButton")
    public void clickOnCheckoutButton() {
        checkOutPage.clickOnCheckOutButton();
    }


}
