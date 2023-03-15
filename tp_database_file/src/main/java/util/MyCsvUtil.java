package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

public class MyCsvUtil {
	
	public static String writeValuesAsCsvStringV1(Object obj){
  	  String csvString=null;
  	  Class<?> c = obj.getClass(); //meta description de la classe de l'objet obj
		  try {
			Field[] tabChamps = c.getDeclaredFields();
				for(Field f : tabChamps) {
					f.setAccessible(true); //pour acceder aux parties privées
					String fieldValue= f.get(obj)==null?null:f.get(obj).toString();
					csvString=(csvString==null)?fieldValue : csvString + ";" +fieldValue;
				}
		} catch (Exception e) {
			e.printStackTrace();
		} 
  	return csvString;
    }  
	
      public static String writeValuesAsCsvString(Object obj){
    	  String csvString=null;
    	  Class<?> c = obj.getClass(); //meta description de la classe de l'objet obj
		  try {
			Field[] tabChamps = c.getDeclaredFields();
				for(Field f : tabChamps) {
					CsvIgnore annotCsvIgnore = f.getAnnotation(CsvIgnore.class);
					//si annotCsvIgnore==null , @CsvIgnore n'a pas été placé au dessus de f
					if(annotCsvIgnore==null) {
						f.setAccessible(true); //pour acceder aux parties privées
						String fieldValue= f.get(obj)==null?null:f.get(obj).toString();
						csvString=(csvString==null)?fieldValue : csvString + ";" +fieldValue;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	return csvString;
      }
      
      
      public static String writeFieldNamesAsCsvStringV1(Object obj){
    	  String csvString=null;
    	  Class<?> c = obj.getClass(); //meta description de la classe de l'objet obj
		  try {
			Field[] tabChamps = c.getDeclaredFields();
				for(Field f : tabChamps) {
					String fieldName= f.getName();
					csvString=(csvString==null)?fieldName:csvString + ";" +fieldName;
				}
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	return csvString;
      }
      
      public static String writeFieldNamesAsCsvString(Object obj){
    	  String csvString=null;
    	  Class<?> c = obj.getClass(); //meta description de la classe de l'objet obj
		  try {
			Field[] tabChamps = c.getDeclaredFields();
				for(Field f : tabChamps) {
					CsvIgnore annotCsvIgnore = f.getAnnotation(CsvIgnore.class);
					//si annotCsvIgnore==null , @CsvIgnore n'a pas été placé au dessus de f
					if(annotCsvIgnore==null) {
						String fieldName= f.getName();
						csvString=(csvString==null)?fieldName:csvString + ";" +fieldName;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	return csvString;
      }
      
      public static void writeValuesAsCsvFile(List<?> col,String fileName){
    	    if(col.isEmpty()) {
    	    	return;//fin fonction sans rien faire
    	    }
    	    try (PrintStream ps = new PrintStream(new FileOutputStream(fileName))){
				Object firstObj = col.get(0);
				String ligneEnteteAuFormatCsv= writeFieldNamesAsCsvString(firstObj);
				ps.println(ligneEnteteAuFormatCsv);
				for(Object obj:col) {
					String ligneValeursAuFormatCsv= writeValuesAsCsvString(obj);
					ps.println(ligneValeursAuFormatCsv);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}//try_with_autoCloseable resource
      }
}
