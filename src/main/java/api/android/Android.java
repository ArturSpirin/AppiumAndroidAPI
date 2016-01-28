package api.android;

import api.android.universal.Objects;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.Dimension;
import utils.ADB;
import utils.DriverManager;


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
    public Objects objects = new Objects();

    public Android(){
        driver = DriverManager.getDriver();
        adb = new ADB(driver.getCapabilities().getCapability("deviceName").toString());
    }

    public void scrollDown(){
        Dimension size = driver.manage().window().getSize();
        new TouchAction(driver)
                .press(size.getWidth()/2,size.getHeight()-200)
                .waitAction(1500)
                .moveTo(size.getWidth()/2-600, -size.getHeight()+size.getHeight()+700).release().perform();
    }

    public void scrollUp(){
        Dimension size = driver.manage().window().getSize();
        new TouchAction(driver)
                .press(size.getWidth()/2,size.getHeight()-(size.getHeight()-400))
                .waitAction(1500)
                .moveTo(size.getWidth()/2-600, -size.getHeight()+size.getHeight()+size.getHeight()-400).release().perform();
    }

    public void scrollUp(int times){
        for(int i=times; i!=0; i--) scrollUp();
    }

    public void scrollDown(int times){
        for(int i=times; i!=0; i--) scrollDown();
    }

    public void pressBack(){
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    public void pressHome(){
        driver.pressKeyCode(AndroidKeyCode.HOME);
    }
}
