import api.android.Android;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.DriverManager;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Artur Spirin on 1/21/16.
 **/
public class BaseTest {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("deviceName", "ZX1G22BV8Z");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("app", "./build/unlock_apk/unlock_apk-debug.apk");

        new DriverManager(new URL("http://0.0.0.0:4722/wd/hub"), desiredCapabilities);
        Android android = DriverManager.getAndroid();

        android.settings.open().tapAboutPhone();
        android.driver.quit();
    }
}
