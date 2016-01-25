package utils;


import org.openqa.selenium.WebElement;

public class UiObject {

    private WebElement uiLocator;

    public UiObject(WebElement locator){
        this.uiLocator = locator;
    }

    public boolean exists(){
        return uiLocator.isDisplayed();
    }

    public boolean isCheckable(){
        return uiLocator.getAttribute("checkable").equals("true");
    }

    public boolean isChecked(){
        return uiLocator.getAttribute("checked").equals("true");
    }

    public boolean isClickable(){
        return uiLocator.getAttribute("clickable").equals("true");
    }

    public boolean isEnabled(){
        return uiLocator.getAttribute("enabled").equals("true");
    }

    public boolean isFocusable(){
        return uiLocator.getAttribute("focusable").equals("true");
    }

    public boolean isFocused(){
        return uiLocator.getAttribute("focused").equals("true");
    }

    public boolean isScrollable(){
        return uiLocator.getAttribute("scrollable").equals("true");
    }

    public boolean isLongClickable(){
        return uiLocator.getAttribute("long-clickable").equals("true");
    }

    public boolean isPassword(){
        return uiLocator.getAttribute("password").equals("true");
    }

    public boolean isSelected(){
        return uiLocator.getAttribute("selected").equals("true");
    }

    public String getIndex(){
        return uiLocator.getAttribute("index");
    }

    public String getBounds(){
        return uiLocator.getAttribute("bounds");
    }

    public String getText(){
        return uiLocator.getAttribute("name");
    }

    public String getResourceId(){
        return uiLocator.getAttribute("resource-id");
    }

    public String getClassName(){
        return uiLocator.getAttribute("class");
    }

    public String getPackageName(){
        return uiLocator.getAttribute("package");
    }

    public String getContentDesc(){
        return uiLocator.getAttribute("content-desc");
    }

    public UiObject clearText(){
        uiLocator.clear();
        return this;
    }

    public UiObject setText(String value){
        String existingText = uiLocator.getText();
        if(!existingText.equals(value)) clearText();
        else if(existingText != null && !existingText.isEmpty()) clearText();
        uiLocator.sendKeys(value);
        return this;
    }

    public UiObject tap(){
        uiLocator.click();
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