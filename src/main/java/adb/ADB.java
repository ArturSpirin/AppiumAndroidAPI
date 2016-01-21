package adb;

import java.util.HashMap;

/**
 * Created by Artur Spirin on 1/20/16.
 **/
public class ADB {

    public static String runCommand(String command){
        return "Run Command: "+command;
    }

    public static String[] getConnectedDevices(){
        return new String[0];
    }

    public static String getAppVersionAsString(String appPackage){
        return "4.2.1";
    }

    public static int getAppVersionAsInt(String appPackage){
        return 421;
    }

    public static String getAppName(String appPackage){
        return "appName";
    }

    public static int getForegroundActivity(String deviceID){
        return 1;
    }

    public static String getAndroidVersionAsString(String deviceID){
        return "5.1.1";
    }

    public static int getAndroidVersionAsInt(String deviceID){
        return 511;
    }

    public static HashMap getInstalledPackages(String deviceID){
        return new HashMap();
    }

    public static void openAppsActivity(String packageID, String activityID){

    }

    public static void clearAppsData(String packageID){

    }

    public static void forceStopApp(String packageID){

    }

    public static void installApp(String packageID){

    }

    public static void uninstallApp(String packageID){

    }

    public static void clearLogBuffer(String packageID){

    }



    public static String getDevicesModel(String deviceID){
        return "model";
    }

    public static String getDevicesModelID(String deviceID){
        return "modelID";
    }

    public static String getDevicesSerialNumber(String deviceID){
        return "deviceSerial";
    }

    public static String getDevicesLanguageSettings(String deviceID){
        return "language settings";
    }

    public static String getDevicesManufacturer(String deviceID){
        return "manufacturer";
    }

    public static String getDevicesCarrier(){
        return "carrier";
    }

    public static boolean rebootDevice(String deviceID, int secondsToWaitForBootup){
        return true; //Once device booted up
    }

    public static void rebootDevice(String deviceID){

    }

    public static String getAnrFileLocation(String deviceID){
        return "/etc/data/anr";
    }

    public static int getDevicesWiFiMode(String deviceID){
        return 1;
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
