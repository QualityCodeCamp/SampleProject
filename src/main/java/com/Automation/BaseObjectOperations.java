package com.Automation;

import com.Automation.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseObjectOperations {
    private static final  int NO_WAITING_TIMEOUT_INT=0;

    private static final  int DEFAULT_WAITING_TIMEOUT_INT=60;
    private static final  int LONG_WAITING_TIMEOUT_INT =120;
    private static final  int SHORT_WAITING_TIMEOUT_INT=30;
    private AppiumDriver driver;
    private WebDriverWait defaultWait;
    private WebDriverWait longWait;
    private WebDriverWait shortWait;
    public static  final Duration NO_WAITING_TIMEOUT=Duration.ofSeconds(NO_WAITING_TIMEOUT_INT);
    public DriverFactory driverFactory;

    public BaseObjectOperations(DriverFactory driverFactory){
        this.driver=driverFactory.getdriver();
        this.driverFactory=driverFactory;
        PageFactory.initElements(new AppiumFieldDecorator(driver,NO_WAITING_TIMEOUT),this);
        defaultWait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_WAITING_TIMEOUT_INT));
        longWait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_WAITING_TIMEOUT_INT));
        shortWait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_WAITING_TIMEOUT_INT));
    }

    public  void ClickElement(WebElement element){
        waitforElement(element,defaultWait);
        element.click();
    }
    public   void waitforElement(WebElement element,WebDriverWait wait){
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }
}
