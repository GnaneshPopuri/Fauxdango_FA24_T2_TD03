package Controller;

import Model.*;
import View.ConsoleDisplay.AdvertisementDisplay;
import View.ConsoleDisplay.UserDisplay;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

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
        AdvertisementBank adBank = new AdvertisementBank();
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
                System.out.print("Enter actor's name: ");
                String actorName = scanner.nextLine().toLowerCase();
                for (Actor actor : Datastore.getActors()) {
                    if (actor.getName().toLowerCase().contains(actorName)) {
                        System.out.println(actor.toString());
                    }
                }
            } else if (chosen == choiceSearchTheatersByName) {
                System.out.print("Enter theater's name: ");
                String theaterName = scanner.nextLine().toLowerCase();
                for (Theater theater : Datastore.getTheaters()) {
                    if (theater.getName().toLowerCase().contains(theaterName)) {
                        System.out.println(theater.toString());
                    }
                }
            } else if (chosen == choiceSearchTheatersByZipcode) {
                System.out.print("Enter theater's zipcode: ");
                String zipcode = scanner.nextLine();
                for (Theater theater : Datastore.getTheaters()) {
                    if (theater.getZipcode().equals(zipcode)) {
                        System.out.println(theater.toString());
                    }
                }
            } else if (chosen == choiceSearchMoviesByTitle) {
                System.out.print("Enter movie title: ");
                String movieTitle = scanner.nextLine().toLowerCase();
                for (Movie movie : Datastore.getMovies()) {
                    if (movie.getTitle().toLowerCase().contains(movieTitle)) {
                        System.out.println(movie.toString());
                    }
                }
            } else if (chosen == choiceMainExit) {
                System.out.println("Goodbye");
            }
        }
    }
}

