package api.android.lollipop.base.settings.wifi;

import api.android.Android;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.UiObject;
import utils.UiSelector;


public class WiFiSettings extends Android {

    private static WiFiSettingsDialog dialog = new WiFiSettingsDialog();

    public final String
            activity = ".wifi.WifiSettings",
            pkg = "com.android.settings";

    public WiFiSettings(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.settings:id/switch_widget\")")
    public WebElement switchWidget;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/summary\")")
    public WebElement connected;

    public UiObject networkID(String ssid){
        return new UiSelector().text(ssid).resourceId("android:id/title").makeUiObject();
    }

    public WiFiSettings open(){
        adb.openAppsActivity(pkg, activity);
        return this;
    }

    public WiFiSettingsDialog tapNetworkID(String ssid){
        UiObject network = networkID(ssid);
        //networkID.click();
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
        if(isVisible(dialog.passwordField)){
            throw new RuntimeException("This API does not support authentication with Access Points. " +
            "It is a requirement that AP you are trying to connect to has been pre-authenticated by you.");
        }
        dialog.tapConnect();
       // connected.waitToAppear(25);
        return this;
    }
}
