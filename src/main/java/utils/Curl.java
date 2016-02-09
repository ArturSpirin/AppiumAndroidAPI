package utils;

/**
 * Created by Artur on 1/30/2016.
 */
public class cURL {

    private String curlLocation = "/data/local/tmp";
    public cURL() {
        if(curlLocation.contains("/curl")) curlLocation = curlLocation.replace("/curl","");
        if(curlLocation.endsWith("/")) curlLocation = curlLocation.substring(0,curlLocation.length() - 1);
    }

    public cURL setLocation(String curlLocation){
        if(curlLocation.contains("/curl")) curlLocation = curlLocation.replace("/curl","");
        if(curlLocation.endsWith("/")) curlLocation = curlLocation.substring(0,curlLocation.length() - 1);
        this.curlLocation = curlLocation;
        return this;
    }

    public boolean isAvailable(){
        return !ADB.runCommand("adb shell "+curlLocation+"/curl --version").toLowerCase().contains("not found");
    }

    public String get(String address){
        if(!isAvailable()) throw new RuntimeException("cURL is not accessible at: \""+curlLocation+"\" " +
                "Make sure that curl location is set correctly. Note that devices with Lollipop+ OS do not allow curl use.");
        return ADB.runCommand("adb shell "+curlLocation+" " + address);
    }

    public String get(String address, String[] args){
        if(!isAvailable()) throw new RuntimeException("cURL is not accessible at: \""+curlLocation+"\" " +
                "Make sure that curl location is set correctly. Note that devices with Lollipop+ OS do not allow curl use.");
        String command = "adb shell "+curlLocation;
        if(args!=null) for (String arg : args) command += " " + arg;
        command = command+address;
        return ADB.runCommand(command);
    }
}
