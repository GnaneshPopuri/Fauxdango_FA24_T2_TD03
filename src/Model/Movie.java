package Model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Movie extends DataStoreObj {
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Duration runningTime;

    public Movie(String title, String description, String releaseDate, int runningTimeMinutes) {
        this(null, title, description, releaseDate, runningTimeMinutes);
    }

    public Movie(Long id, String title, String description, String releaseDate, int runningTimeMinutes) {
        super(id);
        this.title = title;
        this.description = description;
        this.releaseDate = LocalDate.parse(releaseDate);
        // https://stackoverflow.com/a/41800301/673393
        this.runningTime = Duration.ofMinutes(runningTimeMinutes);
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
        return String.format("%s (%s) [%s min]", this.title, this.releaseDate.getYear(), runningTimeMinutes);
    }

}
