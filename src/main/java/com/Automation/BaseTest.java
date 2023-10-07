package com.Automation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {
    public DriverFactory driverFactory = new DriverFactory();

    @Parameters({"DEVICE_NAME", "DEVICE_ID", "PLATFORM", "PLATFORM_VERSION", "DRIVER_URL", "APP_NAME"})
    @BeforeClass
    public void initSetup(String deviceName, String deviceId, String platform, String platformversion, String driverURL, String appName) {
        int attemptCount = 0;
        while (attemptCount < 3) {
            System.out.println("Value of Counter is " + attemptCount);

            driverFactory.setDeviceId(deviceId);
            driverFactory.setDeviceName(deviceName);

            try {
                driverFactory = startapp(deviceName, deviceId, platform, driverURL, appName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (driverFactory.getDriver() != null) {
                System.out.println("Driver created successfully");
                break;
            }
            attemptCount++;
        }

    }

    private static synchronized DriverFactory startapp(String deviceName, String DeviceId, String platform, String driverURL, String appName) throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.setTargetPlatform(System.getProperty("PLATFORM", platform));

        driverFactory.setMobileDriver(deviceName, DeviceId, driverURL, platform, appName);
        return driverFactory;
    }

    public void tearDown() {
        System.out.println("Quiting driver");
        driverFactory.getDriver().quit();
    }
}
