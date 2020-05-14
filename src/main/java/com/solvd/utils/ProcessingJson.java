package com.solvd.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.shipsConstructionCompany.Company;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


public class ProcessingJson {

    private final static Logger LOGGER = Logger.getLogger(ProcessingJson.class);

    public String convertJavaToJsonStr(Object obj) {

        String jsonStr = "";

        try {
            jsonStr = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(obj);
            LOGGER.info("convert to string, finished!");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public void convertJavaToJsonFile(Object obj, String pathToFile) {

        try {
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(Paths.get(pathToFile).toFile(), obj);
            LOGGER.info("write to file, finished!");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Company convertJsonStrToPOJO(String jsonStr) {

        Company company = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            company = mapper.readValue(jsonStr, Company.class);
            LOGGER.info("convert to POJO, finished!");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return company;
    }

    public Company convertCompanyToJavaObject(String path) {

        Company company = null;
        File file = new File(path);

        try {
            ObjectMapper mapper = new ObjectMapper();
            company = mapper.readValue(file, Company.class);
            LOGGER.info("convert from file, finished!");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return company;
    }


}
