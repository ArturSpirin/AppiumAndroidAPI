package android.api.lollipop.base.settings.wifi;

import android.Android;
import org.openqa.selenium.NoSuchElementException;
import utils.UiObject;
import utils.UiSelector;

/**
 * Created by Artur on 1/24/2016.
 */
public class WiFiSettings_Dialog extends Android {

    private UiObject
            networkID,
            password;

    public UiObject networkID(){
        if(networkID==null) networkID = new UiSelector().resourceId("android:id/alertTitle").makeUiObject();
        return networkID;
    }

    public UiObject passwordField(){
        if(password==null) password = new UiSelector().resourceId("com.android.settings:id/password").makeUiObject();
        return password;
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
