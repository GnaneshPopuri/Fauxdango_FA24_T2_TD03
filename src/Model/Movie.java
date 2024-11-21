package Model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie extends DataStoreObj {
    private String title;
    private String description;
    private Rating rating;
    private LocalDate releaseDate;
    private Duration runningTime;
    private List<Actor> actors;
    private List<Genre> genres;

    public Movie(String title, String description, Rating rating, String releaseDate, int runningTimeMinutes) {
        this(null, title, description, rating, releaseDate, runningTimeMinutes);
    }

    public Movie(Long id, String title, String description, Rating rating, String releaseDate, int runningTimeMinutes) {
        super(id);
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.releaseDate = LocalDate.parse(releaseDate);
        this.runningTime = Duration.ofMinutes(runningTimeMinutes);
        this.actors = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    public Rating getRating() {
        return rating;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<Genre> getGenres() {
        return genres; // Getter for genres
    }


    public void addActor(long actorId) {
        Actor actor = Datastore.getActorById(actorId);
        if (actor != null) {
            actors.add(actor);
        } else {
            throw new IllegalArgumentException("Actor with ID " + actorId + " not found.");
        }
    }

    @Override
    public String toString() {
        int runningTimeMinutes = (int) this.getRunningTime().getSeconds() / 60;
        return String.format("%s (%s, %s) [%s min]", this.title, this.rating, this.releaseDate.getYear(), runningTimeMinutes);
    }
}
