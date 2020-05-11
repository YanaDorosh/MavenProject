package com.solvd.menu;

import com.solvd.placeCollections.Roadstead;
import com.solvd.ships.civil.Civil;


import java.util.Scanner;
import org.apache.log4j.Logger;


public class CivilMenu {

    private final static Logger LOGGER = Logger.getLogger(CivilMenu.class);
    private MenuMethods methods = new MenuMethods();
    private Scanner sc = new Scanner(System.in);
    private Roadstead roadstead = new Roadstead();
    private MainMenu mainMenu;
    private String classification;
    private Civil civil;

    public void chooseAction() {
        methods.chooseAction();
        switch (methods.action) {
            case 1:
                executeLinkedMenu(roadstead);
                break;
            case 2:
                LOGGER.debug(methods.fileIO.readFromFile(methods.propertiesIO.getValueFromProperties(2)));
                break;
            default:
                LOGGER.info("enter correct number");
                chooseAction();
                break;
        }
    }


    /**
     * A menu for LinkedList collection that implements
     * the functions of adding items, deleting and displaying information
     */

    public void executeMenu(Roadstead roadstead) {
        int menu2 = sc.nextInt();
        switch (menu2) {
            case 0:
                executeLinkedMenu(roadstead);
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 1:
                deletingLinked(roadstead);
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 2:
                roadstead.printInfoCollection(roadstead.getlinkedListCivils());
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 3:
                methods.fileIO.writeToFile(methods.propertiesIO.getValueFromProperties(1),
                        roadstead.getlinkedListCivils());
            case 4:
                methods.mainMenu.choosePlace();
                break;
            case 5:
                System.out.println("Thanks for using the application");
                System.exit(0);
                break;
            default:
                LOGGER.info("enter correct number");
                executeMenu(roadstead);
                sc.close();
        }

    }

    /**
     * Method pass objects to collections and re-implement the second menu of choosing actions
     */

    public void executeLinkedMenu(Roadstead roadstead) {
        methods.loopNumberOfShips();
        for (int i = 1; i <= methods.ships; i++) {
            methods.getInfoMenu();
            createObjectLinked(roadstead);
        }
        methods.menuChoice();
        executeMenu(roadstead);
    }

    /**
     * Methods create objects for collections
     */

    public void createObjectLinked(Roadstead roadstead) {
        System.out.print("enter the classification - ");
        LOGGER.debug(classification = sc.next());
        System.out.println("___________________________________________________" +
                "______________________________________________");
        LOGGER.debug(civil = new Civil(methods.buoyancy, methods.size, methods.speed, classification));
        roadstead.setCivil(civil);
    }

    /**
     * Methods implement deleting items from collections
     */

    public void deletingLinked(Roadstead roadstead) {
        roadstead.removeCivil(methods.delete - 1);
    }

}
