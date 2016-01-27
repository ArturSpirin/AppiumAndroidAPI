package api.android.lollipop.base.settings.wifi;

import api.android.Android;
import org.openqa.selenium.NoSuchElementException;
import utils.UiObject;
import utils.UiSelector;


public class WiFiSettings extends Android {

    private static WiFiSettingsDialog dialog = new WiFiSettingsDialog();

    public final String
            activity = ".wifi.WifiSettings",
            pkg = "com.android.settings";

    public static UiObject
            status = null,
            statusConnected = null,
            switchWidget = null;

    public UiObject statusConnected(){
        if(statusConnected == null) statusConnected = new UiSelector().resourceId("android:id/summary").text("Connected").makeUiObject();
        return statusConnected;
    }

    public UiObject status(){
        if(status == null) status = new UiSelector().resourceId("android:id/summary").makeUiObject();
        return status;
    }

    public UiObject switchWidget(){
        if(switchWidget == null) switchWidget = new UiSelector().resourceId("com.android.settings:id/switch_widget").makeUiObject();
        return switchWidget;
    }

    public UiObject networkID(String ssid){
        return new UiSelector().text(ssid).resourceId("android:id/title").makeUiObject();
    }

    public WiFiSettings open(){
        adb.openAppsActivity(pkg, activity);
        return this;
    }

    public WiFiSettingsDialog tapNetworkID(String ssid){
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
        statusConnected().waitToAppear(25);
        return this;
    }
}
