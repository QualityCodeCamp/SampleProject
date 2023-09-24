package com.PageObjects;

import com.Automation.BaseObjectOperations;
import com.Automation.DriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Homepage extends BaseObjectOperations {

    @AndroidFindBy(accessibility = "Preference")
    private WebElement Preference;
    public Homepage(DriverFactory driverFactory) {
        super(driverFactory);
    }
// driver.findElement (AppiumBy.accessibilityId("Preference"));
    public void clickonpreference(){
        ClickElement(Preference);
    }
}

