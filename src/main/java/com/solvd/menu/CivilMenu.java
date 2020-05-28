package com.solvd.menu;

import com.solvd.db.InformationToBD;
import com.solvd.placeCollections.Roadstead;
import com.solvd.ships.shipsTypes.civil.Civil;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.solvd.utils.ProcessingJson;
import org.apache.log4j.Logger;


public class CivilMenu {

    private final static Logger LOGGER = Logger.getLogger(CivilMenu.class);
    private ProcessingJson json = new ProcessingJson();
    private MenuMethods methods = new MenuMethods();
    private Scanner sc = new Scanner(System.in);
    private Roadstead roadstead = new Roadstead();
    private MainMenu mainMenu;
    private String classification;
    private Civil civil;
    private InformationToBD toBD = new InformationToBD();

    public void chooseAction() {
        methods.chooseAction(civil);
        switch (methods.action) {
            case 1:
                executeLinkedMenu(roadstead);
                mainMenu.choosePlace();
                break;
            case 2:
                LOGGER.debug(methods.fileIO.readFromFile(methods.propertiesIO.getValueFromProperties(2)));
                mainMenu.choosePlace();
                break;
            case 3:
                toBD.CreateTableCivil();
                mainMenu.choosePlace();
                break;
            default:
                LOGGER.info("enter correct number");
                chooseAction();
                break;
        }
    }
    public void chooseWritingFormat(){
        methods.chooseWritingFormat();
        switch (methods.format) {
            case 1:
                methods.fileIO.writeToFile(methods.propertiesIO.getValueFromProperties(1),
                        roadstead.getlinkedListCivils());
                break;
            case 2:
                json.convertJavaToJsonFile(roadstead.getlinkedListCivils(),
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

    public void convertToJson() {
        String jsonStr = json.convertJavaToJsonStr(roadstead.getlinkedListCivils());
        LOGGER.info(jsonStr);
    }

}
