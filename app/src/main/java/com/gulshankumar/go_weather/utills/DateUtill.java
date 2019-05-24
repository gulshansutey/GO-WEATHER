package com.gulshankumar.go_weather.utills;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtill {
    
    public static String convertMilliToDate(String millis){
        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        
        Date date =new Date();
        try {
            date = dateFormat.parse(millis);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.US);
       return sdf.format(date);
    }
    
}
