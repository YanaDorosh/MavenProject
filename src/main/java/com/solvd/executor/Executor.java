package com.solvd.executor;


import com.solvd.dao.IOwner;
import com.solvd.dao.OwnerDAO;
import com.solvd.models.Owner;


import java.util.List;


public class Executor {

    public static void main(String[] args) {

//        MainMenu mainMenu = new MainMenu();
//        mainMenu.choosePlace();

        OwnersClub ownersClub = new OwnersClub();
        //ownersClub.getOwnerById((long) 2);
        ownersClub.getAllOwners();
    }

    public static class OwnersClub{

        private IOwner ownerDAO = new OwnerDAO();

        public List<Owner> getAllOwners(){
            return ownerDAO.getOwner();
        }

        public Owner getOwnerById(Long id) { return ownerDAO.getOwnerById(id); }
       // public void deleteOwnerById(Integer id) { ownerDAO.deleteOwner(id);}

    }

}