package com.faculdadeuepb.computacao.algorithms;

import com.faculdadeuepb.computacao.model.utils.Date;

public class SelectionSort {

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

    
}
