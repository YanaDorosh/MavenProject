package com.solvd.menu;

import com.solvd.placeCollections.Roadstead;
import com.solvd.ships.navy.military.Military;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MilitaryMenu {
    private final static Logger LOGGER = Logger.getLogger(MilitaryMenu.class);
    private MenuMethods methods = new MenuMethods();
    private Scanner sc = new Scanner(System.in);
    private Roadstead roadstead = new Roadstead();
    private MainMenu mainMenu = new MainMenu();
    private Military military;
    private int army;
    private String armament;


    public void chooseAction() {
        methods.chooseAction();
        switch (methods.action) {
            case 1:
                executeArrayMenu(roadstead);
                break;
            case 2:
                LOGGER.debug(methods.fileIO.readFromFile(methods.propertiesIO.getValueFromProperties(4)));
                break;
            default:
                System.out.println("enter correct number");
                chooseAction();
                break;
        }
    }

    /**
     * A menu for ArrayList collection that implements
     * the functions of adding items, deleting and displaying information
     */

    public void executeMenu(Roadstead roadstead) {

        int menu2 = sc.nextInt();
        switch (menu2) {
            case 0:
                executeArrayMenu(roadstead);
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 1:
                deletingArray(roadstead);
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 2:
                roadstead.printInfoCollection(roadstead.getMilitaryList());
                methods.menuChoice();
                executeMenu(roadstead);
                break;
            case 3:
                methods.fileIO.writeToFile( methods.propertiesIO.getValueFromProperties(1),
                        roadstead.getMilitaryList());
            case 4:
                methods.mainMenu.choosePlace();
                break;
            case 5:
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

    public void executeArrayMenu(Roadstead roadstead) {
        methods.loopNumberOfShips();
        for (int i = 1; i <= methods.ships; i++) {
            methods.getInfoMenu();
            createObjectArray(roadstead);
        }
        methods.menuChoice();
        executeMenu(roadstead);
    }

    /**
     * Methods create objects for collections
     */

    public void createObjectArray(Roadstead roadstead) {
        try {
            System.out.print("Enter army -               ");
            LOGGER.debug(army = sc.nextInt());
        } catch (InputMismatchException e) {
            army = 0;
            armament = "0 ";
            LOGGER.error("Army: " + army + " ");
            LOGGER.error("Armament: " + armament);
        }
        System.out.print("Enter armament -           ");
        LOGGER.debug(armament = sc.next());
        System.out.println("___________________________________________________" +
                "______________________________________________");
        LOGGER.debug(military = new Military(methods.buoyancy, methods.size, methods.speed, army, armament));
        roadstead.setMilitary(military);

    }

    /**
     * Methods implement deleting items from collections
     */

    public void deletingArray(Roadstead roadstead) {
        methods.deleteAndCatch();
        roadstead.removeMilitary(methods.delete - 1);
    }

}
