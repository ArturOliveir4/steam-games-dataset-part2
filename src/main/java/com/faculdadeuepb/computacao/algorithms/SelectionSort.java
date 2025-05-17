package com.faculdadeuepb.computacao.algorithms;

import java.io.IOException;

import com.faculdadeuepb.computacao.model.utils.Date;

public class SelectionSort {

    // ---------------------------------------------- ALGORITMOS ----------------------------------------------


    // Ordena de ordem crescente a partir do campo Release date
    public static String[][] selectionSortRealeseDate(String[][] rawData){
        int rows = rawData.length;
        for(int i = 0; i < rows-1; i++){
            int minIndex = i;
            for(int j = i+1; j<rows; j++){
                if(Date.checkDateSize(rawData[j][2], rawData[minIndex][2])){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                String[] temp = rawData[i];
                rawData[i] = rawData[minIndex];
                rawData[minIndex] = temp;
            }
        }
        
        return rawData;
    }

    // Ordena de ordem crescente a partir do campo Price
    public static String[][] selectionSortPrice(String[][] rawData){
        int rows = rawData.length;
        for(int i = 0; i < rows-1; i++){
            int minIndex = i;
            for(int j = i+1; j<rows; j++){
                if(Double.parseDouble(rawData[j][6]) < Double.parseDouble(rawData[minIndex][6])){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                String[] temp = rawData[i];
                rawData[i] = rawData[minIndex];
                rawData[minIndex] = temp;
            }
        }
        
        return rawData;
    }

    // Ordena de ordem decrescente a partir do campo Achievements
    public static String[][] selectionSortAchievements(String[][] rawData){
        int rows = rawData.length;
        for(int i = 0; i < rows-1; i++){
            int minIndex = i;
            for(int j = i+1; j<rows; j++){
                if(MatrixTransformations.safeParseInt(rawData[j][26]) > MatrixTransformations.safeParseInt(rawData[minIndex][26])){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                String[] temp = rawData[i];
                rawData[i] = rawData[minIndex];
                rawData[minIndex] = temp;
            }
        }
        
        return rawData;
    }

    // ---------------------------------------------- CRIAÇÃO DOS ARQUIVOS | DATA DE LANÇAMENTO ----------------------------------------------

    public static void createCsv_SelectionSortReleaseDate_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_SelectionSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = selectionSortRealeseDate(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_selectionSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_SelectionSortReleaseDate_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_SelectionSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = selectionSortRealeseDate(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_selectionSort_melhorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_SelectionSortReleaseDate_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_SelectionSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = selectionSortRealeseDate(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_selectionSort_piorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   

    // ---------------------------------------------- CRIAÇÃO DOS ARQUIVOS | PREÇO ----------------------------------------------

    public static void createCsv_SelectionSortPrice_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_SelectionSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = selectionSortPrice(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_selectionSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_SelectionSortPrice_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_SelectionSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = selectionSortPrice(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_selectionSort_melhorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_SelectionSortPrice_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_SelectionSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = selectionSortPrice(formatedCsvMatrix); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_selectionSort_piorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   

    // ---------------------------------------------- CRIAÇÃO DOS ARQUIVOS | PREÇO ----------------------------------------------

    public static void createCsv_SelectionSortAchievements_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_SelectionSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = selectionSortAchievements(formatedCsvMatrix);   

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_selectionSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_SelectionSortAchievements_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_SelectionSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = selectionSortAchievements(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_selectionSort_melhorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_SelectionSortAchievements_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_SelectionSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = selectionSortAchievements(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_selectionSort_piorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   
}