package com.automation.pages;

import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends  BasePage{

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    WebElement firstNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    WebElement lastNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    WebElement codeField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE']")
    WebElement continueButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Payment Information:']")
    WebElement paymentDescription;


    @FindBy(xpath = "//android.widget.TextView[@text='FINISH']")
    WebElement finishButton;

    @FindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    WebElement finalMessageField;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Checkout: Your Info']/android.view.ViewGroup")
    WebElement closeKeyBoard;



    public boolean checkUserOnShippingPage() {
        return  isPresent(firstNameField) && isPresent(lastNameField);
    }

    public void fillDetails(String firstname, String lastname, String code) {
        firstNameField.click();
        firstNameField.sendKeys(firstname);
        lastNameField.click();
        lastNameField.sendKeys(lastname);
        codeField.click();
        codeField.sendKeys(code);
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        scrollOrSwipe(width/2,height/2,width/2,0);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public boolean verifyOnDescription() {
        return isPresent(paymentDescription);
    }

    public void scrollAndClickOnFinishButton() {
        while(!isPresent(finishButton)){
            int width = driver.manage().window().getSize().getWidth();
            int height = driver.manage().window().getSize().getHeight();
            scrollOrSwipe(width/2,height/2,width/3,0);
        }
        clickOnElementIfPresent(finishButton);
    }

    public boolean checkOrderConfirmation(String finalMessage) {

        System.out.println(finalMessage);
        System.out.println(finalMessageField.getText());
        return  finalMessageField.getText().equals(finalMessage);
    }
}


