package api.android.lollipop.base.settings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Debug;

/**
 * Created by Artur on 1/27/2016.
 */
public class SettingsTest extends Debug{

    @Before
    public void setUp() {
        android.settings.open();
    }

    @After
    public void tearDown() {
        android.pressHome();
    }

    @Test
    public void testWifi() {
        android.settings.tapWifi();
    }

    @Test
    public void testBluetooth() {
        android.settings.tapBluetooth();
    }

    @Test
    public void testDataUsage() {
        android.settings.tapDataUsage();
    }

    @Test
    public void testMore() {
        android.settings.tapMore();
    }

    @Test
    public void testDisplay() {
        android.settings.tapDisplay();
    }

    @Test
    public void testSound_and_notification() {
        android.settings.tapSound_and_notification();
    }

    @Test
    public void testStorage() {
        android.settings.tapStorage();
    }

    @Test
    public void testBattery() {
        android.settings.tapBattery();
    }

    @Test
    public void testApps() {
        android.settings.tapApps();
    }

    @Test
    public void testUsers() {
        android.settings.tapUsers();
    }

    @Test
    public void testTap_and_pay() {
        android.settings.tapTap_and_pay();
    }

    @Test
    public void testLocation() {
        android.settings.tapLocation();
    }

    @Test
    public void testSecurity() {
        android.settings.tapSecurity();
    }

    @Test
    public void testAccounts() {
        android.settings.tapAccounts();
    }

    @Test
    public void testLanguage_and_input() {
        android.settings.tapLanguage_and_input();
    }

    @Test
    public void testBackup_and_reset() {
        android.settings.tapBackup_and_reset();
    }

    @Test
    public void testDate_and_time() {
        android.settings.tapDate_and_time();
    }

    @Test
    public void testAccessibility() {
        android.settings.tapAccessibility();
    }

    @Test
    public void testPrinting() {
        android.settings.tapPrinting();
    }

    @Test
    public void testDeveloperOptions() {
        android.settings.tapDeveloperOptions();
    }

    @Test
    public void testAboutPhone() {
        android.settings.tapAboutPhone();
    }
}