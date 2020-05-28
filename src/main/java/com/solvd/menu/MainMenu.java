package com.solvd.menu;

import com.solvd.db.InformationFromBD;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private final static Logger LOGGER = Logger.getLogger(MainMenu.class);
    protected static int militaryShip;
    private Scanner sc = new Scanner(System.in);
    private InformationFromBD information = new InformationFromBD();

    public void choosePlace() {
        MenuMethods methods = new MenuMethods();
        try {
            System.out.println("Choose a place:  ");
            System.out.println("Fleet:___________________1");
            System.out.println("Port:____________________2");
            System.out.println("Company:_________________3");
            System.out.println("Display a list of ships:_4");
            System.out.println("5<--------------------Exit");
            int place = sc.nextInt();
            switch (place) {
                case 1:
                    chooseFleetShip();
                case 2:
                    chooseRoadstead();
                    break;
                case 3:
                    methods.showCompany();
                    choosePlace();
                    break;
                case 4:
                    information.viewTable();
                    choosePlace();
                    break;
                case 5:
                    System.exit(0);
                default:
                    LOGGER.info("Please choose correct number");
                    choosePlace();
                    break;
            }
        } catch (InputMismatchException e) {
            LOGGER.error("Please choose correct number");
        } finally {
            System.out.println("================================================================================");
            LOGGER.info("Work completed!!!");
            sc.close();
        }
    }

    public void chooseFleetShip() {
        FleetMenu fleetMenu = new FleetMenu();
        try {
            System.out.println("Choose a ship:");
            System.out.println("Military ship:  1");
            System.out.println("Submarine:      2");
            System.out.println("3<------Main menu");
            LOGGER.debug(militaryShip = sc.nextInt());
            switch (militaryShip) {
                case (1):
                    fleetMenu.chooseAction();
                    break;
                case (2):
                    fleetMenu.chooseAction();
                    break;
                case 3:
                    choosePlace();
                    break;
                default:
                    LOGGER.info("Please choose correct number");
                    choosePlace();
                    break;
            }
        } catch (InputMismatchException e) {
            LOGGER.error("Please choose correct number");
            choosePlace();
        }
    }

    public void chooseRoadstead() {
        MilitaryMenu militaryMenu = new MilitaryMenu();
        SailingBoatMenu sailingMenu = new SailingBoatMenu();
        CivilMenu civilMenu = new CivilMenu();
        FishingMenu fishingMenu = new FishingMenu();
        try {
            System.out.println("Enter number for choosing ship:");
            System.out.println("0:        military");
            System.out.println("1:        civilian");
            System.out.println("2:         fishing");
            System.out.println("3:    sailing boat");
            System.out.println("Main menu------->4");
            System.out.println("Exit------------>5");

            int collection = sc.nextInt();
            switch (collection) {
                case 0:
                    militaryMenu.chooseAction();
                    break;
                case 1:
                    civilMenu.chooseAction();
                    break;
                case 2:
                    fishingMenu.chooseAction();
                    break;
                case 3:
                    sailingMenu.chooseAction();
                    break;
                case 4:
                    choosePlace();
                    break;
                case 5:
                    System.exit(0);
                default:
                    LOGGER.info("number is incorrect");
                    chooseRoadstead();
                    break;
            }
        } catch (InputMismatchException e) {
            LOGGER.error("Please choose correct number");
            choosePlace();
        }

    }
}
