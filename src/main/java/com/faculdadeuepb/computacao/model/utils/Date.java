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

}
