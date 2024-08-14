package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    WebElement menuButton;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    List<WebElement> itemTitles;

    @FindBy(xpath = "//android.widget.TextView[@text='Terms of Service | Privacy Policy']")
    WebElement termsAndPolicyTitle;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]")
    WebElement addToCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    WebElement removeButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
    WebElement filterButton;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    List<WebElement> listOfPrices;

    @FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Backpack']")
    WebElement firstItem;

    @FindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    WebElement addToCartBut;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    WebElement cartItems;

    @FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Backpack']")
    WebElement itemTitleInAddToCartPage;

    @FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Backpack']")
    WebElement itemTitleInCheckOutPage;





    public boolean verifyUserOnHomePage() {
        return isPresent(menuButton);
    }

    public void scrollAndPrintTitles() {

        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

//        do{
//            for (WebElement itemTitle : itemTitles) {
//                System.out.println(itemTitle.getText());
//            }
//            scrollOrSwipe(width/2,height/2,width/3,0);
//        }while(!isPresent(termsAndPolicyTitle));
//
        while (!isPresent(termsAndPolicyTitle)) {

            for (WebElement itemTitle : itemTitles) {
                System.out.println(itemTitle.getText());
            }

            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }
        for (WebElement itemTitle : itemTitles) {
            System.out.println(itemTitle.getText());
        }

    }

    public void clickOnCartButton() {
        clickOnElementIfPresent(addToCartButton);
    }


    public boolean removeButtonIsDisplayed() {
        return isPresent(removeButton);
    }

    public void filterByPrice(String highToLow) {
        clickOnElementIfPresent(filterButton);
        String xpath = "//android.widget.TextView[@text='%s']";
        String loc = String.format(xpath, highToLow);
        driver.findElement(By.xpath(loc)).click();
    }

    public boolean verifyThePriceInDescOrder() {
        List<Double> prices = new ArrayList<>();

        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        while (!isPresent(termsAndPolicyTitle)) {
            for (WebElement eachPrice : listOfPrices) {
                String str = eachPrice.getText();
                String[] arr = str.split("\\$");
                Double amount = Double.parseDouble(arr[1]);
                System.out.println(amount);
                prices.add(amount);
            }
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }

        for (WebElement eachPrice : listOfPrices) {
            String str = eachPrice.getText();
            String[] arr = str.split("\\$");
            Double amount = Double.parseDouble(arr[1]);
            System.out.println(amount);
            prices.add(amount);
        }

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i + 1) > prices.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void clickOnFirstItem() {
        firstItem.click();
    }

    public void scrollTillAddToCartAndClick() {
        while(!isPresent(addToCartBut)){
            int width = driver.manage().window().getSize().getWidth();
            int height = driver.manage().window().getSize().getHeight();
            scrollOrSwipe(width/2,height/2,width/2,0);
        }



    }

    public void clickOnAddToCartButton() {
        clickOnElementIfPresent(addToCartBut);
    }

    public void clickCartIsAdded() {
        cartItems.click();
    }

    public boolean verifyUserOnCheckOutPage() {
        return itemTitleInAddToCartPage.getText().equals(itemTitleInCheckOutPage.getText());
    }
}
