package utils;

import api.android.Android;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class UiObject extends Android{

    public UiObject(String locator){
        this.uiLocator = locator;
    }

    private String uiLocator;

    private boolean xPath(){
        return uiLocator.contains("[@");
    }

    public boolean exists(){
        try{
            WebElement element;
            if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
            else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isCheckable(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("checkable").equals("true");
    }

    public boolean isChecked(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("checked").equals("true");
    }

    public boolean isClickable(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("clickable").equals("true");
    }

    public boolean isEnabled(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("enabled").equals("true");
    }

    public boolean isFocusable(){
        WebElement element;
        if(xPath())element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("focusable").equals("true");
    }

    public boolean isFocused(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("focused").equals("true");
    }

    public boolean isScrollable(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("scrollable").equals("true");
    }

    public boolean isLongClickable(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("long-clickable").equals("true");
    }

    public boolean isPassword(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("password").equals("true");
    }

    public boolean isSelected(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("selected").equals("true");
    }

    public String getIndex(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("index");
    }

    public String getBounds(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("bounds");
    }

    public String getText(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("name");
    }

    public String getResourceId(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("resource-id");
    }

    public String getClassName(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("class");
    }

    public String getPackageName(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("package");
    }

    public String getContentDesc(){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        return element.getAttribute("content-desc");
    }

    public UiObject clearText(){
        if(xPath()) DriverManager.getDriver().findElementByXPath(uiLocator).clear();
        else DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator).clear();
        return this;
    }

    public UiObject scrollToElement(){
        int tries = 0;
        while(!exists()){
            System.out.println("Tries: "+tries);
            if(tries>=7) throw new RuntimeException("Failed to scroll to the element, element not found!");
            if(tries<=4)scrollDown();
            else if(tries==5){
                System.out.println("Scrolling all the way up");
                scrollUp(5);
            }else scrollDown();
            tries++;
        }
        return this;
    }

    public UiObject scrollToText(){
        if(xPath()) throw new RuntimeException("Cannot scroll to an xPath! Java Client does not support this");
        else if(!uiLocator.contains("")) throw new RuntimeException("UiSelector: "+uiLocator+" does not have a text attribute! Try to use scrollToElement() instead.");
        else {
            String text;
            if(uiLocator.contains("textContains")) text = uiLocator.substring(uiLocator.indexOf(".textContains(\""), uiLocator.indexOf("\")")).replace(".textContains(\"","");
            else text = uiLocator.substring(uiLocator.indexOf(".text(\""), uiLocator.indexOf("\")")).replace(".text(\"","");
            DriverManager.getDriver().scrollToExact(text);
        }
        return this;
    }

    public UiObject setText(String value){
        WebElement element;
        if(xPath()) element = DriverManager.getDriver().findElementByXPath(uiLocator);
        else element = DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator);
        String existingText = element.getText();
        if(!existingText.equals(value)) clearText();
        else if(existingText != null && !existingText.isEmpty()) clearText();
        element.sendKeys(value);
        return this;
    }

    public UiObject tap(){
        if(xPath()) DriverManager.getDriver().findElementByXPath(uiLocator).click();
        else DriverManager.getDriver().findElementByAndroidUIAutomator(uiLocator).click();
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