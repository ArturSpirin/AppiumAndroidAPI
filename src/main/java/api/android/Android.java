package api.android;

import api.android.lollipop.base.settings.Settings;
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
    public Settings settings;

    public Android(){
        if(driver == null) driver = DriverManager.getDriver();
        if(adb == null) adb = new ADB(driver.getCapabilities().getCapability("deviceName").toString());
        if(settings == null) settings = new Settings();
    }

    public void scrollDown(){
        Dimension size = driver.manage().window().getSize();
            int width =  size.getWidth();
            int height = size.getHeight();
        new TouchAction(driver)
                .press(width/2, height-200)
                .waitAction(1500)
                .moveTo(width/2, +700).release().perform();
    }

    public void scrollUp(){
        Dimension size = driver.manage().window().getSize();
            int width =  size.getWidth();
            int height = size.getHeight();
        new TouchAction(driver)
                .press(width/2, +400)
                .waitAction(1500)
                .moveTo(width/2, +height-400).release().perform();
    }

    public void swipeLeft(int region){
        if(region>20) throw new RuntimeException("Screen height is divided in 20 slices. Use int value between 1 and 20 "+
                                                 " inclusive, to specify more precise location to perform the swipe");
        Dimension size = driver.manage().window().getSize();
            int startx = (int) (size.width * 0.8);
            int endx = (int) (size.width * 0.20);
            int height = size.getHeight();
            int increment = height/20;
            int starty = increment * region;
        driver.swipe(startx, starty, endx, starty, 500);
    }

    public void swipeRight(int region){
        if(region>20) throw new RuntimeException("Screen height is divided in 20 slices. Use int value between 1 and 20"+
                                                 " inclusive, to specify more precise location to perform the swipe");
        Dimension size = driver.manage().window().getSize();
            int endx = (int) (size.width * 0.8);
            int startx = (int) (size.width * 0.20);
            int height = size.getHeight();
            int increment = height/20;
            int starty = increment * region;
        driver.swipe(startx, starty, endx, starty, 500);
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
