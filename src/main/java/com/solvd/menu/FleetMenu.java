package com.solvd.menu;

import com.solvd.placeCollections.Fleet;
import com.solvd.placeCollections.Roadstead;
import com.solvd.ships.shipsTypes.military.Military;
import com.solvd.ships.shipsTypes.military.Submarine;
import com.solvd.utils.ProcessingJson;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FleetMenu {
    private final static Logger LOGGER = Logger.getLogger(FleetMenu.class);
    private ProcessingJson json = new ProcessingJson();
    private MenuMethods methods = new MenuMethods();
    private MainMenu mainMenu = new MainMenu();
    private Fleet fleet = new Fleet();
    private Scanner sc = new Scanner(System.in);
    private Military military;
    private Submarine submarine;
    private int army;
    private String armament;


    /**
     * A menu for ArrayList collection that implements
     * the functions of adding items, deleting and displaying information
     */
    public void chooseAction() {
        methods.chooseAction();
        switch (methods.action) {
            case 1:
                executeFleetMenu(fleet);
                mainMenu.choosePlace();
                break;
            case 2:
                if (mainMenu.militaryShip == 1)
                    LOGGER.debug(methods.fileIO.readFromFile(methods.propertiesIO.getValueFromProperties(4)));
                else {
                    LOGGER.debug(methods.fileIO.readFromFile(methods.propertiesIO.getValueFromProperties(5)));
                }
                mainMenu.choosePlace();
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
                if (mainMenu.militaryShip == 1) {
                    methods.fileIO.writeToFile(methods.propertiesIO.getValueFromProperties(1),
                            fleet.getMilitaryList());
                } else {
                    methods.fileIO.writeToFile(methods.propertiesIO.getValueFromProperties(1),
                            fleet.getSubmarineList());
                }
                break;
            case 2:
                if (mainMenu.militaryShip == 1) {
                    json.convertJavaToJsonFile(fleet.getMilitaryList(),
                            methods.propertiesIO.getValueFromProperties(7));
                } else {
                    json.convertJavaToJsonFile(fleet.getSubmarineList(),
                            methods.propertiesIO.getValueFromProperties(7));
                }
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

    public void executeMenu(Fleet fleet) {
        int menu = sc.nextInt();
        switch (menu) {
            case 0:
                executeFleetMenu(fleet);
                methods.menuChoice();
                executeMenu(fleet);
                break;
            case 1:
                deletingArray(fleet);
                methods.menuChoice();
                executeMenu(fleet);
                break;
            case 2:
                if (mainMenu.militaryShip == 1) {
                    fleet.printInfoColection(fleet.getMilitaryList());
                } else {
                    fleet.printInfoColection(fleet.getSubmarineList());
                }
                methods.menuChoice();
                executeMenu(fleet);
                break;
            case 3:
                chooseWritingFormat();
            case 4:
                convertToJson();
                methods.menuChoice();
                executeMenu(fleet);
                break;
            case 5:
                System.out.println("Thanks for using the application");
                System.exit(0);
                sc.close();
                break;
            default:
                LOGGER.info("enter correct number");
                executeMenu(fleet);
        }

    }

    /**
     * Method pass objects to collections and re-implement the second menu of choosing actions
     */

    public void executeFleetMenu(Fleet fleet) {
        methods.loopNumberOfShips();
        for (int i = 1; i <= methods.ships; i++) {
            methods.getInfoMenu();
            createObjectArray(fleet);
        }
        methods.menuChoice();
        executeMenu(fleet);
    }

    /**
     * Methods create objects for collections
     */

    public void createObjectArray(Fleet fleet) {
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

        if (mainMenu.militaryShip == 1) {
            LOGGER.debug(military = new Military(methods.buoyancy, methods.size, methods.speed, army, armament));
            fleet.setMilitary(military);
        } else {
            LOGGER.debug(submarine = new Submarine(methods.buoyancy, methods.size, methods.speed, army, armament));
            fleet.setSubmarine(submarine);
        }

    }

    /**
     * Methods implement deleting items from collections
     */

    public void deletingArray(Fleet fleet) {
        methods.deleteAndCatch();
        if (mainMenu.militaryShip == 1) {
            fleet.removeMilitary(methods.delete - 1);
        } else {
            fleet.removeSubmarine(methods.delete - 1);
        }
    }

    public void executeArrayMenu2(Roadstead roadstead) {
        methods.loopNumberOfShips();
        for (int i = 1; i <= methods.ships; i++) {
            methods.getInfoMenu();
            createObjectArray(fleet);
        }
        methods.menuChoice();
        executeMenu(fleet);
    }

    public void convertToJson() {
        if (mainMenu.militaryShip == 1) {
            String jsonStr = json.convertJavaToJsonStr(fleet.getMilitaryList());
            LOGGER.info(jsonStr);
        } else {
            String jsonStr = json.convertJavaToJsonStr(fleet.getSubmarineList());
            LOGGER.info(jsonStr);
        }

    }
}
