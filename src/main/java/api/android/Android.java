package api.android;

import api.android.lollipop.base.notifications.Notifications;
import api.android.lollipop.base.settings.wifi.WiFiSettings;
import api.android.universal.Objects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ADB;
import utils.DriverManager;

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
    private static AndroidDriver dr = null;
    public Objects objects = new Objects();

    public Android(){
        driver = dr = DriverManager.getDriver();
        adb = new ADB(driver.getCapabilities().getCapability("deviceName").toString());
    }

    public static AndroidDriver driver(){
        if(dr==null) throw new RuntimeException("Android Driver was not initialized. Create new instance of the Android class first");
        return dr;
    }

    public void pressBack(){
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    public void pressHome(){
        driver.pressKeyCode(AndroidKeyCode.HOME);
    }

    public static boolean isVisible(WebElement element){
        try{
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
