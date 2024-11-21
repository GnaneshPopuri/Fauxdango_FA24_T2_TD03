package Controller;

import Model.*;
import View.ConsoleDisplay.AdvertisementDisplay;
import View.ConsoleDisplay.UserDisplay;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

import java.util.List;
import java.util.Scanner;

public class Fauxdango {
    Menu menuMain = new Menu("Fauxdango");
    MenuChoice choiceMainRegister = menuMain.addMenuChoice("Register");
    MenuChoice choiceMainListAllMovies = menuMain.addMenuChoice("List All Movies");
    MenuChoice choiceMainListAllTheaters = menuMain.addMenuChoice("List All Theaters");
    MenuChoice choiceMainListAllActors = menuMain.addMenuChoice("List All Actors");
    MenuChoice choiceMainListAllShowings = menuMain.addMenuChoice("List All Showings");
    MenuChoice choiceSearchActorsByName = menuMain.addMenuChoice("Search Actors By Name");
    MenuChoice choiceSearchTheatersByName = menuMain.addMenuChoice("Search Theaters By Name");
    MenuChoice choiceSearchTheatersByZipcode = menuMain.addMenuChoice("Search Theaters By Zipcode");
    MenuChoice choiceSearchMoviesByTitle = menuMain.addMenuChoice("Search Movies By Title");
    MenuChoice choiceMainExit = menuMain.getMenuChoiceQuit();

    public void demo() {
        MenuDisplay md = new MenuDisplay(menuMain);
        AdvertisementBank adBank;

        try {
            adBank = new AdvertisementBank();
        } catch (IllegalStateException e) {
            System.err.println("Failed to initialize advertisements: " + e.getMessage());
            return;
        }

        AdvertisementDisplay adDisplay = new AdvertisementDisplay(adBank);
        Scanner scanner = new Scanner(System.in);

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
            } else if (chosen == choiceSearchActorsByName) {
                searchEntities("actor's name", scanner, Datastore::searchActorsByName);
            } else if (chosen == choiceSearchTheatersByName) {
                searchEntities("theater's name", scanner, Datastore::searchTheatersByName);
            } else if (chosen == choiceSearchTheatersByZipcode) {
                searchEntities("zipcode", scanner, Datastore::searchTheatersByZipcode);
            } else if (chosen == choiceSearchMoviesByTitle) {
                searchEntities("movie title", scanner, Datastore::searchMoviesByTitle);
            } else if (chosen == choiceMainExit) {
                System.out.println("Goodbye");
            }
        }
    }

    private void searchEntities(String searchType, Scanner scanner, SearchFunction searchFunction) {
        System.out.print("Enter part of the " + searchType + ": ");
        String searchTerm = scanner.nextLine().trim();
        while (searchTerm.isEmpty()) {
            System.out.println("Cannot be blank");
            System.out.print("Enter " + searchType + ": ");
            searchTerm = scanner.nextLine().trim();
        }

        boolean found = false;
        for (Object result : searchFunction.search(searchTerm)) {
            System.out.println(result.toString());
            found = true;
        }

        if (!found) {
            System.out.println("No results found.");
        }
    }

    @FunctionalInterface
    interface SearchFunction {
        List<?> search(String searchTerm);
    }
}

