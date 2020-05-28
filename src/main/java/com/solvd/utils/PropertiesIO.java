package com.solvd.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesIO {

    private static String separator = File.separator;
    private static String PATH = "src" + separator + "main" + separator + "java" + separator +
            "com" + separator + "solvd" + separator + "res" + separator + "files" + separator +
            "path" + separator + "path.properties";
    private final static Logger LOGGER = Logger.getLogger(PropertiesIO.class);

    public String getValueFromProperties(int key) {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(PATH);
            properties.load(inputStream);
            inputStream.close();
            return properties.getProperty(String.valueOf(key));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return "default";
    }

    public String getValueForBD(String key) {
        String PATH_BD = "db" + separator + "db.properties";
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(PATH_BD);
            properties.load(inputStream);
            inputStream.close();
            return properties.getProperty(key);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return "default";
    }

    public void setValueToProperties(int key, String value) {
        Properties properties = new Properties();
        try {
            FileOutputStream outputStream = new FileOutputStream(PATH);
            properties.setProperty(String.valueOf(key), String.valueOf(value));
            properties.store(outputStream, "");
            outputStream.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

    }
}
