package api.android.universal;

import api.android.Android;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.UiObject;
import utils.UiSelector;

/**
 * Created by Artur on 1/24/2016.
 */
public class Objects {

    public Objects(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
    public WebElement button1;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button2\")")
    public WebElement button2;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button3\")")
    public WebElement button3;
}
