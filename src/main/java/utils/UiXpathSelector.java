package utils;

public class UiXpathSelector {

    private String xPath;

    public UiXpathSelector(String xPath){
        this.xPath = xPath;
    }

    public UiObject makeUiObject(){
        return new UiObject(xPath);
    }
}