package com.faculdadeuepb.computacao.algorithms;

import java.io.IOException;

import com.faculdadeuepb.computacao.model.utils.Date;

public class MergeSort {

    // ---------------------------------------------- ALGORITMOS ----------------------------------------------

    public static String[][] mergeSort_RealeseDate(String[][] dataArray, int rows){
        if(rows <= 1){
            return dataArray;
        }

        int middle = rows / 2;

        String[][] left = copyOfRange(dataArray, 0, middle);
        String[][] right = copyOfRange(dataArray, middle, rows);

        left = mergeSort_RealeseDate(left, left.length);
        right = mergeSort_RealeseDate(right, right.length);

        return merge(left, right);
    }

    private static String[][] merge(String[][] left, String[][] right){

        int leftSize = left.length;
        int rightSize = right.length;
        String[][] result = new String[leftSize + rightSize][];
    
        int i = 0, j = 0, k = 0;
    
        while(i < leftSize && j < rightSize){
            if(Date.checkDateSize(left[i][2], right[j][2])){
                result[k++] = left[i++];
            }else{
                result[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            result[k++] = left[i++];
        }
        while (j < rightSize) {
            result[k++] = right[j++];
        }
    
        return result;

    }

    public static String[][] copyOfRange(String[][] original, int start, int end) {
        int length = end - start;
        String[][] result = new String[length][];

        for (int i = 0; i < length; i++) {
            result[i] = original[start + i];
        }

        return result;
    }


    public static String[][] mergeSort_Price(String[][] dataArray, int rows) {
        if(rows <= 1){
            return dataArray;
        }
        int middle = rows / 2;

        String[][] left = copyOfRange(dataArray, 0, middle);
        String[][] right = copyOfRange(dataArray, middle, rows);

        left = mergeSort_Price(left, left.length);
        right = mergeSort_Price(right, right.length);

        return merge_Price(left, right);
    }

    private static String[][] merge_Price(String[][] left, String[][] right) {

        int leftSize = left.length;
        int rightSize = right.length;
        String[][] result = new String[leftSize + rightSize][];
    
        int i = 0, j = 0, k = 0;
    
        while(i < leftSize && j < rightSize){
            if(Double.parseDouble(left[i][6]) < Double.parseDouble(right[j][6])){
                result[k++] = left[i++];
            }else{
                result[k++] = right[j++];
            }
        }

        while(i < leftSize){
            result[k++] = left[i++];
        }
        while(j < rightSize){
            result[k++] = right[j++];
        }
    
        return result;

    }

    public static String[][] mergeSort_Achievements(String[][] dataArray, int rows) {
        if(rows <= 1){
            return dataArray;
        }
        int middle = rows / 2;

        String[][] left = copyOfRange(dataArray, 0, middle);
        String[][] right = copyOfRange(dataArray, middle, rows);

        left = mergeSort_Achievements(left, left.length);
        right = mergeSort_Achievements(right, right.length);

        return merge_Achievements(left, right);
    }

    private static String[][] merge_Achievements(String[][] left, String[][] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        String[][] result = new String[leftSize + rightSize][];

        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize){
            if(MatrixTransformations.safeParseInt(left[i][26]) > MatrixTransformations.safeParseInt(right[j][26])){ // ordem decrescente
                result[k++] = left[i++];
            }else{
                result[k++] = right[j++];
            }
        }

        while(i < leftSize){
            result[k++] = left[i++];
        }
        while(j < rightSize){
            result[k++] = right[j++];
        }

        return result;
    }

    



    // ---------------------------------------------- CRIAÇÃO DOS ARQUIVOS ----------------------------------------------


    public static void createCsv_MergeSortReleaseDate_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_mergeSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = mergeSort_RealeseDate(formatedCsvMatrix, formatedCsvMatrix.length);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_mergeSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_MergeSortReleaseDate_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_mergeSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = mergeSort_RealeseDate(formatedCsvMatrix, formatedCsvMatrix.length); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_mergeSort_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_MergeSortReleaseDate_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_mergeSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = mergeSort_RealeseDate(formatedCsvMatrix, formatedCsvMatrix.length); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_mergeSort_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    public static void createCsv_MergeSortPrice_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_mergeSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = mergeSort_Price(formatedCsvMatrix, formatedCsvMatrix.length);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_mergeSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_MergeSortPrice_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_mergeSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = mergeSort_Price(formatedCsvMatrix, formatedCsvMatrix.length); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_mergeSort_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_MergeSortPrice_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_mergeSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = mergeSort_Price(formatedCsvMatrix, formatedCsvMatrix.length); 


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_mergeSort_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }



    public static void createCsv_MergeSortAchievements_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_mergeSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = mergeSort_Achievements(formatedCsvMatrix, formatedCsvMatrix.length);   

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_mergeSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_MergeSortAchievements_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_mergeSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = mergeSort_Achievements(formatedCsvMatrix, formatedCsvMatrix.length);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_mergeSort_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_MergeSortAchievements_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_mergeSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = mergeSort_Achievements(formatedCsvMatrix, formatedCsvMatrix.length);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_mergeSort_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

}