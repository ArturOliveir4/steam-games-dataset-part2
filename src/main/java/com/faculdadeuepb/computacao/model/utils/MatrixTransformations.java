package com.faculdadeuepb.computacao.model.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.faculdadeuepb.computacao.algorithms.InsertionSort;
import com.faculdadeuepb.computacao.algorithms.MergeSort;
import com.faculdadeuepb.computacao.algorithms.SelectionSort;


public class MatrixTransformations {

    // Atributo header utilizado na criação de todos os .csv dessa classe
    private static String[] header;

    // Bloco estático para inicializar o cabeçalho
    static {
        try {
            header = getCsvHeader("games_formated_release_data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obter o cabeçalho do arquivo .csv
    public static String[] getCsvHeader(String csvFileName) throws IOException {
        File csvFile = new File(csvFileName);
        try(
            FileReader reader = new FileReader(csvFile);
            CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)
        ){
            return parser.getHeaderMap().keySet().toArray(new String[0]);
        }
    }

    // Função que converte o arquivo .csv passado por parâmetro em String em matriz
    public static String[][] csvToMatrix(String csvFileName) throws IOException {
        File csvFile = new File(csvFileName);
        CSVParser csvParser = CSVCreate.initializeCSVParser(csvFile);
        List<CSVRecord> records = csvParser.getRecords();
        int rows = records.size();
        
        int columns = 0;
        if(rows > 0){
            columns = records.get(0).size();
        }

        String[][] rawData = new String[rows][columns];

        for(int i = 0; i < rows; i++){
            CSVRecord record = records.get(i);
            for(int j = 0; j < columns; j++){
                rawData[i][j] = record.get(j);
            }
        }

        csvParser.close();
        return rawData;
    }

    // ---- FUNÇÕES DE CRIAÇÃO DE .CSV --------

    public static void createCsv(String[][] orderedMatrix) throws IOException{

    }
    
    // Função que cria o .csv a partir do médio caso de ordenação do SelectionSort (a ordenação e criação ocorrem nessa função)
    public static void createCsv_SelectionSortReleaseDate_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("Generating 'games_release_date_insertionSort_medioCaso.csv'");

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = SelectionSort.selectionSortRealeseDate(formatedCsvMatrix);   

        // Criando de fato o arquivo .csv
        File gamesFormatedDate = new File("games_release_date_insertionSort_medioCaso.csv");
        try(CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(gamesFormatedDate), 
                CSVFormat.DEFAULT.withHeader(header))){

            for(String[] row : formatedCsvMatrix){
                csvPrinter.printRecord((Object[]) row);
            }

            csvPrinter.flush();
        }
        System.out.println("Done\n");
    }

    // Função que cria o .csv a partir do médio caso de ordenação do SelectionSort (a ordenação e criação ocorrem nessa função)
    public static void createCsv_SelectionSortReleaseDate_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("Generating 'games_release_date_SelectionSort_medioCaso.csv'");

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = SelectionSort.selectionSortRealeseDate(formatedCsvMatrix); 

        // Criando de fato o arquivo .csv
        File gamesFormatedDate = new File("games_release_date_SelectionSort_medioCaso.csv");
        try(CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(gamesFormatedDate), 
                CSVFormat.DEFAULT.withHeader(header))){

            for(String[] row : formatedCsvMatrix){
                csvPrinter.printRecord((Object[]) row);
            }

            csvPrinter.flush();
        }
        System.out.println("Done\n");

    }

    public static void createCsv_MergeSortReleaseDate_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("Generating 'games_release_date_MergeSort_medioCaso.csv'");

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = MergeSort.mergeSort(formatedCsvMatrix, formatedCsvMatrix.length);      

        // Criando de fato o arquivo .csv
        File gamesFormatedDate = new File("games_release_date_MergeSort_medioCaso.csv");
        try(CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(gamesFormatedDate), 
                CSVFormat.DEFAULT.withHeader(header))){

            for(String[] row : formatedCsvMatrix){
                csvPrinter.printRecord((Object[]) row);
            }

            csvPrinter.flush();
        }
        System.out.println("Done\n");
    }

    public static void createCsv_InsertionSortReleaseDate_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("Generating 'games_release_date_InsertionSort_medioCaso.csv'");

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = InsertionSort.insertionSort(formatedCsvMatrix, formatedCsvMatrix.length); 

        // Criando de fato o arquivo .csv
        File gamesFormatedDate = new File("games_release_date_InsertionSort_medioCaso.csv");
        try(CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(gamesFormatedDate), 
                CSVFormat.DEFAULT.withHeader(header))){

            for(String[] row : formatedCsvMatrix){
                csvPrinter.printRecord((Object[]) row);
            }

            csvPrinter.flush();
        }
        System.out.println("Done\n");
    }

}