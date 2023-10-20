package com.Automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseObjectOperations {
    private static final  int NO_WAITING_TIMEOUT_INT=0;

    private static final  int DEFAULT_WAITING_TIMEOUT_INT=60;
    private static final  int LONG_WAITING_TIMEOUT_INT =120;
    private static final  int SHORT_WAITING_TIMEOUT_INT=30;
    public AppiumDriver driver;

    public WebDriverWait getDefaultWait() {
        return defaultWait;
    }

    private WebDriverWait defaultWait;
    private WebDriverWait longWait;
    private WebDriverWait shortWait;
    public static  final Duration NO_WAITING_TIMEOUT=Duration.ofSeconds(NO_WAITING_TIMEOUT_INT);
    public DriverFactory driverFactory;

    public BaseObjectOperations(DriverFactory driverFactory){
        this.driver=driverFactory.getDriver();
        this.driverFactory=driverFactory;

        PageFactory.initElements(new AppiumFieldDecorator(driver,NO_WAITING_TIMEOUT),this);
        defaultWait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_WAITING_TIMEOUT_INT));
        longWait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_WAITING_TIMEOUT_INT));
        shortWait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_WAITING_TIMEOUT_INT));
    }

    public void clickElement(WebElement element){
        waitForElement(element,defaultWait);
        element.click();
    }

    public void clickElementWithoutWait(WebElement element){
        element.click();
    }

    public String getAttributeValue(WebElement element, String attribute){
        //waitForElement(element,defaultWait);
        return element.getAttribute(attribute);
    }

    public void sendKeys(WebElement element, String text){
        waitForElement(element,defaultWait);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed(WebElement element){
        waitForElement(element,defaultWait);
        return element.isDisplayed();
    }

    public String getText(WebElement element){
        waitForElement(element,defaultWait);
        return element.getText();
    }

    public void waitForElement(WebElement element,WebDriverWait wait){
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }
    public boolean IsPlatformAndroid(){
        return driver instanceof AndroidDriver;
    }
}
