package com.faculdadeuepb.computacao.model.utils;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class Transformations {

    public static void transformDateFormat() throws IOException {

        File games = new File("games.csv");
        File gamesFormatedDate = new File("games_formated_release_data.csv");

        CSVParser csvParser = CSVCreate.initializeCSVParser(games);
        CSVPrinter csvPrinter = CSVCreate.initializeCSVPrinter(gamesFormatedDate, csvParser);

        for (CSVRecord record : csvParser) {
            String[] row = new String[record.size()];

            for (int i = 0; i < record.size(); i++) {
                row[i] = record.get(i);
            }

            // Assuming "release date" is in position 2
            row[2] = Date.convertDate(record.get("Release date"));

            csvPrinter.printRecord((Object[]) row);
        }
        csvPrinter.flush();

    }

    public static void transformPortugueseAndLinux() throws IOException {

        File gamesFormatedDate = new File("games_formated_release_data.csv");
        File gamesFormatedSupportLinux = new File("games_linux.csv");
        File gamesFormatedSupportPortuguese = new File("portuguese_supported_games.csv");
        CSVParser csvParser = CSVCreate.initializeCSVParser(gamesFormatedDate);
        CSVPrinter csvPrinterLinux = CSVCreate.initializeCSVPrinter(gamesFormatedSupportLinux, csvParser);
        CSVPrinter csvPrinterPortuguese = CSVCreate.initializeCSVPrinter(gamesFormatedSupportPortuguese, csvParser);

        for (CSVRecord record : csvParser) {

            boolean linuxSupport = Boolean.parseBoolean(record.get(19));
            if (linuxSupport) {
                csvPrinterLinux.printRecord(record);
            }

            String line = record.get(10);
            if (line != null && !line.trim().isEmpty()) {
                String cleanedLanguages = line.replaceAll("[\\[\\]']", "").trim();
                String[] languages = cleanedLanguages.split("\\s*,\\s*");
                for (String language : languages) {
                    if ("Portuguese - Brazil".equalsIgnoreCase(language)) {
                        csvPrinterPortuguese.printRecord(record);
                        break;
                    }
                }
            }
        }

        csvPrinterLinux.flush();
        csvPrinterPortuguese.flush();

    }

    public static void createFiles() {

        try {
            System.out.println("Generating 'games_formated_release_data.csv'");
            transformDateFormat();
            System.out.println("Done\n");

            System.out.println("Generating 'portuguese_supported_games.csv' and 'games_linux.csv' files.");
            transformPortugueseAndLinux();
            System.out.println("Done\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}