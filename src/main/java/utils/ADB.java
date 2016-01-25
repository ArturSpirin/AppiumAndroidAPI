package utils;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Artur Spirin on 1/20/16.
 * ADB Class provides out of the box common ADB methods that can be used to get certain information
 * about the device or its state. ADB Class offers it's methods in static and non-static context.
 * Android class has an Aggregation relationship with ADB
 **/
public class ADB {

    public String deviceID;

    public ADB(String deviceID){
        this.deviceID = deviceID;
    }

    public static String runCommand(String command) {
        if(command.startsWith("adb")) command = command.replace("adb", "");
        return CommonUtils.runtimeCommand(CommonUtils.getAndroidHome()+"/platform-tools/adb "+command);
    }

    public static void killServer(){
        runCommand("kill-server");
    }

    public static void startServer(){
        runCommand("start-server");
    }

    public static LinkedList getConnectedDevices(){
        LinkedList devices = new LinkedList();
        String raw = runCommand("devices");
        for(String line : raw.split("\n")){
            if(line.endsWith("device")) {
                devices.add(line.replace("device","").trim());
            }
        }
        return devices;
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

    public static LinkedList getInstalledPackages(String deviceID){
        LinkedList packages = new LinkedList();
        String[] raw = runCommand("adb -s "+deviceID+" shell pm list packages").split("\n");
        for(String packageID : raw) packages.add(packageID.replace("package:","").trim());
        return packages;
    }

    public static void openAppsActivity(String packageID, String activityID, String deviceID){
        runCommand("adb -s "+deviceID+" shell am start -c api.android.intent.category.LAUNCHER -a api.android.intent.action.MAIN -n " +packageID+"/"+activityID);
    }

    public static void clearAppsData(String packageID, String deviceID){
        runCommand("adb -s "+deviceID+" shell pm clear "+packageID);
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

    public static void pushFile(String source, String target, String deviceID){
        runCommand("-s "+deviceID+" push "+source+" "+target);
    }

    public static void pullFile(String source, String target, String deviceID){
        runCommand("-s "+deviceID+" pull "+source+" "+target);
    }

    public static void deleteFile(String target, String deviceID){
        runCommand("-s "+deviceID+" shell rm "+target);
    }

    public static void moveFile(String source, String target, String deviceID){
        runCommand("-s "+deviceID+" shell mv "+source+" "+target);
    }

    public static void takeScreenshot(String target, String deviceID){
        runCommand("-s "+deviceID+" shell screencap "+target);
    }

    public static LinkedList getDirectoryContent(String target, String deviceID){
        LinkedList items = new LinkedList();
        String[] raw = runCommand("-s "+deviceID+" shell ls -a "+target).split("\n");
        Collections.addAll(items, raw);
        return items;
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

    public String getAppVersionAsString(String appPackage) {
        return getAppVersionAsString(appPackage, deviceID);
    }

    public int getAppVersionAsInt(String appPackage){
        return getAppVersionAsInt(appPackage, deviceID);
    }

    public String getAppName(String appPackage) {
        return getAppName(appPackage, deviceID);
    }

    public  String getForegroundActivity() {
        return getForegroundActivity(deviceID);
    }

    public  String getAndroidVersionAsString(){
        return getAndroidVersionAsString(deviceID);
    }

    public int getAndroidVersionAsInt(){
        return getAndroidVersionAsInt(deviceID);
    }

    public  LinkedList getInstalledPackages(){
        return getInstalledPackages(deviceID);
    }

    public void openAppsActivity(String packageID, String activityID){
        openAppsActivity(packageID, activityID, deviceID);
    }

    public void clearAppsData(String packageID){
        clearAppsData(packageID, deviceID);
    }

    public void forceStopApp(String packageID){
        forceStopApp(packageID, deviceID);
    }

    public void installApp(String apk){
        installApp(apk, deviceID);
    }

    public void uninstallApp(String packageID){
        uninstallApp(packageID, deviceID);
    }

    public void clearLogBuffer() {
        clearLogBuffer(deviceID);
    }

    public String getDevicesModel(){
        return getDevicesModel(deviceID);
    }

    public String getDevicesModelID(){
        return getDevicesModelID(deviceID);
    }

    public String getDevicesSerialNumber(){
        return getDevicesSerialNumber(deviceID);
    }

    public String getDevicesLanguageSettings() {
        return getDevicesLanguageSettings(deviceID);
    }

    public String getDevicesManufacturer(){
        return getDevicesManufacturer(deviceID);
    }

    public String getDevicesCarrier() {
        return getDevicesCarrier(deviceID);
    }

    public boolean rebootDevice(int secondsToWaitForBootup){
        return rebootDevice(deviceID, secondsToWaitForBootup);
    }

    public void rebootDevice() {
        rebootDevice(deviceID);
    }

    public String getAnrFileLocation() {
        return getAnrFileLocation(deviceID);
    }

    public int getDevicesWiFiMode() {
        return getDevicesWiFiMode(deviceID);
    }

    public int getDevicesAirPlaneMode(){
        return getDevicesAirPlaneMode(deviceID);
    }

    public int getDevicesCellMode(){
        return getDevicesCellMode(deviceID);
    }

    public String getDevicesNetworkInterfaceStatus(String interfaceId){
        return getDevicesNetworkInterfaceStatus(deviceID, interfaceId);
    }

    public void pushFile(String source, String target){
        pushFile(source,target, deviceID);
    }

    public void pullFile(String source, String target){
        pullFile(source,target, deviceID);
    }

    public void deleteFile(String target){
        deleteFile(target, deviceID);
    }

    public void moveFile(String source, String target){
        moveFile(source, target, deviceID);
    }

    public void takeScreenshot(String target){
        takeScreenshot(target, deviceID);
    }

    public LinkedList getDirectoryContent(String target){
        return getDirectoryContent(target, deviceID);
    }

}
