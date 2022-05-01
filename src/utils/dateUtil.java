package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dateUtil {
   
    public static Date convert(String date){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            simpleDateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(dateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
