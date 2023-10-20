package com.PageObjects;

import com.Automation.BaseObjectOperations;
import com.Automation.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutPage extends BaseObjectOperations {

    public CheckoutPage(DriverFactory driverFactory) {
        super(driverFactory);
    }

    @AndroidFindBy(accessibility = "test-First Name")
    @iOSXCUITFindBy(accessibility = "test-First Name")
    WebElement firstName_Text;

    @AndroidFindBy(accessibility = "test-Last Name")
    @iOSXCUITFindBy(accessibility = "test-Last Name")
    WebElement lastName_Text;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    @iOSXCUITFindBy(accessibility = "test-Zip/Postal Code")
    WebElement zipCode_Text;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    @iOSXCUITFindBy(accessibility = "test-CONTINUE")
    WebElement continue_Button;

    @Step("Login into the app")
    public CheckoutPage FillInformation(String fName, String lName, String code){

        sendKeys(firstName_Text, fName);
        sendKeys(lastName_Text, lName);
        sendKeys(zipCode_Text, code);
        return this;
    }

    public CheckoutPage clickContinue(){
        clickElement(continue_Button);
        return this;
    }

    public CheckoutPage fNameValidationIsVisible(boolean expected){
        var elem = driver.findElement(AppiumBy.accessibilityId("First Name is required"));
        Assert.assertEquals(elem.isDisplayed(),expected);
        return this;
    }
}
