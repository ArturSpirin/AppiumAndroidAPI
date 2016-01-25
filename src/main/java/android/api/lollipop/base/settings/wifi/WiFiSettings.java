package android.api.lollipop.base.settings.wifi;

import android.Android;
import org.openqa.selenium.NoSuchElementException;
import utils.UiObject;
import utils.UiSelector;


public class WiFiSettings extends Android {

    private static WiFiSettings_Dialog dialog = new WiFiSettings_Dialog();

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

    public final String
            activity = ".wifi.WifiSettings",
            pkg = "com.android.settings";

    public WiFiSettings open(){
        adb.openAppsActivity(pkg, activity);
        return this;
    }

    public WiFiSettings_Dialog tapNetworkID(String ssid){
        UiObject network = networkID(ssid);
        try{
            if(!network.exists()) driver.scrollTo(ssid);
            network.tap();
        }catch (NoSuchElementException e){
            throw new AssertionError(ssid+", ssid does not exist");
        }
        return dialog;
    }

    public WiFiSettings changeNetwork(String ssid){
        tapNetworkID(ssid);
        if(dialog.passwordField().exists()){
            throw new RuntimeException("This API does not support authentication with Access Points. " +
            "It is a requirement that AP you are trying to connect to has been pre-authenticated by you.");
        }
        dialog.tapConnect();
        connected.waitToAppear(25);
        return this;
    }
}
