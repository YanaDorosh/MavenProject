package com.solvd.placeCollections;

import com.solvd.ships.Boat;
import com.solvd.ships.shipsTypes.military.Military;
import com.solvd.ships.shipsTypes.military.Submarine;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Fleet {
    private final static Logger LOGGER = Logger.getLogger(Fleet.class);
    List<Military> militaryList = new ArrayList<>();
    List<Submarine> submarineList = new ArrayList<>();

    public Fleet() {

    }

    public void printInfoColection(Collection<?> list) {
        for (Object ls : list) {
            LOGGER.info(ls.toString());
        }
    }

    public void setMilitary(Military military) {
        militaryList.add(military);
    }

    public void removeMilitary(int index) {
        LOGGER.debug(militaryList.remove(index));
    }

    public List<Military> getMilitaryList() {
        Boat.countNumeration();
        return militaryList;
    }

    public void setSubmarine(Submarine submarine) {
        submarineList.add(submarine);
    }

    public void removeSubmarine(int index) {
        LOGGER.debug(submarineList.remove(index));
    }

    public List<Submarine> getSubmarineList() {
        Boat.countNumeration();
        return submarineList;
    }
}
