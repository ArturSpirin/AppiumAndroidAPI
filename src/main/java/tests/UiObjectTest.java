package tests;

import api.android.Android;
import io.appium.java_client.android.AndroidDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.UiObject;
import utils.UiSelector;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by Artur on 2/9/2016.
 */
public class UiObjectTest {

    @BeforeClass
    public static void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","ZX1G22BV8Z");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "C:\\Users\\Artur\\Desktop\\Appium\\node_modules\\appium\\build\\unlock_apk\\unlock_apk-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        Android android = new Android(driver);
        android.pressHome();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testResourceId() throws Exception {
        UiObject element = new UiSelector().resourceId("com.google.android.googlequicksearchbox:id/folder_icon_name").makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testClassName() throws Exception {
        UiObject element = new UiSelector().className("android.widget.TextView").makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testClassNameMatches() throws Exception {

    }

    @Test
    public void testText() throws Exception {
        UiObject element = new UiSelector().text("Google").makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testTextContains() throws Exception {
        UiObject element = new UiSelector().textContains("Google").makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testIndex() throws Exception {
        UiObject element = new UiSelector().index(1).makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testClickable() throws Exception {
        UiObject element = new UiSelector().clickable(true).makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testChecked() throws Exception {
        UiObject element = new UiSelector().checked(false).makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testEnabled() throws Exception {
        UiObject element = new UiSelector().enabled(true).makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testDescription() throws Exception {
        UiObject element = new UiSelector().description("Apps").makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testDescriptionContains() throws Exception {
        UiObject element = new UiSelector().description("Apps").makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }

    @Test
    public void testDescriptionMatches() throws Exception {

    }

    @Test
    public void testXPath() throws Exception {
        UiObject element = new UiSelector().xPath("//*[@content-desc=\"Folder: Google\"]/*[2]").makeUiObject();
        System.out.println("Exists: "+element.exists());
        System.out.println("Text: "+element.getText());
        System.out.println("Resource ID: "+element.getResourceId());
        System.out.println("Class: "+element.getClassName());
        System.out.println("Checkable: "+element.isCheckable());
        System.out.println("Checked: "+element.isChecked());
        System.out.println("Clickable: "+element.isClickable());
        System.out.println("Enabled: "+element.isEnabled());
        System.out.println("Focused: "+element.isFocused());
        System.out.println("Focusable: "+element.isFocusable());
        System.out.println("Scrollable: "+element.isScrollable());
        System.out.println("Long-Clickable: "+element.isLongClickable());
        System.out.println("Selected: "+element.isSelected());
        System.out.println("Bounds: "+element.getBounds());
    }
}