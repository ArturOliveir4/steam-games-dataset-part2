package com.faculdadeuepb.computacao.application;

import java.io.IOException;

import com.faculdadeuepb.computacao.model.utils.MatrixTransformations;
import com.faculdadeuepb.computacao.model.utils.Transformations;


public class Program {
    public static void main(String[] args) throws IOException {
        Transformations.createFiles();

        // Convertendo o arquivo games_formated_realease_data.csv em uma matriz
        String[][] formatedCsvMatrix = MatrixTransformations.csvToMatrix("games_formated_release_data.csv");

        String[][] formatetCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        // Ordenando a matriz (Merge Sort / Caso médio) e criando o arquivo .csv
        MatrixTransformations.createCsv_MergeSortReleaseDate_MediumCase(formatetCsvMatrixCopy);

        formatetCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        // Ordenando a matriz (Selection Sort / Caso médio) e criando o arquivo .csv
        MatrixTransformations.createCsv_SelectionSortReleaseDate_MediumCase(formatetCsvMatrixCopy);

        formatetCsvMatrixCopy = deepCopy(formatedCsvMatrix);
        // Ordenando a matriz (Insertion Sort / Caso médio) e criando o arquivo .csv
        MatrixTransformations.createCsv_InsertionSortReleaseDate_MediumCase(formatetCsvMatrixCopy);


    }

    public static String[][] deepCopy(String[][] matrix) {
        String[][] copy = new String[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = matrix[i].clone();
        }
        return copy;
    }
}
