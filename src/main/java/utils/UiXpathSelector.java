package utils;

import android.Android;
import io.appium.java_client.android.AndroidDriver;


public class UiXpathSelector {

    private String xPath;
    private AndroidDriver driver;

    public UiXpathSelector(String xPath){
        this.xPath = xPath;
        driver = Android.driver();
    }

    public UiObject makeUiObject(){
        return new UiObject(driver.findElementByXPath(xPath));
    }
}