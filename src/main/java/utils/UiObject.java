package utils;

import api.android.Android;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

/**
 * Created by Artur on 2/9/2016.
 */
public class UiObject {

    private String uiLocator;

    public UiObject(String locator){
        System.out.println("Got UI Selector: "+locator);
        this.uiLocator = locator;
        if(Android.driver == null) throw new RuntimeException("Android instance is null. In order to use UiObject class, you have to create Android first!");
    }

    private boolean xPath(){
        boolean value = !uiLocator.contains("UiSelector");
        System.out.println("Element is xPath: "+value);
        return value;
    }

    public boolean exists(){
        try{
            WebElement element;
            if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
            else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isCheckable(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("checkable").equals("true");
    }

    public boolean isChecked(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("checked").equals("true");
    }

    public boolean isClickable(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("clickable").equals("true");
    }

    public boolean isEnabled(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("enabled").equals("true");
    }

    public boolean isFocusable(){
        WebElement element;
        if(xPath())element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("focusable").equals("true");
    }

    public boolean isFocused(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("focused").equals("true");
    }

    public boolean isScrollable(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("scrollable").equals("true");
    }

    public boolean isLongClickable(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("longClickable").equals("true");
    }

    public boolean isSelected(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("selected").equals("true");
    }

    public Point getBounds(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getLocation();//getAttribute("bounds");
    }

    public String getText(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("name");
    }

    public String getResourceId(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("resourceId");
    }

    public String getClassName(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("className");
    }

    public String getContentDesc(){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("contentDesc");
    }

    public UiObject clearText(){
        if(xPath()) Android.driver.findElementByXPath(uiLocator).clear();
        else Android.driver.findElementByAndroidUIAutomator(uiLocator).clear();
        return this;
    }

    /*
    public UiObject scrollToElement(){
        int tries = 0;
        while(!exists()){
            System.out.println("Tries: "+tries);
            if(tries>=7) throw new RuntimeException("Failed to scroll to the element, element not found!");
            if(tries<=4) android.scrollDown();
            else if(tries==5){
                System.out.println("Scrolling all the way up");
                android.scrollUp(5);
            }else android.scrollDown();
            tries++;
        }
        return this;
    }
    */

    public UiObject scrollToText(){
        if(xPath()) throw new RuntimeException("Cannot scroll to an xPath! Java Client does not support this");
        else if(!uiLocator.contains("")) throw new RuntimeException("UiSelector: "+uiLocator+" does not have a text attribute! Try to use scrollToElement() instead.");
        else {
            String text;
            if(uiLocator.contains("textContains")) text = uiLocator.substring(uiLocator.indexOf(".textContains(\""), uiLocator.indexOf("\")")).replace(".textContains(\"","");
            else text = uiLocator.substring(uiLocator.indexOf(".text(\""), uiLocator.indexOf("\")")).replace(".text(\"","");
            Android.driver.scrollToExact(text);
        }
        return this;
    }

    public UiObject setText(String value){
        WebElement element;
        if(xPath()) element = Android.driver.findElementByXPath(uiLocator);
        else element = Android.driver.findElementByAndroidUIAutomator(uiLocator);
        String existingText = element.getText();
        if(!existingText.equals(value)) clearText();
        else if(existingText != null && !existingText.isEmpty()) clearText();
        element.sendKeys(value);
        return this;
    }

    public UiObject tap(){
        if(xPath()) Android.driver.findElementByXPath(uiLocator).click();
        else Android.driver.findElementByAndroidUIAutomator(uiLocator).click();
        return this;
    }

    public UiObject waitToAppear(int sec){
        while(sec != 0){
            sec--;
            if(exists()) break;
            else if(sec == 0) throw new AssertionError("Element failed to appear");
        }
        return this;
    }

    public void waitToDisappear(int sec){
        while(sec != 0){
            sec--;
            if(!exists()) break;
            else if(sec == 0) throw new AssertionError("Element failed to disappear");
        }
    }
}
