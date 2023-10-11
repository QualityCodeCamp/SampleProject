package com.Automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CapabilityManager {
    public static UiAutomator2Options getAndroidCapability(String deviceName, String deviceid,String appName){
        UiAutomator2Options androidcapabilities= new UiAutomator2Options();
        androidcapabilities.setUdid(deviceid);
        androidcapabilities.setDeviceName(deviceName);
        androidcapabilities.setApp(appName);
        androidcapabilities.setNoReset(true);
        androidcapabilities.setAutoGrantPermissions(true);

        return androidcapabilities;
    }

    public static XCUITestOptions getIOSCapability(String deviceName,String appName){
        XCUITestOptions ioscapabilities= new XCUITestOptions();
        ioscapabilities.setDeviceName(deviceName);
        ioscapabilities.setApp(appName);
        ioscapabilities.setWdaLaunchTimeout(Duration.ofSeconds(20));
        return ioscapabilities;
    }

}
