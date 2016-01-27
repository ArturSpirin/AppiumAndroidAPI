package api.android.lollipop.base.settings.wifi;

import api.android.Android;
import org.openqa.selenium.NoSuchElementException;
import utils.UiObject;
import utils.UiSelector;

/**
 * Created by Artur on 1/24/2016.
 */
public class WiFiSettingsDialog extends Android {

    public static UiObject
            networkID = null,
            passwordField = null;

    public UiObject passwordField(){
        if(passwordField == null) passwordField = new UiSelector().resourceId("android.settings:id/password").makeUiObject();
        return passwordField;
    }

    public UiObject networkID(){
        if(networkID == null) networkID = new UiSelector().resourceId("android:id/alertTitle").makeUiObject();
        return networkID;
    }

    public WiFiSettings tapConnect(){
        try{
            objects.button1().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Connect button absent");
        }
        return new WiFiSettings();
    }

    public WiFiSettings tapForget(){
        try{
            objects.button3().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Forget button absent");
        }
        return new WiFiSettings();
    }

    public WiFiSettings tapCancel(){
        try{
            objects.button2().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cancel button absent");
        }
        return new WiFiSettings();
    }
}
