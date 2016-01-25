package android.objects.lollipop.base.settings.wifi;

import utils.UiObject;
import utils.UiSelector;

/**
 * Created by Artur on 1/21/2016.
 */
public class Obj_WiFiSettings {

    private UiObject
            switchWidget,
            search,
            networkID,
            connected;

    public UiObject switchWidget(){
        if(switchWidget == null) switchWidget = new UiSelector().resourceId("").makeUiObject();
        return switchWidget;
    }

    public UiObject search(){
        if(search == null) search = new UiSelector().resourceId("com.android.settings:id/search").makeUiObject();
        return search;
    }

    public UiObject networkID(String ssid){
        networkID = new UiSelector().text(ssid).resourceId("android:id/title").makeUiObject();
        return networkID;
    }

    public UiObject connected(){
        if(connected == null) connected = new UiSelector().resourceId("android:id/summary").text("Connected").makeUiObject();
        return connected;
    }
}