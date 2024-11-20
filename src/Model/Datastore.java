package Model;

import java.util.ArrayList;
import java.util.List;

public class Datastore {
    private static List<Advertisement> advertisements;
    private static List<Theater> theaters;
    private static List<Movie> movies;
    private static List<Actor> actors;
    private static List<Auditorium> auditoriums;
    private static List<Showing> showings;


    public static void clearData() {
        System.out.println("Clearing 'database'");
        advertisements = new ArrayList<>();
        theaters = new ArrayList<>();
        movies = new ArrayList<>();
        auditoriums = new ArrayList<>();
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

        Movie topGun = getMovieById(1);
        Movie escapeFromNewYork = getMovieById(4);
        Movie halloween = getMovieById(3);
        Movie spinalTap = getMovieById(2);

        showings.add(new Showing("Top Gun", "13:00"));
        showings.add(new Showing("Escape from New York", "16:00"));
        showings.add(new Showing("Halloween", "18:00"));
        showings.add(new Showing("Top Gun", "17:30"));
        showings.add(new Showing("Escape from New York", "19:15"));
        showings.add(new Showing("Spiral Tap", "10:00"));
        showings.add(new Showing("Spiral Tap", "12:45"));
        showings.add(new Showing("Halloween", "23:00"));
    }


    private static void initTheaters() {
        System.out.println("Initializing theaters");
        Theater theater;

        theater = new Theater(1L, "AMC Neshaminy 24", "660 Neshaminy Mall", "Bensalem", "PA", "19020", "(215) 396-8050", "https://www.amctheatres.com/movie-theatres/philadelphia/amc-neshaminy-24");
        theater.addAuditorium(1);
        theater.addAuditorium(2);
        theaters.add(theater);

        theater = new Theater(2L, "Regal UA Oxford Valley", "403 Middletown Blvd", "Langhorne", "PA", "19047", "(844) 462-7342", "https://www.regmovies.com › theatres › regal-ua-oxford-valley");
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

        actors.add(new Actor("Tom","Cruise","(1963-07-03)"));
        actors.add(new Actor("Kelly","McGillis","(1957-07-09)"));
        actors.add(new Actor("Michael","McKean","(1947-10-17)"));
        actors.add(new Actor("Christopher","Guest","(1948-02-05)"));
        actors.add(new Actor("Jaimie Lee","Curtis","(1958-11-22)"));
        actors.add(new Actor("Donald","Pleasence","(1919-10-05)"));
        actors.add(new Actor("Kurt","Russell","(1951-03-17)"));
    }

    private static void initMovies() {
        System.out.println("Initializing movies");

        Movie movie;

        movie = new Movie(1L, "Top Gun", "Fighter pilot Maverick flies a jet.  Goose dies.", Rating.PG, "1986-05-16", (1 * 60 + 50));
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
}
