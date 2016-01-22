import adb.ADB;

import java.net.MalformedURLException;
import java.util.LinkedList;

/**
 * Created by Artur Spirin on 1/21/16.
 **/
public class BaseTest {

    public static void main(String[] args) throws MalformedURLException {
        /*
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability("deviceName", "ZX1G22BV8Z");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("app", "./build/unlock_apk/unlock_apk-debug.apk");

        Android android = new Android(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        */
        ADB adb = new ADB("ZX1G22BV8Z");
        LinkedList items = adb.getDirectoryContent("/sdcard/");
        System.out.println();
    }
}
