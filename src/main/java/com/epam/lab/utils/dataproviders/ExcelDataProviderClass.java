package com.epam.lab.utils.dataproviders;

import com.epam.lab.utils.parsers.ExcelDataParser;
import org.testng.annotations.DataProvider;

import static com.epam.lab.utils.Constants.EXCEL_FILE_PATH;
import static com.epam.lab.utils.Constants.EXCEL_SHEET_NAME;

public class ExcelDataProviderClass {

    @DataProvider(name = "ExcelDataProvider", parallel = true)
    public Object[][] getExcelData() {
        return ExcelDataParser.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME);
    }
}