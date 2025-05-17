package com.faculdadeuepb.computacao.algorithms;

import java.io.IOException;

import com.faculdadeuepb.computacao.model.utils.Date;


public class QuickSort {

    // ---------------------------------------------- ALGORITMOS ----------------------------------------------

    public static String[][] quickSortReleaseDate(String[][] rawData){
        quickSort(rawData, 0, rawData.length - 1);
        return rawData;
    }

    private static void quickSort(String[][] rawData, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(rawData, low, high);
            quickSort(rawData, low, pivotIndex - 1);  // Exclui o pivô
            quickSort(rawData, pivotIndex + 1, high);
        }
    }

    private static int partition(String[][] rawData, int low, int high) {
        String[] pivot = rawData[high];  // Pivô no final
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (Date.checkDateSize(rawData[j][2], pivot[2])) {
                i++;
                swap(rawData, i, j);
            }
        }
        swap(rawData, i + 1, high);
        return i + 1;
    }

    private static void swap(String[][] rawData, int i, int j){
        String[] temp = rawData[i];
        rawData[i] = rawData[j];
        rawData[j] = temp;
    }



    public static String[][] quickSortPrice(String[][] rawData){
        quickSortP(rawData, 0, rawData.length - 1);
        return rawData;
    }

    private static void quickSortP(String[][] rawData, int low, int high){
        if(low < high){
            int pivotIndex = partitionPrice(rawData, low, high);
            quickSortP(rawData, low, pivotIndex);       
            quickSortP(rawData, pivotIndex + 1, high);
        }
    }

    private static int partitionPrice(String[][] rawData, int low, int high){
        String[] pivot = rawData[low]; 
        int left = low - 1;
        int right = high + 1;

        while(true){
            do{
                left++;
            }while(Double.parseDouble(rawData[left][6]) < Double.parseDouble(pivot[6]));

            do{
                right--;
            }while(Double.parseDouble(rawData[right][6]) > Double.parseDouble(pivot[6]));

            if(left >= right){
                return right;
            }

            swap(rawData, left, right);
        }
    }

    public static String[][] quickSortAchievements(String[][] rawData){
        quickSortA(rawData, 0, rawData.length - 1);
        return rawData;
    }

    private static void quickSortA(String[][] rawData, int low, int high){
        if(low < high){
            int pivotIndex = partitionAchievements(rawData, low, high);
            quickSortA(rawData, low, pivotIndex);       
            quickSortA(rawData, pivotIndex + 1, high);
        }
    }

    private static int partitionAchievements(String[][] rawData, int low, int high){
        String[] pivot = rawData[low]; 
        int left = low - 1;
        int right = high + 1;

        while(true){
            do{
                left++;
            }while(MatrixTransformations.safeParseInt(rawData[left][26]) > MatrixTransformations.safeParseInt(pivot[26]));

            do{
                right--;
            }while(MatrixTransformations.safeParseInt(rawData[right][26]) < MatrixTransformations.safeParseInt(pivot[26]));

            if(left >= right){
                return right;
            }

            swap(rawData, left, right);
        }
    }

    public static void createCsv_QuickSortReleaseDate_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_QuickSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortReleaseDate(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_quickSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_QuickSortReleaseDate_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_quickSort_melhorCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortReleaseDate(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_quickSort_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_QuickSortReleaseDate_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_release_date_quickSort_piorCaso.csv'");
        
        // Se o pivô é o último elemento em um array já decrescente, o particionamento falha porque todos os elementos são maiores que ele, gerando chamadas recursivas infinitas e estouro de pilha
        // Por isso não atribui nesse método a matriz ordenada com ordem decrescente, evitando o erro
        
        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortReleaseDate(formatedCsvMatrix);   

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_release_date_quickSort_piorCaso.csv");

        System.out.println("Done");
    }   



    public static void createCsv_QuickSortPrice_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_QuickSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortPrice(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_quickSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_QuickSortPrice_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_quickSort_melhorCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortPrice(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_quickSort_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_QuickSortPrice_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_price_quickSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortPrice(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_price_quickSort_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   


    public static void createCsv_QuickSortAchievements_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_QuickSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortAchievements(formatedCsvMatrix);   

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_quickSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_QuickSortAchievements_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_quickSort_melhorCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortAchievements(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_quickSort_melhorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_QuickSortAchievements_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_quickSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = quickSortAchievements(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_quickSort_piorCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   


}
