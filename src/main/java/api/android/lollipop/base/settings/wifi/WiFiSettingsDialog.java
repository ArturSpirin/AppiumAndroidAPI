package api.android.lollipop.base.settings.wifi;

import api.android.Android;
import api.android.universal.Objects;
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
            Objects.button1().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Connect button absent");
        }
        return new WiFiSettings();
    }

    public WiFiSettings tapForget(){
        try{
            Objects.button3().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Forget button absent");
        }
        return new WiFiSettings();
    }

    public WiFiSettings tapCancel(){
        try{
            Objects.button2().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Cancel button absent");
        }
        return new WiFiSettings();
    }
}
