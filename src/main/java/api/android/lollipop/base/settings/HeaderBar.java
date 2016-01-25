package api.android.lollipop.base.settings;

import utils.UiObject;
import utils.UiSelector;
import api.android.Android;

/**
 * Created by Artur on 1/24/2016.
 */
public class HeaderBar extends Android {

    private UiObject
            search,
            searchField;

    public UiObject search(){
        if(search == null) search = new UiSelector().resourceId("android.settings:id/search").makeUiObject();
        return search;
    }

    public UiObject searchField(){
        if(searchField == null) searchField = new UiSelector().resourceId("android:id/search_src_text").makeUiObject();
        return searchField;
    }
}
