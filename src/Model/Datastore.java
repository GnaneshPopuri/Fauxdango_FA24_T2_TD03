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

        auditoriums.add(new Auditorium(1));
        auditoriums.add(new Auditorium(2));
        auditoriums.add(new Auditorium(3));
        auditoriums.add(new Auditorium(4));
    }

    private static void initShowings() {
        System.out.println("Initializing showings");

        showings.add(new Showing(1, "Top Gun", "AMC Neshaminy 24", 1, Rating.PG, 110, "13:00"));
        showings.add(new Showing(2, "Escape from New York", "Regal UA Oxford Valley", 2, Rating.R, 99, "16:00"));
        showings.add(new Showing(3, "Halloween", "AMC Neshaminy 24", 1, Rating.R, 91, "18:00"));
        showings.add(new Showing(4, "Top Gun", "AMC Neshaminy 24", 1, Rating.PG, 110, "17:30"));
        showings.add(new Showing(5, "Escape from New York", "Regal UA Oxford Valley", 2, Rating.R, 99, "19:15"));
        showings.add(new Showing(6, "This Is Spinal Tap", "AMC Neshaminy 24", 1, Rating.R, 84, "10:00"));
        showings.add(new Showing(7, "This Is Spinal Tap", "AMC Neshaminy 24", 1, Rating.R, 84, "12:45"));
        showings.add(new Showing(8, "Halloween", "AMC Neshaminy 24", 1, Rating.R, 91, "23:00"));
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

        movies.add(new Movie.Builder()
                .withId(1L)
                .withTitle("Top Gun")
                .withDescription("Fighter pilot Maverick flies a jet. Goose dies.")
                .withRating(Rating.PG)
                .withReleaseDate("1986-05-16")
                .withRunningTimeMinutes(110)
                .addActor(getActorById(1L))
                .addActor(getActorById(2L))
                .addGenre(Genre.ACTION)
                .addGenre(Genre.DRAMA)
                .build());

        movies.add(new Movie.Builder()
                .withId(2L)
                .withTitle("This Is Spinal Tap")
                .withDescription("Spinal Tap, is chronicled by film director Marty DiBergi.")
                .withRating(Rating.R)
                .withReleaseDate("1984-03-02")
                .withRunningTimeMinutes(84)
                .addActor(getActorById(3L))
                .addActor(getActorById(4L))
                .addGenre(Genre.COMEDY)
                .addGenre(Genre.DOCUMENTARY)
                .build());
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

    public static Showing getShowingById(long id) {
        for (Showing showing : showings) {
            if (showing.getId() == id) {
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
