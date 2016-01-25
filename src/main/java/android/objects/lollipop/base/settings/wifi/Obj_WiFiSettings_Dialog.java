package android.objects.lollipop.base.settings.wifi;

import utils.UiObject;
import utils.UiSelector;

/**
 * Created by Artur on 1/24/2016.
 */
public class Obj_WiFiSettings_Dialog {

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
}
