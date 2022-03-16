package tp.date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class WithLocalDate {

	public static void main(String[] args) {
		// Manipulations basiques de dates (via des nouveautees java 8):
		LocalDate nowDate = LocalDate.now();	 
		System.out.println("basic/default display : today (nowDate local) is " + nowDate);
		
		LocalDateTime now = LocalDateTime.now();
        System.out.println("basic/default display of LocalDateTime.now() :" + now);
        
        LocalDateTime nowUTC = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println("nowUTC = " + nowUTC);
        
        Instant instantT =  now.atZone(ZoneId.systemDefault()).toInstant();
        long nbMsSinceFirstJanuary1970GMT = instantT.toEpochMilli();
        System.out.println("instantT.toEpochMilli() , timestamp , nb ms since 1970-01-01 00:00:00 GMT=" + nbMsSinceFirstJanuary1970GMT);
        
       String sdate_fr_1=nowDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy",Locale.FRENCH));
 	   System.out.println("sdate_fr_1="+sdate_fr_1); //exemple: 13/09/2020
 	   String sdate_fr_2=nowDate.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy",Locale.FRENCH)); // EEEE means fullname of weekday
	   System.out.println("sdate_fr_2="+sdate_fr_2);//exemple: dimanche, 13 septembre 2020
 	   

 	   LocalDate localDatePremiersPasSurLune=LocalDate.of(1969,07,21);
	   System.out.println("premiers pas sur la lune : "+localDatePremiersPasSurLune);
        
		
		// Manipulations plus elaborees de Date (avec nouveautees java 8):
	   LocalTime nowTime = LocalTime.now();	 System.out.println("now is " + nowTime);
	   LocalTime _45mnPlusTard = nowTime.plus(45,ChronoUnit.MINUTES);
	   System.out.println("_45mnPlusTard " + _45mnPlusTard);
	   
	   LocalDate nowDate2 = LocalDate.now();	 System.out.println("today is " + nowDate2);
	   LocalDate _dans7semaines = nowDate2.plus(7,ChronoUnit.WEEKS);
	   System.out.println("_dans7semaines " + _dans7semaines);
	   
	   LocalDateTime locDateTime = nowDate2.atTime(nowTime);
	   System.out.println("today , now is " + locDateTime);
	   
	   LocalDateTime _dans7semainesEt7heures = locDateTime.plus(7,ChronoUnit.WEEKS)
			                                     .plus(7,ChronoUnit.HOURS);
	   System.out.println("_dans7semainesEt7heures="+ _dans7semainesEt7heures);
	   
	   LocalDateTime _12fevrier2022_14h = (LocalDate.of(2022,02,12)).atTime(LocalTime.of(14, 0));
	   LocalDateTime _13fevrier2022_15h30 = (LocalDate.of(2022,02,13)).atTime(LocalTime.of(15, 30));
	   Duration diffTemps = Duration.between(_12fevrier2022_14h, _13fevrier2022_15h30);
	   System.out.println("diffTemps="+diffTemps);//PT25H30M //P1D (periode Temps de 1 25h et 30mn)
	   Period periodeDate = Period.between(_12fevrier2022_14h.toLocalDate(), _13fevrier2022_15h30.toLocalDate()) ; 
	   System.out.println("periodeDate:" + periodeDate);//P1D (periode de 1 Day)
	   
	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	   String sDate = "2022-01-20";

	   //convert String to LocalDate
	   LocalDate localDate = LocalDate.parse(sDate, formatter);
	   System.out.println("localDate=" + localDate.toString());
	   if(localDate.isAfter(nowDate)) {
		   System.out.println("date future");
	   }else {
		   System.out.println("date passee");
	   }
	  
	
	}

}
