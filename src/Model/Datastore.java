package Model;

import java.util.ArrayList;
import java.util.List;

import static Model.Rating.PG;
import static Model.Rating.R;

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
    }

    private static void initShowings() {
    }


    private static void initTheaters() {
        System.out.println("Initializing theaters");
        Theater theater;

        theater = new Theater(1L, "AMC Neshaminy 24", "660 Neshaminy Mall", "Bensalem", "PA", "19020", "(215) 396-8050", "https://www.amctheatres.com/movie-theatres/philadelphia/amc-neshaminy-24");
        theaters.add(theater);

        theater = new Theater(2L, "Regal UA Oxford Valley", "403 Middletown Blvd", "Langhorne", "PA", "19047", "(844) 462-7342", "https://www.regmovies.com › theatres › regal-ua-oxford-valley");
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
    }

    private static void initMovies() {
        System.out.println("Initializing movies");

        Movie movie;

        movie = new Movie(1L, "Top Gun", "Fighter pilot Maverick flies a jet.  Goose dies.", PG, "1986-05-16", (1 * 60 + 50));
        movies.add(movie);

        movie = new Movie(2L, "This Is Spinal Tap", "Spinal Tap, is chronicled by film director Marty DiBergi", R, "1984-03-02", 84);
        movies.add(movie);

        movie = new Movie(3L, "Halloween", "Michael Meyers kills people", R, "1978-10-05", 91);
        movies.add(movie);

        movie = new Movie(4L, "Escape from New York", "Snake Plissken rescues the president", R, "1981-07-10", 99);
        movies.add(movie);
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


        return null;
    }

    public static Theater getTheaterById(long id) {


        return null;
    }

    public static Showing getShowingById(long id) {


        return null;
    }

}
