package com.Helper;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class ActionsHelper {

    // Performs Scroll action on element where text matches the provided parameter
    public static WebElement Scroll(String text, AndroidDriver driver){
        return driver.findElement(AppiumBy.androidUIAutomator(
                String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"%s\").instance(0));",
                        text)));
    }


    public static void Swipe(WebElement element, AppiumDriver driver, String direction){
        Map<String,Object> params=new HashMap<>();
        params.put("element",((RemoteWebElement)element).getId());
        params.put("direction", direction);
        driver.executeScript("mobile:swipe",params);
    }

    public static void Scroll(WebElement element, AppiumDriver driver, String direction){
        Map<String,Object> params=new HashMap<>();
        params.put("element",((RemoteWebElement)element).getId());
        params.put("direction", direction);
        driver.executeScript("mobile:scroll",params);
    }

    public static void SwipeAction(WebElement element, AndroidDriver driver, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }
}
