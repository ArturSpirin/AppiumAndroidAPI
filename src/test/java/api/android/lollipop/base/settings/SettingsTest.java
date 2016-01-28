package api.android.lollipop.base.settings;

import api.android.Android;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.DriverManager;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Artur on 1/27/2016.
 */
public class SettingsTest {

    private static Settings settings;

    @BeforeClass
    public static void preSet() throws MalformedURLException {
        System.out.println("BeforeClass");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "ZX1G22BV8Z");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("app", "./build/unlock_apk/unlock_apk-debug.apk");
        new DriverManager(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities).getAndroidDevice();
        settings = new Settings();
    }

    @AfterClass
    public static void finisher(){
        DriverManager.getDriver().quit();
    }

    @Before
    public void setUp() throws Exception {
        settings.open();
    }

    @After
    public void tearDown() throws Exception {
        settings.pressHome();
    }

    @Test
    public void testScrollDown() throws InterruptedException {
        new Android().scrollDown();
    }

    @Test
    public void testScrollUp() throws InterruptedException {
        new Android().scrollUp();
    }

    @Test
    public void testScrollUpX() throws InterruptedException {
        new Android().scrollUp(5);
    }

    @Test
    public void testScrollDownX() throws InterruptedException {
        new Android().scrollDown(5);
    }

    @Test
    public void testWifi() throws Exception {
        settings.tapWifi();
    }

    @Test
    public void testBluetooth() throws Exception {
        settings.tapBluetooth();
    }

    @Test
    public void testDataUsage() throws Exception {
        settings.tapDataUsage();
    }

    @Test
    public void testMore() throws Exception {
        settings.tapMore();
    }

    @Test
    public void testDisplay() throws Exception {
        settings.tapDisplay();
    }

    @Test
    public void testSound_and_notification() throws Exception {
        settings.tapSound_and_notification();
    }

    @Test
    public void testStorage() throws Exception {
        settings.tapStorage();
    }

    @Test
    public void testBattery() throws Exception {
        settings.tapBattery();
    }

    @Test
    public void testApps() throws Exception {
        settings.tapApps();
    }

    @Test
    public void testUsers() throws Exception {
        settings.tapUsers();
    }

    @Test
    public void testTap_and_pay() throws Exception {
        settings.tapTap_and_pay();
    }

    @Test
    public void testLocation() throws Exception {
        settings.tapLocation();
    }

    @Test
    public void testSecurity() throws Exception {
        settings.tapSecurity();
    }

    @Test
    public void testAccounts() throws Exception {
        settings.tapAccounts();
    }

    @Test
    public void testLanguage_and_input() throws Exception {
        settings.tapLanguage_and_input();
    }

    @Test
    public void testBackup_and_reset() throws Exception {
        settings.tapBackup_and_reset();
    }

    @Test
    public void testDate_and_time() throws Exception {
        settings.tapDate_and_time();
    }

    @Test
    public void testAccessibility() throws Exception {
        settings.tapAccessibility();
    }

    @Test
    public void testPrinting() throws Exception {
        settings.tapPrinting();
    }

    @Test
    public void testDeveloperOptions() throws Exception {
        settings.tapDeveloperOptions();
    }

    @Test
    public void testAboutPhone() throws Exception {
        settings.tapAboutPhone();
    }
}