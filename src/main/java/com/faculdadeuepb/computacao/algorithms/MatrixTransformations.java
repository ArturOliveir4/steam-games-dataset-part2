package com.faculdadeuepb.computacao.algorithms;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.faculdadeuepb.computacao.model.utils.CSVCreate;


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

        // Verificando o tamnho do csv e criando a matriz -------
        CSVParser parserForCount = CSVCreate.initializeCSVParser(csvFile);
        int rows = 0;
        int columns = 0;

        for(CSVRecord record : parserForCount){
            if(rows == 0){
                columns = record.size();
            }
            rows++;
        }
        parserForCount.close();

        String[][] rawData = new String[rows][columns];
        
        // Preenchendo a matriz com os dados do csv ----------
        CSVParser parserForData = CSVCreate.initializeCSVParser(csvFile);
        int i = 0;
        for (CSVRecord record : parserForData) {
            for (int j = 0; j < columns; j++) {
                rawData[i][j] = record.get(j);
            }
            i++;
        }
        parserForData.close();

        return rawData;
    }

    public static void createCsv(String[][] orderedMatrix, String nomeArquivo) throws IOException{
        File gamesFormatedDate = new File(nomeArquivo);
        try(CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(gamesFormatedDate), 
                CSVFormat.DEFAULT.withHeader(header))){

            for(String[] row : orderedMatrix){
                csvPrinter.printRecord((Object[]) row);
            }

            csvPrinter.flush();
        }
    }

    // Função que ordena a matriz usando uma função do java (Crescente)
    public static void orderJava_Data_Crescente(String[][] formatedCsvMatrix) throws IOException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Arrays.sort(formatedCsvMatrix, Comparator.comparing(row -> LocalDate.parse(row[2], formatter)));
    }

    // Função que ordena a matriz usando uma função do java (Decrescente)
    public static void orderJava_Data_Descrescente(String[][] formatedCsvMatrix) throws IOException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Arrays.sort(formatedCsvMatrix, Comparator.comparing((String[] row) -> LocalDate.parse(row[2], formatter)).reversed());   
    }

}