package com.Automation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {
public  DriverFactory driverFactory=new DriverFactory();

@Parameters({"DEVICE_NAME","DEVICE_ID","PLATFORM","PLATFORM_VERSION","DRIVER_URL","APP_NAME"})
@BeforeClass
    public void initsetup(String deviceName,String deviceId,String platform, String platformversion,String driverURL,String appName){
        int counter =0;
        boolean driverSetupDone=false;
        try{
         while (counter<3){
        System.out.println("Value of Counter is " + counter);
        driverFactory.setDeviceId(deviceId);
        driverFactory.setDeviceName(deviceName);
        driverFactory=startapp(deviceName,deviceId,platform,driverURL,appName);
        driverSetupDone=true;
        break;

         }
            if(driverSetupDone){
                System.out.println("Driver created");
            }




}
catch (Exception e){
e.printStackTrace();
}
    }


    private  static  synchronized DriverFactory startapp(String deviceName,String DeviceId, String platform, String driverURL,String appName) throws MalformedURLException {
       DriverFactory driverFactory =new DriverFactory();
       driverFactory.setTargetPlatform(System.getProperty("PLATFORM",platform));

       driverFactory.setMobileDriver(deviceName,DeviceId,driverURL,platform,appName);
       return driverFactory;
    }



    public  void tearDown(){
    System.out.println("Quiting driver");
    driverFactory.getdriver().quit();
    }
}
