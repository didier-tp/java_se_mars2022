package tp.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WithoutLocalDate {

	public static void main(String[] args) {
		// Manipulations basiques de Date (sans utilisation des nouveautees java 8):
        Date d = new Date(); //date Now As Gmt TimeStamp
        System.out.println("basic date display=" + d);
        System.out.println("d.getTime() , timestamp , nb ms since 1970-01-01 00:00:00 GMT=" + d.getTime());

       SimpleDateFormat simpleDateFormat_us = new SimpleDateFormat("yyyy-MM-dd");
 	   String sdate_us = simpleDateFormat_us.format(d);
 	   System.out.println("sdate_us="+sdate_us);
 	   SimpleDateFormat simpleDateFormat_fr = new SimpleDateFormat("dd/MM/yyyy");
 	   String sdate_fr = simpleDateFormat_fr.format(d);
 	   System.out.println("sdate_fr="+sdate_fr);
 	   

	   Calendar cal = Calendar.getInstance();
	   cal.set(1969,7-1,21); //21/07/1969 (premiers pas sur la lune)
	   Date d2=cal.getTime();
	   System.out.println("premiers pas sur la lune le "+simpleDateFormat_fr.format(d2));
        
	}

}
