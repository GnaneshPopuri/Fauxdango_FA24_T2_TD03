package Controller;

import Model.*;
import Util.IOHelper;
import View.ConsoleDisplay.AdvertisementDisplay;
import View.ConsoleDisplay.UserDisplay;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

import java.util.List;

public class Fauxdango {
    Menu menuMain = new Menu("Fauxdango");
    MenuChoice choiceMainRegister = menuMain.addMenuChoice("Register");
    MenuChoice choiceMainListAllMovies = menuMain.addMenuChoice("List All Movies");
    MenuChoice choiceMainListAllTheaters = menuMain.addMenuChoice("List All Theaters");
    MenuChoice choiceMainListAllActors = menuMain.addMenuChoice("List All Actors");
    MenuChoice choiceMainListAllShowings = menuMain.addMenuChoice("List All Showings");
    MenuChoice choiceMainSearchTheatersByName = menuMain.addMenuChoice("Search Theaters by Name");
    MenuChoice choiceMainSearchMoviesByTitle = menuMain.addMenuChoice("Search Movies By Title");
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
            } else if (chosen == choiceMainListAllActors) {
                for (Actor actor : Datastore.getActors()) {
                    System.out.println(actor.toString());
                }
            } else if (chosen == choiceMainListAllShowings) {
                for (Showing showing : Datastore.getShowings()) {
                    System.out.println(showing.toString());
                }
            } else if (chosen == choiceMainSearchTheatersByName) {
                String searchText = IOHelper.readNonBlankStringFromKeyboard("Enter part of the name");
                List<Theater> searchResults = Datastore.searchTheatersByName(searchText);

            } else if (chosen == choiceMainSearchMoviesByTitle) {
                String searchText = IOHelper.readNonBlankStringFromKeyboard("Enter part of the title");
                List<Movie> searchResults = Datastore.searchMoviesByTitle(searchText);
                // Print moves
                searchResults.forEach(movie -> System.out.println(movie.toString()));
                searchResults.forEach(theater -> System.out.println(theater.toString()));
            } else if (chosen == choiceMainExit) {
                System.out.println("Goodbye");
            }
        }
    }
}
