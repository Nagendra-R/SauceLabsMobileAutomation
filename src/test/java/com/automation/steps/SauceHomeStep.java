package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SauceHomeStep {
    HomePage homePage =new HomePage();


    @Then("verify user on home page")
    public void verifyUserOnHomePage() {
        Assert.assertTrue(homePage.verifyUserOnHomePage());
    }


    @When("scroll and print the titles of the items")
    public void scrollAndPrintTheTitlesOfTheItems() {
        homePage.scrollAndPrintTitles();
    }

    @When("click on add to cart")
    public void clickOnAddToCart() {
        homePage.clickOnCartButton();

    }

    @Then("verify remove button is displayed")
    public void verifyRemoveButtonIsDisplayed() {
        Assert.assertTrue(homePage.removeButtonIsDisplayed());
    }

    @When("filter the price by {string}")
    public void filterThePriceBy(String highToLow) {
        homePage.filterByPrice(highToLow);

    }

    @Then("verify the price is sorted in desc order")
    public void verifyThePriceIsSortedInDescOrder() {
       Assert.assertTrue( homePage.verifyThePriceInDescOrder());
    }

    @When("click on first item")
    public void clickOnFirstItem() {
        homePage.clickOnFirstItem();
    }

    @And("scroll till the add to cart is visible")
    public void scrollTillTheAddToCartIsVisible() {
        homePage.scrollTillAddToCartAndClick();
    }

    @And("click on add to cart button")
    public void clickOnAddToCartButton() {
        homePage.clickOnAddToCartButton();
    }

    @And("click on cart button")
    public void clickOnCartButton() {
        homePage.clickCartIsAdded();
    }

    @Then("verify item is present in checkout page")
    public void verifyItemIsPresentInCheckoutPage() {
       Assert.assertTrue( homePage.verifyUserOnCheckOutPage());
    }


}
