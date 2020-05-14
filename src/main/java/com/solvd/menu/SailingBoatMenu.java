package com.solvd.menu;

import com.solvd.placeCollections.Roadstead;
import com.solvd.ships.shipsTypes.civil.SailingBoat;
import com.solvd.utils.ProcessingJson;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SailingBoatMenu {
    private final static Logger LOGGER = Logger.getLogger(SailingBoatMenu.class);
    private ProcessingJson json = new ProcessingJson();
    private MenuMethods methods = new MenuMethods();
    private Scanner sc = new Scanner(System.in);
    private Roadstead roadstead = new Roadstead();
    private MainMenu mainMenu = new MainMenu();
    private int sail;
    private String type;
    private SailingBoat sailingBoat;

    public void chooseAction() {
        methods.chooseAction();
        switch (methods.action) {
            case 1:
                executeMapMenu(roadstead);
                break;
            case 2:
                LOGGER.debug(methods.fileIO.readFromFile(methods.propertiesIO.getValueFromProperties(6)));
                break;
            default:
                LOGGER.info("enter correct number");
                chooseAction();
                break;
        }

    }

    public void chooseWritingFormat() {
        methods.chooseWritingFormat();
        switch (methods.format) {
            case 1:
                methods.fileIO.writeToFile(methods.propertiesIO.getValueFromProperties(1),
                        roadstead.getSailingBoatMap().values());
                break;
            case 2:
                json.convertJavaToJsonFile(roadstead.getSailingBoatMap().values(),
                        methods.propertiesIO.getValueFromProperties(7));
                break;
            case 3:
                mainMenu.choosePlace();
                break;
            default:
                System.out.println("enter correct number");
                chooseWritingFormat();
                break;
        }
    }
    /**
     * A menu for HashMap collection that implements
     * the functions of adding items, deleting and displaying information
     */

    public void executeMenu(Roadstead roadstead) {

        int menu2 = sc.nextInt();
        switch (menu2) {
            case 0:
                executeMapMenu(roadstead);
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 1:
                deletingMap(roadstead);
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 2:
                roadstead.printInfoCollection(roadstead.getSailingBoatMap().values());
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 3:
                chooseWritingFormat();
            case 4:
                convertToJson();
                methods.menuChoice();
                executeMenu(roadstead);
            case 5:
                methods.mainMenu.choosePlace();
                break;
            case 6:
                System.out.println("Thanks for using the application");
                System.exit(0);
                sc.close();
                break;
            default:
                LOGGER.info("enter correct number");
                executeMenu(roadstead);
        }
    }
    /**
     * Method pass objects to collections and re-implement the second menu of choosing actions
     */

    public void executeMapMenu(Roadstead roadstead) {

        methods.loopNumberOfShips();
        for (int i = 1; i <= methods.ships; i++) {
            methods.getInfoMenu();
            createObjectMap(roadstead);
        }
        methods.menuChoice();
        executeMenu(roadstead);
    }

    /**
     * Methods create objects for collections
     */

    public void createObjectMap(Roadstead roadstead) {
        try {
            System.out.print("enter type -               ");
            LOGGER.debug(type = sc.next());
            System.out.print("enter number of sails -    ");
            LOGGER.debug(sail = sc.nextInt());
            System.out.println("___________________________________________________" +
                    "______________________________________________");
        } catch (InputMismatchException e) {
            LOGGER.error("number is incorrect ");
            sail = 0;
            LOGGER.error("Sails:" + sail);
        }
        LOGGER.debug(sailingBoat = new SailingBoat(methods.buoyancy, methods.size, methods.speed, type, sail));
        roadstead.setSailigBoat(sailingBoat);
    }

    /**
     * Methods implement deleting items from collections
     */

    public void deletingMap(Roadstead roadstead) {
        methods.deleteAndCatch();
        roadstead.removeSailingBoat(methods.delete - 1);
    }

    public void convertToJson() {
        String jsonStr = json.convertJavaToJsonStr(roadstead.getSailingBoatMap().values());
        LOGGER.info(jsonStr);
    }
}
