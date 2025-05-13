package com.faculdadeuepb.computacao.algorithms;

import com.faculdadeuepb.computacao.model.utils.Date;

public class InsertionSort {
    public static String[][] insertionSort(String[][] rawData, int rows){
        
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
}
