package com.solvd.db;

import org.apache.log4j.Logger;

import java.sql.*;

public class InformationFromBD {

    private final static Logger LOGGER = Logger.getLogger(InformationFromBD.class);
    private Connector connector = new Connector();

    public void viewTable() {
        try {
            Statement statement = null;
            statement = connector.connect_BD().createStatement();

            ResultSet result = statement.executeQuery(
                    "SELECT ships.name, data, speed, size, owner.name AS owner\n" +
                            "FROM Ships LEFT JOIN owner on (ships.owner_id=owner.id)");

            LOGGER.debug("Deduce information from database");
            while (result.next()) {
                System.out.println(result.getString("name")
                        + "\t" + result.getString("data")
                        + "\t" + result.getString("speed")
                        + "\t" + result.getString("size")
                        + "\t" + result.getString("owner"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());

        } finally {
            if (connector.connection != null) {
                try {
                    connector.connection.close();
                } catch (SQLException e) {
                    e.getStackTrace();
                    LOGGER.error(e.getMessage());
                }
            }

        }
    }

}


