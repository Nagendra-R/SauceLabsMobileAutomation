package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{

   @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT']")
    WebElement checkOutButton;



   public void clickOnCheckOutButton() {
       clickOnElementIfPresent(checkOutButton);
   }

}
