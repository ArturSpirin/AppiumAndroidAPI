package utils;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Artur Spirin on 1/21/16.
 **/
public class CommonUtils {

    public static String runtimeCommand (String command)  {
        System.out.println("Command: " +command);
        try{
            Scanner s = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");
            if(s.hasNext()) return s.next();
            else return null;
        }catch (IOException e){
            throw new RuntimeException("Failed to run command: "+command+"! Caught exception: "+e.getMessage());
        }
    }

    public static String getAndroidHome(){
        if(osIsOSX()) return "/Users/support/Library/Android/sdk"; //TODO Remove if, this is for debugging purposes only
        else return System.getenv("ANDROID_HOME");
    }

    public static String getOS(){
        System.out.println(System.getProperty("os.name"));
        return System.getProperty("os.name");
    }

    public static boolean osIsWindows(){
        return getOS().contains("Windows");
    }

    public static boolean osIsOSX(){
        return getOS().contains("Mac");
    }

    public static boolean osIsLinux(){
        return getOS().contains("Linux");
    }
}
