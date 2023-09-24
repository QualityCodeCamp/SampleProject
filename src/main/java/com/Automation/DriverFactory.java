package com.Automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private AppiumDriver mobiledriver=null;
    private String targetplaform=null;
    private String deviceId=null;
    private String deviceName=null;
    public static InheritableThreadLocal<AppiumDriver> staticMobDriver =new InheritableThreadLocal<>();


    public synchronized void setTargetPlatform(String platform){
        targetplaform=platform;
    }


    public synchronized void setMobileDriver(String deviceName,String deviceId, String driverURL, String platform,String appName) throws MalformedURLException {
        if(platform.equalsIgnoreCase("Android")){
targetplaform=platform;
mobiledriver=new AndroidDriver(new URL(driverURL),CapabilityManager.getAndroidCapability(deviceName,deviceId,appName));

        }
        else if (platform.equalsIgnoreCase("iOS")){
            targetplaform=platform;
            mobiledriver=new IOSDriver(new URL(driverURL),CapabilityManager.getIOSCapability(deviceName,appName));

        }
        staticMobDriver.set(mobiledriver);
    }

    public  void setDeviceId(String deviceId){
        System.out.println("Setting deviceID "+ deviceId);
        this.deviceId=deviceId;

    }

    public  void setDeviceName(String deviceName){
        System.out.println("Setting deviceName "+ deviceName);
        this.deviceName=deviceName;
    }
    public AppiumDriver getdriver(){
        return  mobiledriver;
    }


    public boolean isAndroidPlatform(){
        if(targetplaform!=null && targetplaform.equalsIgnoreCase("Android")){
            return  true;

        }
        else if (System.getProperty("PLATFORM").equalsIgnoreCase("Android")){
            return true;
        } else {
                return  false;
            }

        }


        public  void performiosBiometricAuthentication(boolean match){
            ((IOSDriver)getdriver()).performTouchID(match);
        }

        public void navigateback(){
        System.out.println("Navigating back");
        this.getdriver().navigate().back();
        }


        public String getDeviceId(){
        return deviceId;

        }
        public String getDeviceName(){
        return  deviceName;
        }


}



