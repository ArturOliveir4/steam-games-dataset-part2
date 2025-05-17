package com.faculdadeuepb.computacao.application;

import java.io.IOException;

import com.faculdadeuepb.computacao.algorithms.CountingSort;
import com.faculdadeuepb.computacao.algorithms.HeapSort;
import com.faculdadeuepb.computacao.algorithms.MatrixTransformations;
import com.faculdadeuepb.computacao.algorithms.MergeSort;
import com.faculdadeuepb.computacao.algorithms.QuickSort;
import com.faculdadeuepb.computacao.algorithms.QuickSortMedian;
import com.faculdadeuepb.computacao.model.utils.Transformations;


public class Program {
    public static void main(String[] args) throws IOException {
        Transformations.createFiles();

        String[][] formatedCsvMatrix = MatrixTransformations.csvToMatrix("games_formated_release_data.csv");      
        // String[][] formatedCsvMatrixPartial = MatrixTransformations.csvToMatrixPartial("games_formated_release_data.csv", 0, 1000);  
        
        String[][] formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix); 
	    QuickSortMedian.createCsv_QuickSortMedianReleaseDate_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianReleaseDate_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianReleaseDate_WorstCase(formatedCsvMatrixCopy);


        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianPrice_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianPrice_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianPrice_WorstCase(formatedCsvMatrixCopy);


        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianAchievements_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianAchievements_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianAchievements_WorstCase(formatedCsvMatrixCopy);



        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortReleaseDate_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortReleaseDate_BestCase(formatedCsvMatrixCopy);

        //formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        //QuickSort.createCsv_QuickSortReleaseDate_WorstCase(formatedCsvMatrixCopy);


        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortPrice_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortPrice_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortPrice_WorstCase(formatedCsvMatrixCopy);


        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortAchievements_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortAchievements_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortAchievements_WorstCase(formatedCsvMatrixCopy);


        
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        MergeSort.createCsv_MergeSortAchievements_MediumCase(formatedCsvMatrixCopy);
        
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        MergeSort.createCsv_MergeSortAchievements_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        MergeSort.createCsv_MergeSortAchievements_WorstCase(formatedCsvMatrixCopy);



        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        HeapSort.createCsv_HeapSortAchievements_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        HeapSort.createCsv_HeapSortAchievements_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        HeapSort.createCsv_HeapSortAchievements_WorstCase(formatedCsvMatrixCopy);



        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        CountingSort.createCsv_CountingSortAchievements_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        CountingSort.createCsv_CountingSortAchievements_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        CountingSort.createCsv_CountingSortAchievements_WorstCase(formatedCsvMatrixCopy);


        

        /*
        String[][] formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        MergeSort.createCsv_MergeSortReleaseDate_MediumCase(formatedCsvMatrixCopy);
        
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        MergeSort.createCsv_MergeSortReleaseDate_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        MergeSort.createCsv_MergeSortReleaseDate_WorstCase(formatedCsvMatrixCopy);

        

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        HeapSort.createCsv_HeapSortReleaseDate_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        HeapSort.createCsv_HeapSortReleaseDate_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        HeapSort.createCsv_HeapSortReleaseDate_WorstCase(formatedCsvMatrixCopy);

        */

        /*
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortReleaseDate_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortReleaseDate_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortReleaseDate_WorstCase(formatedCsvMatrixCopy);
        */


        /* 
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianReleaseDate_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianReleaseDate_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianReleaseDate_WorstCase(formatedCsvMatrixCopy);
        */

        
        /*
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        InsertionSort.createCsv_InsertionSortReleaseDate_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        InsertionSort.createCsv_InsertionSortReleaseDate_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        InsertionSort.createCsv_InsertionSortReleaseDate_WorstCase(formatedCsvMatrixCopy);



        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        SelectionSort.createCsv_SelectionSortReleaseDate_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        SelectionSort.createCsv_SelectionSortReleaseDate_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        SelectionSort.createCsv_SelectionSortReleaseDate_WorstCase(formatedCsvMatrixCopy);



        // --------- PRICE ------------


        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        MergeSort.createCsv_MergeSortPrice_MediumCase(formatedCsvMatrixCopy);
        
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        MergeSort.createCsv_MergeSortPrice_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        MergeSort.createCsv_MergeSortPrice_WorstCase(formatedCsvMatrixCopy);



        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        HeapSort.createCsv_HeapSortPrice_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        HeapSort.createCsv_HeapSortPrice_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        HeapSort.createCsv_HeapSortPrice_WorstCase(formatedCsvMatrixCopy);


        /*
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortPrice_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortPrice_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSort.createCsv_QuickSortPrice_WorstCase(formatedCsvMatrixCopy);
         */


        /* 
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianPrice_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianPrice_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        QuickSortMedian.createCsv_QuickSortMedianPrice_WorstCase(formatedCsvMatrixCopy);
        */

        
        /*
        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        InsertionSort.createCsv_InsertionSortPrice_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        InsertionSort.createCsv_InsertionSortPrice_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        InsertionSort.createCsv_InsertionSortPrice_WorstCase(formatedCsvMatrixCopy);



        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        SelectionSort.createCsv_SelectionSortPrice_MediumCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        SelectionSort.createCsv_SelectionSortPrice_BestCase(formatedCsvMatrixCopy);

        formatedCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        SelectionSort.createCsv_SelectionSortPrice_WorstCase(formatedCsvMatrixCopy);
        
        */
        
    }

    public static String[][] deepCopy(String[][] matrix) {
        String[][] copy = new String[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = matrix[i].clone();
        }
        return copy;
    }
}
