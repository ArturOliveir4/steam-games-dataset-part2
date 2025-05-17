package com.faculdadeuepb.computacao.algorithms;

import java.io.IOException;

public class CountingSort{

    public static String[][] countingSortAchievements(String[][] rawData) {
        int rows = rawData.length;
        if (rows == 0) return rawData;

        int max = MatrixTransformations.safeParseInt(rawData[0][26]);
        for(int i = 1; i < rows; i++){
            int val = MatrixTransformations.safeParseInt(rawData[i][26]);
            if(val > max){
                max = val;
            }
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < rows; i++) {
            int val = MatrixTransformations.safeParseInt(rawData[i][26]);
            count[val]++;
        }

        int[] position = new int[max + 1];
        int total = 0;
        for(int i = max; i >= 0; i--){
            position[i] = total;
            total += count[i];
        }

        String[][] sorted = new String[rows][];
        for(int i = 0; i < rows; i++){
            int val = MatrixTransformations.safeParseInt(rawData[i][26]);
            int pos = position[val];
            sorted[pos] = rawData[i];
            position[val]++;
        }

        return sorted;
    }



    public static void createCsv_CountingSortAchievements_MediumCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_countingSort_medioCaso.csv'");
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = countingSortAchievements(formatedCsvMatrix);   

        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_countingSort_medioCaso.csv");

        System.out.println("Done\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

   
    
    public static void createCsv_CountingSortAchievements_BestCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_countingSort_melhorCaso.csv'");
        
        // Ordenando previamente a matriz (MELHOR CASO)
        MatrixTransformations.orderJava_Data_Crescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = countingSortAchievements(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_countingSort_melhorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }

    
    public static void createCsv_CountingSortAchievements_WorstCase(String[][] formatedCsvMatrix) throws IOException{  
        System.out.println("\nGenerating 'games_achievements_countingSort_piorCaso.csv'");
        
        // Ordenando previamente a matriz (PIOR CASO)
        MatrixTransformations.orderJava_Data_Descrescente(formatedCsvMatrix);

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

        long start = System.nanoTime();

        // Ordenando a matriz passada por parâmetro    
        formatedCsvMatrix = countingSortAchievements(formatedCsvMatrix);   


        long end = System.nanoTime();
        long duration = end - start; 

        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long memoriaUsada = memoriaDepois - memoriaAntes;

        // Criando de fato o arquivo .csv
        MatrixTransformations.createCsv(formatedCsvMatrix, "games_achievements_countingSort_piorCaso.csv");

        System.out.println("\nDone\nAverage execution time : " + duration + " ns\nMemory used on average: " + memoriaUsada + " bytes");
    }   
}
