package utils;

import java.util.Date;

/**
 * Created by Artur Spirin on 1/29/16.
 **/
public class Timer {

    public long startStamp;

    public long getTimeStamp(){
        return new Date().getTime();
    }

    public int getDifference(){
        return (int) ((getTimeStamp() - startStamp)/1000);
    }

    public void startTimer(){
        startStamp = getTimeStamp();
    }

    public boolean timeExpired(int timeout){
        int difference = getDifference();
        return difference > timeout;
    }
}
