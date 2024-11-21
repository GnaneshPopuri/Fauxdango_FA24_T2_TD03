package Model;

import java.util.ArrayList;
import java.util.List;

public class Datastore {
    private static List<Advertisement> advertisements = new ArrayList<>();
    private static List<Theater> theaters = new ArrayList<>();
    private static List<Movie> movies = new ArrayList<>();
    private static List<Actor> actors = new ArrayList<>();
    private static List<Auditorium> auditoriums = new ArrayList<>();
    private static List<Showing> showings = new ArrayList<>();

    public static void clearData() {
        System.out.println("Clearing 'database'");
        advertisements.clear();
        theaters.clear();
        movies.clear();
        actors.clear();
        auditoriums.clear();
        showings.clear();
    }

    public static void populateData() {
        System.out.println("Populating 'database'");
        initAdvertisements();
        initActors();
        initMovies();
        initShowings();
        initAuditoriums();
        initTheaters();
    }

    public static void resetData() {
        clearData();
        populateData();
    }

    static {
        resetData();
    }

    private static void initAuditoriums() {
        System.out.println("Initializing auditoriums");

        Auditorium auditorium1 = new Auditorium(1);
        Auditorium auditorium2 = new Auditorium(2);
        Auditorium auditorium3 = new Auditorium(3);
        Auditorium auditorium4 = new Auditorium(4);

        auditoriums.add(auditorium1);
        auditoriums.add(auditorium2);
        auditoriums.add(auditorium3);
        auditoriums.add(auditorium4);
    }

    private static void initShowings() {
        System.out.println("Initializing showings");

        showings.add(new Showing("Top Gun", "13:00"));
        showings.add(new Showing("Escape from New York", "16:00"));
        showings.add(new Showing("Halloween", "18:00"));
        showings.add(new Showing("Top Gun", "17:30"));
        showings.add(new Showing("Escape from New York", "19:15"));
        showings.add(new Showing("Spinal Tap", "10:00"));
        showings.add(new Showing("Spinal Tap", "12:45"));
        showings.add(new Showing("Halloween", "23:00"));
    }

    private static void initTheaters() {
        System.out.println("Initializing theaters");

        Theater theater;

        theater = new Theater(1L, "AMC Neshaminy 24", "660 Neshaminy Mall", "Bensalem", "PA", "19020", "(215) 396-8050", "https://www.amctheatres.com/movie-theatres/philadelphia/amc-neshaminy-24");
        theater.addAuditorium(1);
        theater.addAuditorium(2);
        theaters.add(theater);

        theater = new Theater(2L, "Regal UA Oxford Valley", "403 Middletown Blvd", "Langhorne", "PA", "19047", "(844) 462-7342", "https://www.regmovies.com");
        theater.addAuditorium(3);
        theater.addAuditorium(4);
        theaters.add(theater);
    }

    private static void initAdvertisements() {
        System.out.println("Initializing advertisements");
        advertisements.add(new Advertisement("Drink Pepsi"));
        advertisements.add(new Advertisement("Buy Candy"));
        advertisements.add(new Advertisement("Shop at Target"));
        advertisements.add(new Advertisement("Watch NCIS"));
    }

    private static void initActors() {
        System.out.println("Initializing actors");

        actors.add(new Actor(1L, "Tom", "Cruise", "1963-07-03"));
        actors.add(new Actor(2L, "Kelly", "McGillis", "1957-07-09"));
        actors.add(new Actor(3L, "Michael", "McKean", "1947-10-17"));
        actors.add(new Actor(4L, "Christopher", "Guest", "1948-02-05"));
        actors.add(new Actor(5L, "Jamie Lee", "Curtis", "1958-11-22"));
        actors.add(new Actor(6L, "Donald", "Pleasence", "1919-10-05"));
        actors.add(new Actor(7L, "Kurt", "Russell", "1951-03-17"));
    }


    private static void initMovies() {
        System.out.println("Initializing movies");

        Movie movie;

        movie = new Movie(1L, "Top Gun", "Fighter pilot Maverick flies a jet. Goose dies.", Rating.PG, "1986-05-16", (1 * 60 + 50));
        movie.addActor(1);
        movie.addActor(2);
        movies.add(movie);

        movie = new Movie(2L, "This Is Spinal Tap", "Spinal Tap, is chronicled by film director Marty DiBergi", Rating.R, "1984-03-02", 84);
        movie.addActor(3);
        movie.addActor(4);
        movies.add(movie);

        movie = new Movie(3L, "Halloween", "Michael Meyers kills people", Rating.R, "1978-10-05", 91);
        movie.addActor(5);
        movie.addActor(6);
        movies.add(movie);

        movie = new Movie(4L, "Escape from New York", "Snake Plissken rescues the president", Rating.R, "1981-07-10", 99);
        movie.addActor(6);
        movie.addActor(7);
        movies.add(movie);
    }

    public static List<Showing> getShowings() {
        return showings;
    }

    public static List<Advertisement> getAllAdvertisements() {
        return advertisements;
    }

    public static List<Movie> getMovies() {
        return movies;
    }

    public static List<Actor> getActors() {
        return actors;
    }

    public static List<Theater> getTheaters() {
        return theaters;
    }


    public static Movie getMovieById(long id) {
        for (Movie movie : movies) {
            if (movie.getPrimaryKey() == id) {
                return movie;
            }
        }
        return null;
    }

    public static Actor getActorById(long id) {
        for (Actor actor : actors) {
            if (actor.getPrimaryKey() == id) {
                return actor;
            }
        }
        return null;
    }

    public static Auditorium getAuditoriumById(long id) {
        for (Auditorium auditorium : auditoriums) {
            if (auditorium.getPrimaryKey() == id) {
                return auditorium;
            }
        }
        return null;
    }

    public static Theater getTheaterById(long id) {


        return null;
    }

    public static Showing getShowingById(long id) {
        for (Showing showing : showings) {
            if (showing.getId == id) {
                return showing;
            }
        }
        return null;
    }
    public static List<Theater> searchTheatersByName(String text) {
        List<Theater> searchResults = new ArrayList<>();
        String searchTextLower = text.toLowerCase();
        for (Theater theater : theaters) {
            if (theater.getName().toLowerCase().contains(searchTextLower)) {
                searchResults.add(theater);
            }
        }
        return searchResults;
    }
    public static List<Movie> searchMoviesByTitle(String text) {
        List<Movie> searchResults = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(text.toLowerCase())) {
                searchResults.add(movie);
            }
        }
        return searchResults;

    }
    public static List<Actor> searchActorsByName(String text) {
        List<Actor> searchResults = new ArrayList<>();
        String searchTextLower = text.toLowerCase();


        for (Actor actor : actors) {
            String fullName = actor.getFirstName() + " " + actor.getLastName();
            if (fullName.toLowerCase().contains(searchTextLower)) {
                searchResults.add(actor);
            }
        }
        return searchResults;
    }

    public static List<Theater> searchTheatersByZipcode(String text) {
        List<Theater> searchResults = new ArrayList<>();
        for (Theater theater : theaters) {
            if (theater.getZipcode().equals(text)) {
                searchResults.add(theater);
            }
        }
        return searchResults;
    }
}
