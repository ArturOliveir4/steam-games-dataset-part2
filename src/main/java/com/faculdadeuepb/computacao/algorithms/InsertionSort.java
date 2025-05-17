package com.faculdadeuepb.computacao.algorithms;

import java.io.IOException;

import com.faculdadeuepb.computacao.model.utils.Date;

public class InsertionSort {

    // ---------------------------------------------- ALGORITMOS ----------------------------------------------

    public static String[][] insertionSort_RealeseDate(String[][] rawData){
        int rows = rawData.length;

        for(int i = 1; i < rows; i++){
            String[] chave = rawData[i];
            int j = i - 1;

            while(j >= 0 && !Date.checkDateSize(rawData[j][2], chave[2])){
                rawData[j+1] = rawData[j]; 
                j = j-1;
            }
            rawData[j+1] = chave;  
        }
        
        return rawData;
    }

    public static String[][] insertionSort_Price(String[][] rawData){
        int rows = rawData.length;

        for(int i = 1; i < rows; i++){
            String[] chave = rawData[i];
            int j = i - 1;

            while(j >= 0 && !(Double.parseDouble(rawData[j][6]) < Double.parseDouble(chave[6]))){
                rawData[j+1] = rawData[j]; 
                j = j-1;
            }
            rawData[j+1] = chave;  
        }
        
        return rawData;
    }

    public static String[][] insertionSort_Achievements(String[][] rawData){
        int rows = rawData.length;

        for(int i = 1; i < rows; i++){
            String[] chave = rawData[i];
            int j = i - 1;

            while(j >= 0 && !(MatrixTransformations.safeParseInt(rawData[j][26]) > MatrixTransformations.safeParseInt(chave[26]))){
                rawData[j+1] = rawData[j]; 
                j = j-1;
            }
            rawData[j+1] = chave;  
        }
        
        return rawData;
    }

    // ---------------------------------------------- CRIAÇÃO DOS ARQUIVOS | DATA DE LANÇAMENTO ----------------------------------------------

    public static void createCsv_InsertionSortReleaseDate_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_insertionSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = insertionSort_RealeseDate(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_insetionSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_InsertionSortReleaseDate_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_insertionSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = insertionSort_RealeseDate(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_insertionSort_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_InsertionSortReleaseDate_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_insertionSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = insertionSort_RealeseDate(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_insertionSort_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    // ---------------------------------------------- CRIAÇÃO DOS ARQUIVOS | PREÇO ----------------------------------------------

    public static void createCsv_InsertionSortPrice_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_insertionSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = insertionSort_Price(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_insetionSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_InsertionSortPrice_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_insertionSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = insertionSort_Price(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_insertionSort_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_InsertionSortPrice_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_insertionSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = insertionSort_Price(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_insertionSort_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    // ---------------------------------------------- CRIAÇÃO DOS ARQUIVOS | CONQUISTAS ----------------------------------------------

    public static void createCsv_InsertionSortAchievements_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_insertionSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = insertionSort_Achievements(formatedCsvMatrix); 
        

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_insertionSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_InsertionSortAchievements_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_insertionSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = insertionSort_Achievements(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_insertionSort_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_InsertionSortAchievements_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_insertionSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = insertionSort_Achievements(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_insertionSort_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }
}
