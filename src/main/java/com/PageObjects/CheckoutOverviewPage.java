package com.PageObjects;

import com.Automation.BaseObjectOperations;
import com.Automation.DriverFactory;
import com.Helper.ActionsHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BaseObjectOperations {

    public CheckoutOverviewPage(DriverFactory driverFactory) {
        super(driverFactory);
    }

    @AndroidFindBy(accessibility = "test-FINISH")
    @iOSXCUITFindBy(accessibility = "test-FINISH")
    WebElement finish_Button;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[7]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Total: $')]")
    WebElement total_Text;

    public void ClickFinishButton(){
        clickElementWithoutWait(finish_Button);
    }

    public String GetTotal(){
        if(IsPlatformAndroid()){
            ActionsHelper.Scroll("FINISH", (AndroidDriver) driver);
            return getAttributeValue(total_Text, "text");
        }
        else {
           var elem =  driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Total: $')]"));
            return getAttributeValue(elem, "value");
        }

    }


}
