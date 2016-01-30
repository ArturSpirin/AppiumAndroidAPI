package utils;

import api.android.Android;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by Artur on 1/24/2016.
 */
public class DriverManager{

    private static AndroidDriver driver;
    private static Android android;

    public DriverManager(URL appiumServer, DesiredCapabilities desiredCapabilities){
        driver = new AndroidDriver(appiumServer, desiredCapabilities);
        android = new Android();
    }

    public static AndroidDriver getDriver(){
        if(driver == null) throw new RuntimeException("DriverManager was not initialized");
        return driver;
    }

    public static Android getAndroid(){
        if(android == null) throw new RuntimeException("DriverManager was not initialized");
        return android;
    }
}
