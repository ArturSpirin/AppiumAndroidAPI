package android;

import adb.ADB;
import android.objects.lollipop.base.Desktop;
import android.objects.universal.Objects;
import io.appium.java_client.android.AndroidDriver;
import org.apache.xpath.operations.And;
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
    private static AndroidDriver dr = null;
    public static Objects objects = new Objects();

    public Android(){

    }

    public Android(URL appiumServer, DesiredCapabilities desiredCapabilities){
        adb = new ADB(desiredCapabilities.getCapability("deviceName").toString());
        driver = new AndroidDriver(appiumServer, desiredCapabilities);
        dr = driver;
    }

    public static AndroidDriver driver(){
        if(dr==null) throw new RuntimeException("Android Driver was not initialized. Create new instance of the Android class first");
        return dr;
    }

    //TODO Finish
    public static Desktop tapHome(){
        return new Desktop();
    }
}
