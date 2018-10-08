package com.epam.lab.utils.parsers;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvDataParser {
    private static Object[][] data;

    public static Object[][] getData(String filename) {
        try (CSVReader csvReader = new CSVReader(new FileReader(filename))) {
            String[] header = csvReader.readNext();
            List<String[]> dataList = csvReader.readAll();
            data = new Object[dataList.size()][2];
            for (int i = 0; i < dataList.size(); i++) {
                String username = dataList.get(i)[0];
                String password = dataList.get(i)[1];
                data[i][0] = username;
                data[i][1] = password;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}