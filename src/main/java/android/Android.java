package android;

import adb.ADB;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by Artur Spirin on 1/20/16.
 **/
public class Android {

    /**
     * Aggregation. Android has a relationship with ADB and AndroidDriver.
     * Once a new instance of Android is created ADB and AndroidDriver methods become available for that specific Android device
     */
    public ADB adb;
    public AndroidDriver driver;

    public Android(URL appiumServer, DesiredCapabilities desiredCapabilities){
        adb = new ADB(desiredCapabilities.getCapability("deviceName").toString());
        driver = new AndroidDriver(appiumServer, desiredCapabilities);
    }
}
