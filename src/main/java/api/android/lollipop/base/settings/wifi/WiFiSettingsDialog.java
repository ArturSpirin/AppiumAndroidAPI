package api.android.lollipop.base.settings.wifi;

import api.android.Android;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.UiObject;
import utils.UiSelector;

import java.net.URL;

/**
 * Created by Artur on 1/24/2016.
 */
public class WiFiSettingsDialog extends Android {

    WiFiSettingsDialog(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/alertTitle\")")
    public WebElement networkID;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.settings:id/password\")")
    public WebElement passwordField;

    public WiFiSettings tapConnect(){
        try{
            objects.button1.click();
        }catch (NoSuchElementException e){
            throw new AssertionError("Connect button absent");
        }
        return new WiFiSettings();
    }

    public WiFiSettings tapForget(){
        try{
            objects.button3.click();
        }catch (NoSuchElementException e){
            throw new AssertionError("Forget button absent");
        }
        return new WiFiSettings();
    }

    public WiFiSettings tapCancel(){
        try{
            objects.button2.click();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cancel button absent");
        }
        return new WiFiSettings();
    }
}
