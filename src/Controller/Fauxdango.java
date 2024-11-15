package Controller;

import Model.*;
import View.ConsoleDisplay.AdvertisementDisplay;
import View.ConsoleDisplay.UserDisplay;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

public class Fauxdango {
    Menu menuMain = new Menu("Fauxdango");
    MenuChoice choiceMainRegister = menuMain.addMenuChoice("Register");
    MenuChoice choiceMainListAllMovies = menuMain.addMenuChoice("List All Movies");
    MenuChoice choiceMainListAllTheaters = menuMain.addMenuChoice("List All Theaters");
    MenuChoice choiceMainExit = menuMain.getMenuChoiceQuit();

    public void demo() {

        MenuDisplay md = new MenuDisplay(menuMain);
        AdvertisementBank adBank = new AdvertisementBank();

        AdvertisementDisplay adDisplay = new AdvertisementDisplay(adBank);

        User user;
        MenuChoice chosen = null;
        while (chosen != choiceMainExit) {
            adDisplay.displayNextAd();
            chosen = md.displayAndChoose();

            if (chosen == choiceMainRegister) {
                user = UserDisplay.registerUser();
                System.out.println();
                System.out.println("Welcome, " + user.toString());
            } else if (chosen == choiceMainListAllMovies) {
                for (Movie movie : Datastore.getMovies()) {
                    System.out.println(movie.toString());
                }
            } else if (chosen == choiceMainListAllTheaters) {
                for (Theater theater : Datastore.getTheaters()) {
                    System.out.println(theater.toString());
                }
            } else if (chosen == choiceMainExit) {
                System.out.println("Goodbye");
            }

        }

    }
}
