package api.android.lollipop.base.notifications;

import utils.UiObject;
import utils.UiSelector;

/**
 * Created by Artur on 1/24/2016.
 */
public class Notifications {

    private static UiObject
            time,
            date,
            wifiSignalIcon,
            mobileSignalIcon,
            batteryIcon,
            userAvatarIcon,
            notificationItem,
            dismissIcon;

    public UiObject time(){
        if(time == null) time = new UiSelector().resourceId("com.android.systemui:id/time_view").makeUiObject();
        return time;
    }

    public UiObject date(){
        if(date == null) date = new UiSelector().resourceId("com.android.systemui:id/date_expanded").makeUiObject();
        return date;
    }

    public UiObject wifiSignalIcon(){
        if(wifiSignalIcon == null) wifiSignalIcon = new UiSelector().resourceId("com.android.systemui:id/wifi_signal").makeUiObject();
        return wifiSignalIcon;
    }

    public UiObject mobileSignalIcon(){
        if(mobileSignalIcon == null) mobileSignalIcon = new UiSelector().resourceId("com.android.systemui:id/mobile_signal").makeUiObject();
        return mobileSignalIcon;
    }

    public UiObject batteryIcon(){
        if(batteryIcon == null) batteryIcon = new UiSelector().resourceId("com.android.systemui:id/battery").makeUiObject();
        return batteryIcon;
    }

    public UiObject userAvatarIcon(){
        if(userAvatarIcon == null) userAvatarIcon = new UiSelector().resourceId("com.android.systemui:id/multi_user_avatar").makeUiObject();
        return userAvatarIcon;
    }

    public UiObject notificationItem(String value){
        if(notificationItem == null) notificationItem = new UiSelector().resourceId("android:id/title").textContains(value).makeUiObject();
        return notificationItem;
    }

    public UiObject dismissIcon(){
        if(dismissIcon == null) dismissIcon = new UiSelector().resourceId("com.android.systemui:id/dismiss_text").makeUiObject();
        return dismissIcon;
    }
}
