package com.PageObjects;

import com.Automation.BaseObjectOperations;
import com.Automation.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BaseObjectOperations {

    public ProductsPage(DriverFactory driverFactory) {
        super(driverFactory);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"PRODUCTS\" AND name == \"PRODUCTS\" AND value == \"PRODUCTS\"")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement ProductsPage_Title;

    public boolean ProductsPageOpened() {
        return isDisplayed(ProductsPage_Title);
    }

    @Step("Open Product by name")
    public void OpenProductByName(String productName) throws Exception {
        WebElement elem = null;
        if (driverFactory.isAndroidPlatform()) {
            waitForElement(ProductsPage_Title, getDefaultWait());
            var elements = driver.findElements(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])"));
            for (WebElement e : elements) {
                if (e.getText().equalsIgnoreCase(productName))
                    elem = e;
            }

        } else {
            elem = driver.findElement(AppiumBy.
                    iOSNsPredicateString(String.format("label == \"%s\"", productName)));
        }
        if (elem != null)
            clickElement(elem);
        else
            throw new Exception("Could not find product with product name" + productName);
    }
}
