package api.android.lollipop.base.settings;

import api.android.Android;
import org.openqa.selenium.NoSuchElementException;
import utils.UiObject;
import utils.UiSelector;
import utils.UiXpathSelector;

/**
 * Created by Artur on 1/24/2016.
 */
public class HeaderBar extends Android {

    private static UiObject searchEditField = null, searchIcon = null, title = null;

    public UiObject title(){
        if(title == null) title = new UiXpathSelector("//*[@resource-id='android:id/action_bar_container']/following::*[1]/*[@class='android.widget.TextView']").makeUiObject();
        return title;
    }

    public UiObject searchEditField(){
        if(searchEditField == null) searchEditField = new UiSelector().resourceId("android:id/search_src_text").makeUiObject();
        return searchEditField;
    }

    public UiObject searchIcon(){
        if(searchIcon == null) searchIcon = new UiSelector().resourceId("android.settings:id/search").makeUiObject();
        return searchIcon;
    }

    public String getTitle(){
        try{
            return title().getText();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to get the Title of the open Setting's activity");
        }
    }

    public void enterSearchValue(String value){
        try{
            searchEditField.setText(value);
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to enter text into Search Field in the Settings Menu");
        }
    }

    public HeaderBar tapSearch(){
        try{
            searchIcon().tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("Failed to tap Search Icon in the Settings Menu");
        }
        return this;
    }


}
