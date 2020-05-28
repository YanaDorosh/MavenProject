package com.solvd.db;

import com.solvd.ships.shipsTypes.civil.Civil;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;

public class InformationToBD {
    private final static Logger LOGGER = Logger.getLogger(InformationToBD.class);
    private Connector connector = new Connector();
    private Civil civil;

    public void CreateTableCivil() {
        Statement statement = null;
        try {
            statement = connector.connect_BD().createStatement();
            statement.executeUpdate("DROP TABLE Civil");
            LOGGER.debug("Deleted table");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Civil " +
                    "(id SERIAL, buoyancy FLOAT NOT NULL, size INT NOT NULL," +
                    "speed INT  NOT NULL, classification VARCHAR (50) NOT NULL," +
                    "engine VARCHAR (50) NOT NULL)");
            LOGGER.debug("Created new table");
            statement.executeUpdate("INSERT INTO Civil (buoyancy, size, speed , classification, engine)" +
                    "VALUES (0.58, 135, 235, 'Cross-channel', 'electricity')," +
                    " (0.59, 145, 255, 'Cruising_yachts', 'electricity')," +
                    " (0.68, 355, 155, 'Recreational_boats', 'diesel engine')");
            LOGGER.info("Data was added to database");
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
