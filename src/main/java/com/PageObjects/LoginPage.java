package com.PageObjects;

import com.Automation.BaseObjectOperations;
import com.Automation.DriverFactory;
import com.Helper.MessageConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.testng.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseObjectOperations {

    public LoginPage(DriverFactory driverFactory) {
        super(driverFactory);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"test-Username\"]")
    @AndroidFindBy(accessibility = "test-Username")
    private WebElement userName_TextField;

    @iOSXCUITFindBy(accessibility = "test-Password")
    @AndroidFindBy(accessibility = "test-Password")
    private WebElement password_TextField;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement login_Button;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement errorMessage_Text;

    @Step("Login into the app")
    public void LoginAction(String username, String password) {
       sendKeys(userName_TextField, username);
       sendKeys(password_TextField, password);
       clickElement(login_Button);
    }

    public void LoginAction_Negative_IncorrectPassword(String username, String password) {
        LoginAction(username, password);
        Assert.assertTrue(errorMessage_Text.isDisplayed(), MessageConstants.GeneralAssertionMessage);
        Assert.assertEquals(getText(errorMessage_Text), MessageConstants.InvalidUserNamePasswordMessage);
    }

    public void LoginAction_Negative_LockedUser(String username, String password) {
        LoginAction(username, password);
        Assert.assertTrue(errorMessage_Text.isDisplayed(), MessageConstants.GeneralAssertionMessage);
        Assert.assertEquals(getText(errorMessage_Text), MessageConstants.LockedOutUserMessage);
    }

}
