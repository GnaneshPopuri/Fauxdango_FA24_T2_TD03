package Model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Movie extends DataStoreObj {
    private String title;
    private String description;
    private Rating rating;
    private LocalDate releaseDate;
    private Duration runningTime;

    public Movie(String title, String description, Rating rating, String releaseDate, int runningTimeMinutes) {
        this(null, title, description, rating, releaseDate, runningTimeMinutes);
    }

    public Movie(Long id, String title, String description, Rating rating, String releaseDate, int runningTimeMinutes) {
        super(id);
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.releaseDate = LocalDate.parse(releaseDate);
        // https://stackoverflow.com/a/41800301/673393
        this.runningTime = Duration.ofMinutes(runningTimeMinutes);
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
        return null;  // Change this to return the actors
    }

    public String toString() {
        int runningTimeMinutes = (int) this.getRunningTime().getSeconds() / 60;
        return String.format("%s (%s, %s) [%s min]", this.title, this.rating, this.releaseDate.getYear(), runningTimeMinutes);
    }
}
