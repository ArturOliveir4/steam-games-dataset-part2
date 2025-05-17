package com.faculdadeuepb.computacao.algorithms;

import java.io.IOException;

import com.faculdadeuepb.computacao.model.utils.Date;


public class QuickSortMedian {
    public static String[][] quickSortMedianReleaseDate(String[][] rawData){
        quickSortMedian(rawData, 0, rawData.length - 1);
        return rawData;
    }

    private static void quickSortMedian(String[][] rawData, int low, int high){
        if(low<high){
            int pivotIndex = partitionMedian(rawData, low, high);
            quickSortMedian(rawData, low, pivotIndex - 1);
            quickSortMedian(rawData, pivotIndex + 1, high);
        }
    }

    private static int partitionMedian(String[][] rawData, int low, int high){
        int pivotIndex = medianOfThree(rawData, low, high);
        String[] pivot = rawData[pivotIndex];
        
        swap(rawData, pivotIndex, high);
        
        int i = low;
        for(int j = low; j < high; j++){
            if(Date.checkDateSize(rawData[j][2], pivot[2])){
                swap(rawData, i, j);
                i++;
            }
        }
        
        swap(rawData, i, high);
        return i;
    }

    private static int medianOfThree(String[][] rawData, int low, int high){
        int mid = low + (high - low)/2;
        
        if (Date.checkDateSize(rawData[mid][2], rawData[low][2])){
            swap(rawData, low, mid);
        }
        if (Date.checkDateSize(rawData[high][2], rawData[low][2])){
            swap(rawData, low, high);
        }
        if (Date.checkDateSize(rawData[high][2], rawData[mid][2])){
            swap(rawData, mid, high);
        }
        
        return mid; 
    }

    private static void swap(String[][] rawData, int i, int j) {
        String[] temp = rawData[i];
        rawData[i] = rawData[j];
        rawData[j] = temp;
    }


    public static String[][] quickSortMedianPrice(String[][] rawData) {
        quickSortP(rawData, 0, rawData.length - 1);
        return rawData;
    }

    private static void quickSortP(String[][] rawData, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionPrice(rawData, low, high);
            quickSortP(rawData, low, pivotIndex);
            quickSortP(rawData, pivotIndex + 1, high);
        }
    }

    private static int partitionPrice(String[][] rawData, int low, int high) {
        // Mediana de 3
        int mid = low + (high - low) / 2;
        
        // Ordena low, mid, high para encontrar a mediana
        if (Double.parseDouble(rawData[low][6]) > Double.parseDouble(rawData[mid][6])){
            swap(rawData, low, mid);
        }
        if (Double.parseDouble(rawData[low][6]) > Double.parseDouble(rawData[high][6])){
            swap(rawData, low, high);
        }
        if (Double.parseDouble(rawData[mid][6]) > Double.parseDouble(rawData[high][6])){
            swap(rawData, mid, high);
        }
        
        // Coloca o pivô (mediana) na posição low
        swap(rawData, mid, low);
        
        String[] pivot = rawData[low]; 
        int left = low - 1;
        int right = high + 1;

        while (true) {
            do {
                left++;
            } while (Double.parseDouble(rawData[left][6]) < Double.parseDouble(pivot[6]));

            do {
                right--;
            } while (Double.parseDouble(rawData[right][6]) > Double.parseDouble(pivot[6]));

            if (left >= right) {
                return right;
            }

            swap(rawData, left, right);
        }
    }

    



    public static String[][] quickSortMedianAchievements(String[][] rawData) {
        quickSortA(rawData, 0, rawData.length - 1);
        return rawData;
    }

    private static void quickSortA(String[][] rawData, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionAchievements(rawData, low, high);
            quickSortA(rawData, low, pivotIndex);
            quickSortA(rawData, pivotIndex + 1, high);
        }
    }

    private static int partitionAchievements(String[][] rawData, int low, int high) {
        // Mediana de 3
        int mid = low + (high - low) / 2;
        
        // Ordena low, mid, high para encontrar a mediana
        if (MatrixTransformations.safeParseInt(rawData[low][26]) < MatrixTransformations.safeParseInt(rawData[mid][26])) {
            swap(rawData, low, mid);
        }
        if (MatrixTransformations.safeParseInt(rawData[low][26]) < MatrixTransformations.safeParseInt(rawData[high][26])) {
            swap(rawData, low, high);
        }
        if (MatrixTransformations.safeParseInt(rawData[mid][26]) < MatrixTransformations.safeParseInt(rawData[high][26])) {
            swap(rawData, mid, high);
        }
        
        // Coloca o pivô (mediana) na posição low
        swap(rawData, mid, low);
        
        String[] pivot = rawData[low]; 
        int left = low - 1;
        int right = high + 1;

        while (true) {
            do {
                left++;
            } while (MatrixTransformations.safeParseInt(rawData[left][26]) > MatrixTransformations.safeParseInt(pivot[26]));

            do {
                right--;
            } while (MatrixTransformations.safeParseInt(rawData[right][26]) < MatrixTransformations.safeParseInt(pivot[26]));

            if (left >= right) {
                return right;
            }

            swap(rawData, left, right);
        }
    }

    

   


    


    public static void createCsv_QuickSortMedianReleaseDate_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_quickSortMedianaDeTres_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortMedianReleaseDate(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_quickSortMedianaDeTres_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_QuickSortMedianReleaseDate_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_quickSortMedianaDeTres_melhorCaso.csv'");

        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortMedianReleaseDate(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_quickSortMedianaDeTres_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_QuickSortMedianReleaseDate_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_quickSortMedianaDeTres_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortMedianReleaseDate(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_quickSortMedianaDeTres_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   



    public static void createCsv_QuickSortMedianPrice_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_quickSortMedianaDeTres_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortMedianPrice(formatedCsvMatrix);

        

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_quickSortMedianaDeTres_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_QuickSortMedianPrice_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_quickSortMedianaDeTres_melhorCaso.csv'");

        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortMedianPrice(formatedCsvMatrix);   

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_quickSortMedianaDeTres_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_QuickSortMedianPrice_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_quickSortMedianaDeTres_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortMedianPrice(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_quickSortMedianaDeTres_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   




    public static void createCsv_QuickSortMedianAchievements_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_quickSortMedianaDeTres_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortMedianAchievements(formatedCsvMatrix);   

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_quickSortMedianaDeTres_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_QuickSortMedianAchievements_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_quickSortMedianaDeTres_melhorCaso.csv'");

        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortMedianAchievements(formatedCsvMatrix);   

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_quickSortMedianaDeTres_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_QuickSortMedianAchievements_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_quickSortMedianaDeTres_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortMedianAchievements(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_quickSortMedianaDeTres_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   
}
