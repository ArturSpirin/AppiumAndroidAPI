package adb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Artur Spirin on 1/20/16.
 **/
public class ADB {

    public static String runCommand(String command) {
        try{
            Scanner s = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");
            return s.next();
        }catch (IOException e){
            throw new RuntimeException("Failed to run command: "+command+"! Caught exception: "+e.getMessage());
        }
    }

    public static String[] getConnectedDevices(){
        return new String[0];
    }

    public static String getAppVersionAsString(String appPackage, String deviceID) {
        String output = runCommand("adb -s "+deviceID+" shell dumpsys package "+appPackage+" | grep -i versioncode");
        if(output.contains("versionCode=")) output = output.replace("versionCode=", "");
        return output;
    }

    public static int getAppVersionAsInt(String appPackage, String deviceID){
        return Integer.parseInt(getAppVersionAsString(appPackage, deviceID).replaceAll("\\.","").trim());
    }

    public static String getAppName(String appPackage, String deviceID) {
        String output = runCommand("adb -s "+deviceID+" shell dumpsys package "+appPackage+" | grep -i versionname");
        if(output.contains("versionName=")) output = output.replace("versionName=", "");
        return output;
    }

    public static String getForegroundActivity(String deviceID) {
        return runCommand("adb -s "+deviceID+" shell dumpsys window windows | grep mCurrentFocus");
    }

    public static String getAndroidVersionAsString(String deviceID){
        return runCommand("adb -s "+deviceID+" shell getprop ro.build.version.release");
    }

    public static int getAndroidVersionAsInt(String deviceID){
        return Integer.parseInt(getAndroidVersionAsString(deviceID).replaceAll("\\.","").trim());
    }

    public static HashMap getInstalledPackages(String deviceID){
        return new HashMap();
    }

    public static void openAppsActivity(String packageID, String activityID, String deviceID){
        runCommand("adb -s "+deviceID+" shell am start -c android.intent.category.LAUNCHER -a android.intent.action.MAIN -n " +packageID+"/"+activityID);
    }

    public static void clearAppsData(String packageID){
        runCommand("adb shell pm clear "+packageID);
    }

    public static void forceStopApp(String packageID, String deviceID){
        runCommand("adb -s "+deviceID+" shell am force-stop " + packageID);
    }

    public static void installApp(String apk, String deviceID){
        runCommand("adb -s "+deviceID+" install "+apk);
    }

    public static void uninstallApp(String packageID, String deviceID){
        runCommand("adb -s "+deviceID+" uninstall "+packageID);
    }

    public static void clearLogBuffer(String deviceID) {
        runCommand("adb -s "+deviceID+" logcat -c");
    }



    public static String getDevicesModel(String deviceID){
        return runCommand("adb -s "+deviceID+" shell getprop ro.product.model");
    }

    public static String getDevicesModelID(String deviceID){
        return "modelID";
    }

    public static String getDevicesSerialNumber(String deviceID){
        return runCommand("adb -s "+deviceID+" shell getprop ro.serialno");
    }

    public static String getDevicesLanguageSettings(String deviceID){
        return "language settings";
    }

    public static String getDevicesManufacturer(String deviceID){
        return runCommand("adb -s "+deviceID+" shell getprop ro.product.manufacturer");
    }

    public static String getDevicesCarrier(String deviceID) {
        return runCommand("adb -s "+deviceID+" shell getprop gsm.operator.alpha");
    }

    public static boolean rebootDevice(String deviceID, int secondsToWaitForBootup){
        return true; //Once device booted up
    }

    public static void rebootDevice(String deviceID) {
        runCommand("adb -s "+deviceID+" reboot");
    }

    public static String getAnrFileLocation(String deviceID) {
        return runCommand("adb -s "+deviceID+" shell getprop dalvik.vm.stack-trace-file");
    }

    public static int getDevicesWiFiMode(String deviceID) {
        return Integer.parseInt(runCommand("adb -s "+deviceID+" shell settings get global wifi_on"));
    }

    public static int getDevicesAirPlaneMode(String deviceID){
        return 1;
    }

    public static int getDevicesCellMode(String deviceID){
        return 1;
    }

    public static String getDevicesNetworkInterfaceStatus(String deviceID, String interfaceId){
        return "UP";
    }

}
