package com.hockeyhigh.util;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class DataUtil {
    private static String timeRegex = "[:-]";

    public static String getTime(String time) {
        int minutes = Integer.parseInt(getMinutes(time));
        int seconds = Integer.parseInt(getSeconds(time)) ;
        int[] splitSeconds = getGetMinutesFromSeconds(seconds+"");
        minutes+= splitSeconds[0];
        seconds = splitSeconds[1];
        return minutes + ":" + (seconds > 10 ? "" : 0) + seconds;
    }
    public static String addTime(String time1, String time2) {
        int minutes = Integer.getInteger(getMinutes(time1)) + Integer.getInteger(getMinutes(time2));
        int seconds = Integer.getInteger(getSeconds(time1)) + Integer.getInteger(getSeconds(time2));
        int[] splitSeconds = getGetMinutesFromSeconds(seconds+"");
        minutes+= splitSeconds[0];
        seconds = splitSeconds[1];
        return minutes + ":" + seconds;
    }
    public static int[] getGetMinutesFromSeconds(String seconds) {
        int time = Integer.parseInt(seconds);
        int minutes = 0;
        while(time >= 60) {
            if(time % 60 > 0) minutes++;
            time = time - 60;
        }
        return new int[]{minutes, time};

    }
    public static String getMinutes(String time) {
        if(time != null) return time.split(timeRegex)[0];
        return null;
    }

    public static String getSeconds(String time) {
        String[] result = time.split(timeRegex);
        if(time != null && result.length == 2)
        return result[1];
        return null;
    }

    public static int getYears(String dat) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        try {
            Date date = sdf.parse(dat);
            Duration duration = Duration.between(date.toInstant(), Instant.now());
            return (int) (duration.toDays()/365);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
