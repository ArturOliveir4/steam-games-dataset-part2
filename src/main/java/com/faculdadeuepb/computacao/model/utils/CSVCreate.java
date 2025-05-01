package com.faculdadeuepb.computacao.model.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;

public class CSVCreate {

    public static CSVParser initializeCSVParser(File readFile){
        
        CSVParser csvParser = null;
        try{
            Reader reader = new FileReader(readFile);
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build());
        }
        catch(FileNotFoundException e){
            System.out.println("Erro: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return csvParser;
    }

    public static CSVPrinter initializeCSVPrinter(File createdFile, CSVParser csvParser){
        CSVPrinter csvPrinter = null;
        
        try{
            Writer writer = new FileWriter(createdFile);
            csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.builder().setHeader(csvParser.getHeaderMap().keySet().toArray(new String[0])).build());
        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return csvPrinter;
    }

}
