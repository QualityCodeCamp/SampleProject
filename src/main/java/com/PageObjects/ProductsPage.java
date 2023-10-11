package com.PageObjects;

import com.Automation.BaseObjectOperations;
import com.Automation.DriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BaseObjectOperations {

    public ProductsPage(DriverFactory driverFactory) {
        super(driverFactory);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"PRODUCTS\" AND name == \"PRODUCTS\" AND value == \"PRODUCTS\"")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement ProductsPage_Title;

    public boolean ProductsPageOpened(){
       return isDisplayed(ProductsPage_Title);
    }
}
