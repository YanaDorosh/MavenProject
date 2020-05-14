package com.solvd.menu;

import com.solvd.ships.myException.BouyancyException;
import com.solvd.ships.myException.SizeException;
import com.solvd.ships.myException.SpeedException;
import com.solvd.shipsConstructionCompany.Company;
import com.solvd.utils.FileIO;
import com.solvd.utils.ProcessingJson;
import com.solvd.utils.PropertiesIO;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuMethods {

    private final static Logger LOGGER = Logger.getLogger(MenuMethods.class);
    protected int action;
    protected int format;
    protected double buoyancy;
    protected int size;
    protected int speed;
    protected int ships;
    private Scanner sc = new Scanner(System.in);
    protected MainMenu mainMenu = new MainMenu();
    protected int delete;
    private int minSize = 3;
    protected PropertiesIO propertiesIO = new PropertiesIO();
    protected FileIO fileIO = new FileIO();

    /**
     * Gets a common of information for all classes
     */

    public void getInfoMenu() {
        try {
            System.out.print("Enter the buoyancy -       ");
            LOGGER.debug(buoyancy = sc.nextDouble());
            if (buoyancy < 0.23 | buoyancy > 0.98) {
                throw new BouyancyException();
            }
        } catch (InputMismatchException | BouyancyException e) {
            buoyancy = 0.24;
            LOGGER.error("   Buoyancy: " + buoyancy);
            LOGGER.error(e.getMessage());
        }
        try {
            System.out.print("Enter size -               ");
            LOGGER.debug(size = sc.nextInt());
            if (size <= minSize) {
                throw new SizeException();
            }
        } catch (InputMismatchException | SizeException e) {
            size = 4;
            LOGGER.error("   Size: " + size);
            LOGGER.error(e.getMessage());
        }
        try {
            System.out.print("Enter speed -              ");
            LOGGER.debug(speed = sc.nextInt());
            if (speed >= 300 | speed <= 30) {
                throw new SpeedException();
            }

        } catch (InputMismatchException | SpeedException e) {
            speed = 35;
            LOGGER.error("   Speed: " + speed);
            LOGGER.error(e.getMessage());

        }
    }

    /**
     * The method checks number for deleting.
     * Here checks two types mistakes in the moment of entering
     */

    public void loopNumberOfShips() {
        try {
            do {
                System.out.println("enter number of ships");
                LOGGER.debug(ships = sc.nextInt());
            }
            while (ships <= 0);
        } catch (InputMismatchException e) {
            LOGGER.error("Please enter a number");
            mainMenu.chooseRoadstead();
        }

    }

    public void deleteAndCatch() {
        try {
            LOGGER.info("for deleting enter number of element");
            LOGGER.debug(delete = sc.nextInt());
        } catch (InputMismatchException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * The method displays an action selection menu
     */

    public void menuChoice() {
        System.out.println("________________________________________________________________");
        System.out.println("0: add information; 1: delete element; 2: display the collection");
        System.out.println("3: write to file; 4:show json;--->5:change type of ship; 6: exit");
    }

    public void chooseAction() {
        try {
            System.out.println("Choose an action:");
            System.out.println("add information________1");
            System.out.println("read from file:________2");
            LOGGER.debug(action = sc.nextInt());
        } catch (InputMismatchException e) {
            LOGGER.error("Please choose correct number");
            mainMenu.choosePlace();
        }
    }

    public void chooseWritingFormat() {
        try {
            System.out.println("Choose format:");
            System.out.println("write to file ________1");
            System.out.println("write to json:________2");
            System.out.println("3<------------Main menu");
            LOGGER.debug(format = sc.nextInt());
        } catch (InputMismatchException e) {
            LOGGER.error("Please choose correct number");
            mainMenu.choosePlace();
        }
    }

    public void showCompany() {
        ProcessingJson json = new ProcessingJson();
        Company company;
        company = json.convertCompanyToJavaObject((propertiesIO.getValueFromProperties(8)));
        System.out.println("_________________________________________________________");
        System.out.println("Company:       " + company.getCompanyName());
        System.out.println("Ship's name:   " + company.getDryCargo().getName());
        System.out.println("Operator:      " + company.getDryCargo().getOperator());
        System.out.println("Year:          " + company.getDryCargo().getYear());
        System.out.println("IMO number:    " + company.getDryCargo().getImo_number());
        System.out.println("_________________________________________________________");
        LOGGER.debug("get company from file");
    }
}
