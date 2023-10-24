package com.PageObjects;

import com.Automation.BaseObjectOperations;
import com.Automation.DriverFactory;
import com.Helper.ActionsHelper;
import com.Helper.GestureDirection;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class CartPage extends BaseObjectOperations {

    public CartPage(DriverFactory driverFactory){
        super(driverFactory);
    }

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    @iOSXCUITFindBy(accessibility = "test-CHECKOUT")
    WebElement checkout_Button;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Delete\"]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"test-Delete\"])[1]")
    WebElement delete_Button;

    public void ContinueShopping(){
        driver.findElement(AppiumBy.accessibilityId("test-CONTINUE SHOPPING")).click();
    }

    @Step("Click on Checkout")
    public void     Checkout(){

        if (driverFactory.isAndroidPlatform()) {
           ActionsHelper.Scroll("CHECKOUT", (AndroidDriver) driver);
       }
        else{
            HashMap<String, String> scrollObject = new HashMap<>();
            JavascriptExecutor js = driver;
            scrollObject.put("direction", "down");
            js.executeScript("mobile: scroll", scrollObject);
        }
        clickElement(checkout_Button);
    }

    public void ClickProductRemove(){
        WebElement elem;
        if (driverFactory.isAndroidPlatform()) {
            elem = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Delete\"]/android.view.ViewGroup"));
        }
        else
            elem = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"test-Delete\"])[1]"));
        clickElement(elem);
    }

    public CartPage SwipeLeftOnProduct(String productName){
        WebElement elem = null;
        if (driverFactory.isAndroidPlatform()) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            elem = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]/android.widget.TextView"));
            //ActionsHelper.SwipeAction(elem, (AndroidDriver) driver, GestureDirection.LEFT.getAction());
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "left", 500, "top", 500, "width", 500, "height", 500,
                    "direction", "left",
                    "percent", 0.10,
                    "speed",5000
            ));

        }
            else {

            elem = driver.findElement(AppiumBy.accessibilityId(productName));

            ActionsHelper.Swipe(elem, driver, GestureDirection.LEFT.getAction());
        }
        return this;
    }
}
