package api.android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.Dimension;
import utils.ADB;
import utils.cURL;


/**
 * Created by Artur Spirin on 1/20/16.
 **/
public class Android {

    /**
     * Aggregation.
     * Once a new instance of Android is created, ADB,cURL and AndroidDriver methods become available for that specific Android device
     */
    public ADB adb;
    public cURL curl;
    public static AndroidDriver driver;

    /**
     * @param driver Must initiate Android instance with the AndroidDriver
     */
    public Android(AndroidDriver driver){
        this.driver = driver;
        String deviceID = (String) driver.getCapabilities().getCapability("deviceName");
        this.adb = new ADB(deviceID);
        this.curl = new cURL();
    }

    /**
     * This is a simple method that divides the screen's width in half and does a swipe up motion
     */
    public void scrollDown(){
        Dimension size = driver.manage().window().getSize();
            int width =  size.getWidth();
            int height = size.getHeight();
        new TouchAction(driver)
                .press(width/2, height-200)
                .waitAction(1500)
                .moveTo(width/2, +700).release().perform();
    }

    /**
     * This is a simple method that divides the screen's width in half and does a swipe down motion
     */
    public void scrollUp(){
        Dimension size = driver.manage().window().getSize();
            int width =  size.getWidth();
            int height = size.getHeight();
        new TouchAction(driver)
                .press(width/2, +400)
                .waitAction(1500)
                .moveTo(width/2, +height-400).release().perform();
    }

    /**
     * This is a simple method that divides the screen's height in 20 slices and does a swipe motion to scroll down
     */
    public void scrollDown(int region){
        if(region>20) throw new RuntimeException("Screen height is divided in 20 slices. Use int value between 1 and 20 "+
                " inclusive, to specify more precise location to perform the swipe");
        Dimension size = driver.manage().window().getSize();
        int width =  size.getWidth();
        int height = size.getHeight();
        int increment = height/20;
        int start = increment*region;
        new TouchAction(driver)
                .press(width/2, start)
                .waitAction(1500)
                .moveTo(width/2, height-start).release().perform();
    }

    /**
     * This is a simple method that divides the screen's height in 20 slices and does a swipe motion to scroll down
     */
    public void scrollUp(int region){
        if(region>20) throw new RuntimeException("Screen height is divided in 20 slices. Use int value between 1 and 20 "+
                " inclusive, to specify more precise location to perform the swipe");
        Dimension size = driver.manage().window().getSize();
        int width =  size.getWidth();
        int height = size.getHeight();
        int increment = height/20;
        int start = increment*region;
        new TouchAction(driver)
                .press(width/2, +start)
                .waitAction(1500)
                .moveTo(width/2, +height-10).release().perform();
    }

    /**
     * Simple swipe action to the left.
     * @param region specifies the more precise location of where to do the swipe action
     */
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

    /**
     * Simple swipe action to the right.
     * @param region specifies the more precise location of where to do the swipe action
     */
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

    public void pressBack(){
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    public void pressHome(){
        driver.pressKeyCode(AndroidKeyCode.HOME);
    }
}
