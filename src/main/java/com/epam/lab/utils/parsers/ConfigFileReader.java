package com.epam.lab.utils.parsers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.epam.lab.utils.Constants.PROPERTY_FILE_PATH;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH));
            properties = new Properties();
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + PROPERTY_FILE_PATH);
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driver.path");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String timeout = properties.getProperty("wait.timeout");
        if (timeout != null) return Long.parseLong(timeout);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getWebSiteUrl() {
        String gmailUrl = properties.getProperty("gmail.url");
        if (gmailUrl != null) return gmailUrl;
        else throw new RuntimeException("GmailUrl not specified in the Configuration.properties file.");
    }
}