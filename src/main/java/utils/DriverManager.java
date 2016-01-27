package utils;

import api.android.Android;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by Artur on 1/24/2016.
 */
public class DriverManager {

    private static AndroidDriver driver;

    public DriverManager(URL appiumServer, DesiredCapabilities desiredCapabilities){
        driver = new AndroidDriver(appiumServer, desiredCapabilities);
    }

    public static AndroidDriver getDriver(){
        return driver;
    }

    public Android getAndroidDevice(){
        return new Android();
    }
}
