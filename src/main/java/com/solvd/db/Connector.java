package com.solvd.db;

import com.solvd.utils.PropertiesIO;
import org.apache.log4j.Logger;

import java.sql.*;

public class Connector {

    private final static Logger LOGGER = Logger.getLogger(Connector.class);
    private PropertiesIO propertiesIO = new PropertiesIO();
    protected Connection connection;


    /**
     * Method that loads the specified driver, loads the data to connection with database from properties
     *
     * @return connection
     **/

    public Connection connect_BD() {
        try {
            Class.forName("org.postgresql.Driver");
            LOGGER.debug("Driver connected");
            connection = DriverManager.getConnection(propertiesIO.getValueForBD("url"),
                    propertiesIO.getValueForBD("user"),
                    propertiesIO.getValueForBD("password"));
            LOGGER.debug("Database connected");
        } catch (Exception e) {
            LOGGER.error("Database Connection Creation Failed :"+ e.getStackTrace());
        }
        return connection;
    }

}

