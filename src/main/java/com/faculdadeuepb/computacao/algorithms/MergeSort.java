package com.faculdadeuepb.computacao.algorithms;

import java.util.Arrays;

import com.faculdadeuepb.computacao.model.utils.Date;

public class MergeSort {

    public static String[][] mergeSort(String[][] dataArray, int rows) {
        if(rows <= 1){
            return dataArray;
        }
        int middle = rows / 2;

        String[][] left = Arrays.copyOfRange(dataArray, 0, middle);
        String[][] right = Arrays.copyOfRange(dataArray, middle, rows);

        left = mergeSort(left, left.length);
        right = mergeSort(right, right.length);

        return merge(left, right);
    }

    private static String[][] merge(String[][] left, String[][] right) {

        int leftSize = left.length;
        int rightSize = right.length;
        String[][] result = new String[leftSize + rightSize][];
    
        int i = 0, j = 0, k = 0;
    
        while (i < leftSize && j < rightSize) {
            if (Date.checkDateSize(left[i][2], right[j][2])) {
                result[k++] = left[i++];
            } else {
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
}
