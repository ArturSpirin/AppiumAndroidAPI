package utils;

import android.Android;

/**
 * Created by Artur on 1/21/2016.
 */
public class UiSelector {

    private String locator = "new UiSelector()", text;

    public UiSelector resourceId(String value){
        locator = locator+".resourceId(\""+value+"\")";
        return this;
    }

    public UiSelector className(String value){
        locator = locator+".className(\""+value+"\")";
        return this;
    }

    public UiSelector classNameMatches(String regex){
        locator = locator+".classNameMatches(\""+regex+"\")";
        return this;
    }

    public UiSelector text(String value){
        locator = locator+".text(\""+value+"\")";
        return this;
    }

    public UiSelector index(int value){
        locator = locator+".index("+value+")";
        return this;
    }

    public UiSelector clickable(boolean value){
        locator = locator+".resourceId("+value+")";
        return this;
    }

    public UiSelector checked(boolean value){
        locator = locator+".checked("+value+")";
        return this;
    }

    public UiSelector enabled(String value){
        locator = locator+".enabled("+value+")";
        return this;
    }

    public UiSelector description(String value){
        locator = locator+".description(\""+value+"\")";
        return this;
    }

    public UiSelector descriptionContains(String value){
        locator = locator+".descriptionContains(\""+value+"\")";
        return this;
    }

    public UiSelector descriptionMatches(String regex){
        locator = locator+".descriptionMatches(\""+regex+"\")";
        return this;
    }

    //TODO Add method by xPath
}