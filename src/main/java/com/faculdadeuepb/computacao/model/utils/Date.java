package com.faculdadeuepb.computacao.model.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Date {
    
    public static String convertDate(String dateStr){

    DateTimeFormatter inputFormat, outputFormat;
    LocalDate date;

    inputFormat = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
    outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    if(isValidDate(dateStr, inputFormat)){
        date = LocalDate.parse(dateStr, inputFormat);
        return date.format(outputFormat);
    }
    
    inputFormat = DateTimeFormatter.ofPattern("MMM yyyy dd", Locale.ENGLISH);
    if(isValidDate(dateStr + " 01", inputFormat)){
        date = LocalDate.parse(dateStr + " 01", inputFormat);
        return date.format(outputFormat);
    }
    
    System.out.println("Error: Invalid date format");
    throw new DateTimeParseException("Invalid date format", dateStr, 0);
    }
    
    private static boolean isValidDate(String dateStr, DateTimeFormatter format){

        try{
            LocalDate.parse(dateStr, format);
            return true;
        } 
        catch(DateTimeParseException e){
            return false;
        }

    }

    public static Boolean checkDateSize(String firstDate, String secondDate){

        String[] firstDateParts = firstDate.split("/");
        String[] secondDateParts = secondDate.split("/");
    
        int day1 = Integer.parseInt(firstDateParts[0]);
        int month1 = Integer.parseInt(firstDateParts[1]);
        int year1 = Integer.parseInt(firstDateParts[2]);
    
        int day2 = Integer.parseInt(secondDateParts[0]);
        int month2 = Integer.parseInt(secondDateParts[1]);
        int year2 = Integer.parseInt(secondDateParts[2]);
    
        if (year1 > year2) {
            return false;
        } 
        
        else if (year1 == year2 && month1 > month2) {
            return false;
        } 
        
        else if (year1 == year2 && month1 == month2 && day1 > day2) {
            return false;
        }
    
        return true;

    }

}
