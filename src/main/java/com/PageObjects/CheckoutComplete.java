package com.PageObjects;

import com.Automation.BaseObjectOperations;
import com.Automation.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutComplete extends BaseObjectOperations {

    public CheckoutComplete(DriverFactory driverFactory) {
        super(driverFactory);
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "THANK YOU FOR YOU ORDER")
    WebElement confirmation_Text;

    public String GetOrderConfirmation(){
        if (driverFactory.isAndroidPlatform()) {
            return getAttributeValue(confirmation_Text, "text");
        }

        return getAttributeValue(confirmation_Text, "value");
    }

    public void BackToHomeButton(){
        driver.findElement(AppiumBy.accessibilityId("test-BACK HOME"));
    }


}
