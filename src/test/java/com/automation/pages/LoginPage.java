package com.automation.pages;

import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    WebElement loginButton;

    @FindBy(xpath ="//android.widget.TextView[contains(@text,'_user')]")
    List<WebElement> listOfUsernames;

    @FindBy(xpath = "//android.widget.TextView[@text='secret_sauce']")
    WebElement passwordText;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    WebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    WebElement passwordField;

    public boolean userOnLoginPage() {
//        SupportsContextSwitching supportsContextSwitching = (SupportsContextSwitching) driver;
//        System.out.println(Arrays.toString(supportsContextSwitching.getContextHandles().toArray()));
        return isPresent(loginButton);
    }

    public void scrollTillEndInLoginPage() {

        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        while (!isPresent(passwordText)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }

    }

    public void printUsernamesAndPassword() {
//        usernames
        for(int i=0;i<listOfUsernames.size();i++){
            System.out.println(listOfUsernames.get(i).getText());
        }


        System.out.println("==============================>");
        //password

        System.out.println(passwordText.getText());



    }

    public void doLogin(String username, String password) {
        usernameField.click();
        usernameField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
        clickOnElementIfPresent(loginButton);
    }
}
