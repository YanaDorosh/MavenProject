package com.solvd.utils;

import com.solvd.menu.CivilMenu;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Scanner;

public class FileIO {
    private final static Logger LOGGER = Logger.getLogger(FileIO.class);
    public String readFromFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()){
                LOGGER.info("File is created!");
            }else{
                LOGGER.info("File already exists.");
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                LOGGER.info(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } finally {
            scanner.close();
        }
        return "default";

    }

    public void writeToFile(String path, Collection<?> value) {

        File file = new File(path);
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (Object list: value){
                printWriter.println(list);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
    }
    }

    public void writeToFile(String path, String value) {

        File file = new File(path);
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(value);
            printWriter.close();
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
