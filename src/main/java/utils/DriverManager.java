package utils;

import api.android.lollipop.base.settings.wifi.WiFiSettings;
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
}
