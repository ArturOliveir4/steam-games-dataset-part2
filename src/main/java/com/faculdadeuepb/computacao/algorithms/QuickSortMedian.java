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

    private static void swap(String[][] array, int i, int j){
        String[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    

    public static String[][] quickSortMedianPrice(String[][] rawData){
        quickSortMedianP(rawData, 0, rawData.length - 1);
        return rawData;
    }

    private static void quickSortMedianP(String[][] rawData, int low, int high){
        if(low<high){
            int pivotIndex = partitionMedianP(rawData, low, high);
            quickSortMedianP(rawData, low, pivotIndex - 1);
            quickSortMedianP(rawData, pivotIndex + 1, high);
        }
    }

    private static int partitionMedianP(String[][] rawData, int low, int high){
        int pivotIndex = medianOfThreeP(rawData, low, high);
        String[] pivot = rawData[pivotIndex];

        // Valor numérico do campo price (coluna 6)
        double pivotPrice = Double.parseDouble(pivot[6]);
        if (pivotPrice == 0.0) {
            pivotPrice = 6.29; // Usa 6.29 só para comparação, sem modificar os dados
            System.out.println("Pivot com 0.0 tratado logicamente como 6.29");
        }

        System.out.println("Valor bruto em pivot[6]: '" + pivot[6] + "'");
        
        swap(rawData, pivotIndex, high);
        
        int i = low;
        for (int j = low; j < high; j++) {
            if (Double.parseDouble(rawData[j][6]) < pivotPrice) {
                swap(rawData, i, j);
                i++;
            }
        }
        
        swap(rawData, i, high);
        return i;
    }


    private static int medianOfThreeP(String[][] rawData, int low, int high){
        int mid = (low + (high - low))/2;
        
        if (Double.parseDouble(rawData[mid][6]) < Double.parseDouble(rawData[low][6])){
            swap(rawData, low, mid);
        }
        if (Double.parseDouble(rawData[high][6]) < Double.parseDouble(rawData[low][6])){
            swap(rawData, low, high);
        }
        if (Double.parseDouble(rawData[high][6]) < Double.parseDouble(rawData[mid][6])){
            swap(rawData, mid, high);
        }
        
        return mid; 
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
}
