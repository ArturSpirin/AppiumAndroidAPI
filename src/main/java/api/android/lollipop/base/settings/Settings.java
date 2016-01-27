package api.android.lollipop.base.settings;

import org.openqa.selenium.NoSuchElementException;
import utils.UiObject;
import utils.UiSelector;

/**
 * Created by Artur on 1/24/2016.
 */
public class Settings {

    public static HeaderBar headerBar = new HeaderBar();

    public final String
            activity = ".wifi.WifiSettings",
            pkg = "com.android.settings";

    public static UiObject

               wifi = null,
               bluetooth = null,
               dataUsage = null,
               more = null,
               display = null,
               sound_and_notification = null,
               storage = null,
               battery = null,
               apps = null,
               users = null,
               tap_and_pay = null,
               location = null,
               security = null,
               accounts = null,
               language_and_input = null,
               backup_and_reset = null,
               date_and_time = null,
               accessibility = null,
               printing = null,
               developerOptions = null,
               aboutPhone = null;

    public UiObject wifi(){
        if(wifi == null) wifi = new UiSelector().text("Wi‑Fi").makeUiObject();
        return wifi;
    }

    public UiObject bluetooth(){
        if(bluetooth == null) bluetooth = new UiSelector().text("Bluetooth").makeUiObject();
        return bluetooth;
    }

    public UiObject dataUsage(){
        if(dataUsage == null) dataUsage = new UiSelector().text("Data usage").makeUiObject();
        return dataUsage;
    }

    public UiObject more(){
        if(more == null) more = new UiSelector().text("More").makeUiObject();
        return more;
    }

    public UiObject display(){
        if(display == null) display = new UiSelector().text("Display").makeUiObject();
        return display;
    }

    public UiObject sound_and_notification(){
        if(sound_and_notification == null) sound_and_notification = new UiSelector().text("Sound & notification").makeUiObject();
        return sound_and_notification;
    }

    public UiObject storage(){
        if(storage == null) storage = new UiSelector().text("Storage").makeUiObject();
        return storage;
    }

    public UiObject battery(){
        if(battery == null) battery = new UiSelector().text("Battery").makeUiObject();
        return battery;
    }

    public UiObject apps(){
        if(apps == null) apps = new UiSelector().text("Apps").makeUiObject();
        return apps;
    }

    public UiObject users(){
        if(users == null) users = new UiSelector().text("Users").makeUiObject();
        return users;
    }

    public UiObject tap_and_pay(){
        if(tap_and_pay == null) tap_and_pay = new UiSelector().text("Tap & pay").makeUiObject();
        return tap_and_pay;
    }

    public UiObject location(){
        if(location == null) location = new UiSelector().text("Location").makeUiObject();
        return location;
    }

    public UiObject security(){
        if(security == null) security = new UiSelector().text("Security").makeUiObject();
        return security;
    }

    public UiObject accounts(){
        if(accounts == null) accounts = new UiSelector().text("Accounts").makeUiObject();
        return accounts;
    }

    public UiObject language_and_input(){
        if(language_and_input == null) language_and_input = new UiSelector().text("Language & input").makeUiObject();
        return language_and_input;
    }

    public UiObject backup_and_reset(){
        if(backup_and_reset == null) backup_and_reset = new UiSelector().text("Backup & reset").makeUiObject();
        return backup_and_reset;
    }

    public UiObject date_and_time(){
        if(date_and_time == null) date_and_time = new UiSelector().text("Date & time").makeUiObject();
        return date_and_time;
    }

    public UiObject accessibility(){
        if(accessibility == null) accessibility = new UiSelector().text("Accessibility").makeUiObject();
        return accessibility;
    }

    public UiObject printing(){
        if(printing == null) printing = new UiSelector().text("Printing").makeUiObject();
        return printing;
    }

    public UiObject developerOptions(){
        if(developerOptions == null) developerOptions = new UiSelector().text("Developer options").makeUiObject();
        return developerOptions;
    }

    public UiObject aboutPhone() {
        if (aboutPhone == null) aboutPhone = new UiSelector().text("About phone").makeUiObject();
        return aboutPhone;
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapWifi(){
        try{
            if(!wifi().exists()) wifi().scrollTo();
            wifi().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Wifi option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapBluetooth(){
        try{
            if(!bluetooth().exists()) bluetooth().scrollTo();
            bluetooth().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Bluetooth option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapDataUsage(){
        try{
            if(!dataUsage().exists()) dataUsage().scrollTo();
            dataUsage().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap DataUsage option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapMore(){
        try{
            if(!more().exists()) more().scrollTo();
            more().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap More option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapDisplay(){
        try{
            if(!display().exists()) display().scrollTo();
            display().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Display option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapSound_and_notification(){
        try{
            if(!sound_and_notification().exists()) sound_and_notification().scrollTo();
            sound_and_notification().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap sound_and_notification option in Sound_and_notification Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapStorage(){
        try{
            if(!storage().exists()) storage().scrollTo();
            storage().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Storage option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapBattery(){
        try{
            if(!battery().exists()) battery().scrollTo();
            battery().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Battery option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapApps(){
        try{
            if(!apps().exists()) apps().scrollTo();
            apps().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Apps option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapUsers(){
        try{
            if(!users().exists()) users().scrollTo();
            users().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Users option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapTap_and_pay(){
        try{
            if(!tap_and_pay().exists()) tap_and_pay().scrollTo();
            tap_and_pay().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Tap_and_pay option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapLocation(){
        try{
            if(!location().exists()) location().scrollTo();
            location().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Location option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapSecurity(){
        try{
            if(!security().exists()) security().scrollTo();
            security().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Security option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapAccounts(){
        try{
            if(!accounts().exists()) accounts().scrollTo();
            accounts().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Accounts option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapLanguage_and_input(){
        try{
            if(!language_and_input().exists()) language_and_input().scrollTo();
            language_and_input().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Language_and_input option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapBackup_and_reset(){
        try{
            if(!backup_and_reset().exists()) backup_and_reset().scrollTo();
            backup_and_reset().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Backup_and_reset option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapDate_and_time(){
        try{
            if(!date_and_time().exists()) date_and_time().scrollTo();
            date_and_time().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Date_and_time option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapAccessibility(){
        try{
            if(!accessibility().exists()) accessibility().scrollTo();
            accessibility().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Accessibility option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapPrinting(){
        try{
            if(!printing().exists()) printing().scrollTo();
            printing().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Printing option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapDeveloperOptions(){
        try{
            if(!developerOptions().exists()) developerOptions().scrollTo();
            developerOptions().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap DeveloperOptions option in the Settings Menu");
        }
    }

    //TODO Add return type for the proper activity when that activity is ready to be supported
    public void tapAboutPhone(){
        try{
            if(!aboutPhone().exists()) aboutPhone().scrollTo();
            aboutPhone().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap AboutPhone option in the Settings Menu");
        }
    }
}