package com.faculdadeuepb.computacao.algorithms;

import java.io.IOException;

import com.faculdadeuepb.computacao.model.utils.Date;

public class HeapSort {

    public static String[][] heapSortReleaseDate(String[][] rawData){
        int n = rawData.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(rawData, n, i);
        }

        for(int i = n - 1; i > 0; i--){
            String[] temp = rawData[0];
            rawData[0] = rawData[i];
            rawData[i] = temp;

            heapify(rawData, i, 0);
        }

        return rawData;
    }

    private static void heapify(String[][] data, int heapSize, int rootIndex){
        int smallest = rootIndex; 
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if(left < heapSize && !Date.checkDateSize(data[left][2], data[smallest][2])){
            smallest = left;
        }

        if(right < heapSize && !Date.checkDateSize(data[right][2], data[smallest][2])){
            smallest = right;
        }

        if(smallest != rootIndex){
            String[] swap = data[rootIndex];
            data[rootIndex] = data[smallest];
            data[smallest] = swap;

            heapify(data, heapSize, smallest);
        }
    }

    public static String[][] heapSortPrice(String[][] rawData){
        int n = rawData.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            heapifyPrice(rawData, n, i);
        }

        for(int i = n - 1; i > 0; i--){
            String[] temp = rawData[0];
            rawData[0] = rawData[i];
            rawData[i] = temp;

            heapifyPrice(rawData, i, 0);
        }

        return rawData;
    }

    private static void heapifyPrice(String[][] data, int heapSize, int rootIndex){
        int smallest = rootIndex; 
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if(left < heapSize && !(Double.parseDouble(data[left][6]) < Double.parseDouble(data[smallest][6]))){
            smallest = left;
        }

        if(right < heapSize && !(Double.parseDouble(data[right][6]) < Double.parseDouble(data[smallest][6]))){
            smallest = right;
        }

        if(smallest != rootIndex){
            String[] swap = data[rootIndex];
            data[rootIndex] = data[smallest];
            data[smallest] = swap;

            heapifyPrice(data, heapSize, smallest);
        }
    }

    public static String[][] heapSortAchievements(String[][] rawData){
        int n = rawData.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            heapifyAchievements(rawData, n, i);
        }

        for(int i = n - 1; i > 0; i--){
            String[] temp = rawData[0];
            rawData[0] = rawData[i];
            rawData[i] = temp;

            heapifyAchievements(rawData, i, 0);
        }

        return rawData;
    }

    private static void heapifyAchievements(String[][] data, int heapSize, int rootIndex){
        int largest = rootIndex; 
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if(left < heapSize && (MatrixTransformations.safeParseInt(data[left][26]) < MatrixTransformations.safeParseInt(data[largest][26]))){
            largest = left;
        }

        if(right < heapSize && (MatrixTransformations.safeParseInt(data[right][26]) < MatrixTransformations.safeParseInt(data[largest][26]))){
            largest = right;
        }

        if(largest != rootIndex){
            String[] swap = data[rootIndex];
            data[rootIndex] = data[largest];
            data[largest] = swap;

            heapifyAchievements(data, heapSize, largest);
        }
    }


    public static void createCsv_HeapSortReleaseDate_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_heapSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = heapSortReleaseDate(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_heapSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_HeapSortReleaseDate_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_heapSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = heapSortReleaseDate(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_heapSort_melhorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_HeapSortReleaseDate_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_heapSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = heapSortReleaseDate(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_heapSort_piorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   



    public static void createCsv_HeapSortPrice_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_heapSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = heapSortPrice(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_heapSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_HeapSortPrice_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_heapSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = heapSortPrice(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_heapSort_melhorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_HeapSortPrice_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_heapSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = heapSortPrice(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_heapSort_piorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   



    public static void createCsv_HeapSortAchievements_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_heapSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = heapSortAchievements(formatedCsvMatrix);   

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_heapSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_HeapSortAchievements_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_heapSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = heapSortAchievements(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_heapSort_melhorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_HeapSortAchievements_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_heapSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = heapSortAchievements(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_heapSort_piorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   

}
