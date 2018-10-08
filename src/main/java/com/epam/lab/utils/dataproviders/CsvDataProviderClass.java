package com.epam.lab.utils.dataproviders;

import com.epam.lab.utils.parsers.CsvDataParser;
import org.testng.annotations.DataProvider;

import static com.epam.lab.utils.Constants.CSV_FILE_PATH;

public class CsvDataProviderClass {
    @DataProvider(name = "csvDataProvider", parallel = true)
    public static Object[][] getDataFromCSV() {
        return CsvDataParser.getData(CSV_FILE_PATH);
    }
}