package com.solvd.menu;

import com.solvd.placeCollections.Roadstead;
import com.solvd.ships.shipsTypes.civil.service.servicetype.Fishing;
import com.solvd.utils.ProcessingJson;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FishingMenu {
    private final static Logger LOGGER = Logger.getLogger(FishingMenu.class);
    private ProcessingJson json = new ProcessingJson();
    private MenuMethods methods = new MenuMethods();
    private Scanner sc = new Scanner(System.in);
    private Roadstead roadstead = new Roadstead();
    private MainMenu mainMenu = new MainMenu();
    private Fishing fishing;
    private String classification;
    private int ton;


    public void chooseAction() {
        methods.chooseAction();
        switch (methods.action) {
            case 1:
                executeSetMenu(roadstead);
                break;
            case 2:
                LOGGER.debug(methods.fileIO.readFromFile(methods.propertiesIO.getValueFromProperties(3)));
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
                        roadstead.getFishingSet());
                break;
            case 2:
                json.convertJavaToJsonFile(roadstead.getFishingSet(),
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
     * A menu for HashSet collection that implements
     * the functions of adding items, deleting and displaying information
     */

    public void executeMenu(Roadstead roadstead) {

        int menu2 = sc.nextInt();
        switch (menu2) {
            case 0:
                executeSetMenu(roadstead);
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 1:
                deletingSet(roadstead);
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 2:
                roadstead.printInfoCollection(roadstead.getFishingSet());
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

    public void executeSetMenu(Roadstead roadstead) {

        methods.loopNumberOfShips();
        for (int i = 1; i <= methods.ships; i++) {
            methods.getInfoMenu();
            createObjectSet(roadstead);
        }
        methods.menuChoice();
        executeMenu(roadstead);
    }

    /**
     * Methods create objects for collections
     */

    public void createObjectSet(Roadstead roadstead) {
        System.out.print("enter the classification - ");
        LOGGER.debug(classification = sc.next());
        try {
            System.out.print("enter ton -                ");
            LOGGER.debug(ton = sc.nextInt());
        } catch (InputMismatchException e) {
            LOGGER.error("number is incorrect");
            ton = 0;
            LOGGER.error("Ton: 2" + ton);
        }
        System.out.println("___________________________________________________" +
                "______________________________________________");
        LOGGER.debug(fishing = new Fishing(methods.buoyancy, methods.size, methods.speed, classification, ton));
        roadstead.setFishingSet(fishing);

    }

    /**
     * Methods implement deleting items from collections
     */

    public void deletingSet(Roadstead roadstead) {
        methods.deleteAndCatch();
        roadstead.removeFishing(methods.delete - 1);
    }

    public void convertToJson() {
        String jsonStr = json.convertJavaToJsonStr(roadstead.getFishingSet());
        LOGGER.info(jsonStr);
    }
}
