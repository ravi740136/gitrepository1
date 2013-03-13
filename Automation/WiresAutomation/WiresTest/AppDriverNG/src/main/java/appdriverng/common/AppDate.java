package appdriverng.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class AppDate {

	static final Logger LOG = Logger.getLogger("deshaw.automation");
public static String today() {
  
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
       return dateFormat.format(calendar.getTime()).toString();
            

    }

public static String todayForFilename() {

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hh_mm"); 
   return dateFormat.format(calendar.getTime()).toString();
        

}

public static String todayForFoldername() {

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy"); 
   return dateFormat.format(calendar.getTime()).toString();
        

}

public static String relativeDateFromToday(int count) {
	LOG.info("returning date");
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, count);
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
   return dateFormat.format(calendar.getTime()).toString();
        

}
	
}
