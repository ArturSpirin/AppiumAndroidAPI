package api.android;

import org.junit.Test;
import utils.Debug;

/**
 * Created by Artur Spirin on 1/29/16.
 **/
public class AndroidTest extends Debug {

    @Test
    public void testScrollDown() {
        android.settings.open();
        android.scrollDown();
    }

    @Test
    public void testScrollUp() {
        android.settings.open();
        android.scrollUp();
    }

    @Test
    public void testScrollUpX() {
        android.settings.open();
        android.scrollUp(5);
    }

    @Test
    public void testScrollDownX() {
        android.settings.open();
        android.scrollDown(5);
    }

    @Test
    public void testSwipeLeftRegions() throws Exception {
        android.pressHome();
        int interval = 20;
        while(interval!=0){
            android.swipeLeft(interval);
            interval--;
        }
    }

    @Test
    public void testSwipeRightRegions() throws Exception {
        android.pressHome();
        int interval = 20;
        while(interval!=0){
            android.swipeRight(interval);
            interval--;
        }
    }

    @Test
    public void testPressBack() throws Exception {
        android.pressBack();
    }

    @Test
    public void testPressHome() throws Exception {
        android.pressHome();
    }
}