package Model;

import java.util.ArrayList;
import java.util.List;

import static Model.Rating.PG;
import static Model.Rating.R;


public class Datastore {
    private static final List<Advertisement> advertisements = new ArrayList<>();
    private static final List<Theater> theaters = new ArrayList<>();
    private static final List<Movie> movies = new ArrayList<>();
    private static final List<Actor> actors = new ArrayList<>();
    private static final List<Auditorium> auditoriums = new ArrayList<>();
    private static final List<Showing> showings = new ArrayList<>();

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

        // Add showings to the auditoriums
        auditorium1.addShowing(getShowingById(1));
        auditorium1.addShowing(getShowingById(2));

        auditorium2.addShowing(getShowingById(3));
        auditorium2.addShowing(getShowingById(4));

        auditoriums.add(auditorium1);
        auditoriums.add(auditorium2);
    }

    private static void initShowings() {
        System.out.println("Initializing showings");

        showings.add(new Showing(1, "Top Gun", "ACTION, DRAMA", 110, Rating.PG, 1986, "13:00"));
        showings.add(new Showing(2, "Escape from New York", "ACTION", 99, Rating.R, 1981, "16:00"));
        showings.add(new Showing(3, "Halloween", "HORROR", 91, Rating.R, 1978, "18:00"));
        showings.add(new Showing(4, "Top Gun", "ACTION, DRAMA", 110, Rating.PG, 1986, "17:30"));
        showings.add(new Showing(5, "Escape from New York", "ACTION", 99, Rating.R, 1981, "19:15"));
        showings.add(new Showing(6, "This Is Spinal Tap", "COMEDY, DOCUMENTARY", 84, Rating.R, 1984, "10:00"));
        showings.add(new Showing(7, "This Is Spinal Tap", "COMEDY, DOCUMENTARY", 84, Rating.R, 1984, "12:45"));
        showings.add(new Showing(8, "Halloween", "HORROR", 91, Rating.R, 1978, "23:00"));
    }

    public static Showing getShowingById(long id) {
        for (Showing showing : showings) {
            if (showing.getId() == id) {
                return showing;
            }
        }
        return null;
    }


    private static void initTheaters() {
        System.out.println("Initializing theaters");

        Theater theater1 = new Theater(1L, "AMC Neshaminy 24", "660 Neshaminy Mall", "Bensalem", "PA", "19020", "(215) 396-8050", "https://www.amctheatres.com/movie-theatres/philadelphia/amc-neshaminy-24");
        theater1.addAuditorium(1);
        theater1.addAuditorium(2);

        Theater theater2 = new Theater(2L, "Regal UA Oxford Valley", "403 Middletown Blvd", "Langhorne", "PA", "19047", "(844) 462-7342", "https://www.regmovies.com");
        theater2.addAuditorium(3);
        theater2.addAuditorium(4);

        theaters.add(theater1);
        theaters.add(theater2);
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

        Movie topGun = new Movie.Builder()
                .withId(1L)
                .withTitle("Top Gun")
                .withDescription("Fighter pilot Maverick flies a jet. Goose dies.")
                .withRating(Rating.PG)
                .withReleaseDate("1986-05-16")
                .withRunningTimeMinutes(110)
                .addActor(getActorById(1L)) // Tom Cruise
                .addActor(getActorById(2L)) // Kelly McGillis
                .addGenre(Genre.ACTION)
                .addGenre(Genre.DRAMA)
                .build();

        Movie spinalTap = new Movie.Builder()
                .withId(2L)
                .withTitle("This Is Spinal Tap")
                .withDescription("Spinal Tap is chronicled by film director Marty DiBergi.")
                .withRating(Rating.R)
                .withReleaseDate("1984-03-02")
                .withRunningTimeMinutes(84)
                .addActor(getActorById(3L)) // Michael McKean
                .addActor(getActorById(4L)) // Christopher Guest
                .addGenre(Genre.COMEDY)
                .addGenre(Genre.DOCUMENTARY)
                .build();

        Movie halloween = new Movie.Builder()
                .withId(3L)
                .withTitle("Halloween")
                .withDescription("Michael Myers terrorizes a small town.")
                .withRating(Rating.R)
                .withReleaseDate("1978-10-25")
                .withRunningTimeMinutes(91)
                .addActor(getActorById(5L)) // Jamie Lee Curtis
                .addActor(getActorById(6L)) // Donald Pleasence
                .addGenre(Genre.HORROR)
                .build();

        Movie escapeFromNewYork = new Movie.Builder()
                .withId(4L)
                .withTitle("Escape from New York")
                .withDescription("Snake Plissken must rescue the president.")
                .withRating(Rating.R)
                .withReleaseDate("1981-07-10")
                .withRunningTimeMinutes(99)
                .addActor(getActorById(6L)) // Donald Pleasence
                .addActor(getActorById(7L)) // Kurt Russell
                .addGenre(Genre.ACTION)
                .build();

        // Add all movies to the datastore
        movies.add(topGun);
        movies.add(spinalTap);
        movies.add(halloween);
        movies.add(escapeFromNewYork);
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
    /**
     * Retrieves a {@code Movie} object from the list of movies based on the specified ID.
     *
     * <p>This method iterates through the collection of {@code Movie} objects and returns the first
     * instance whose primary key matches the provided ID. If no match is found, it returns {@code null}.
     * </p>
     *
     * @param id the primary key of the movie to be retrieved
     * @return the {@code Movie} object with the specified ID, or {@code null} if no such movie exists
     * @author Ildar Sadykov
     * @author Diane Mathew (dmm7029@psu.edu)
     */
    // TODO: Create JavaDoc for getMovieById method
    public static Movie getMovieById(long id) {
        for (Movie movie : movies) {
            if (movie.getPrimaryKey() == id) {
                return movie;
            }
        }
        return null;
    }
    /**
     * Retrieves an {@code Actor} object from the list of actors based on the specified ID.
     *
     * <p>This method iterates through the collection of {@code Actor} objects and returns the first
     * instance whose primary key matches the provided ID. If no match is found, it returns {@code null}.
     * </p>
     *
     * @param id the primary key of the actor to be retrieved
     * @return the {@code Actor} object with the specified ID, or {@code null} if no such actor exists
     * @author Ildar Sadaykov
     * @author Diane Mathew (dmm7029@psu.edu)
     */
    // TODO: Create JavaDoc for getActorById method
    public static Actor getActorById(long id) {
        for (Actor actor : actors) {
            if (actor.getPrimaryKey() == id) {
                return actor;
            }
        }
        return null;
    }

    public static Auditorium getAuditoriumById(long id) { for (Auditorium auditorium : auditoriums) { if (auditorium.getAuditoriumNumber() == id)
    { return auditorium; }
    } return null; }

    public static Theater getTheaterById(long id) {
        for (Theater theater : theaters) {
            if (theater.getId() == id) {
                return theater;
            }
        }
        return null;
    }





    // TODO: Add tests to show that searchTheatersByName works correctly
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
    // TODO: Add test to show searchMoviesByTitle works correctly
    public static List<Movie> searchMoviesByTitle(String text) {
        List<Movie> searchResults = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(text.toLowerCase())) {
                searchResults.add(movie);
            }
        }
        return searchResults;

    }
    // TODO: Add test to show searchActorsByName works correctly
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
    // TODO: Add tests to show that searchTheatersByZipcode works correctly
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
