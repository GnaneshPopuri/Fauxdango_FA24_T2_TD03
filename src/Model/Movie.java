package Model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie extends DataStoreObj {
    private final String title;
    private final Rating rating;
    private final LocalDate releaseDate;
    private final Duration runningTime;
    private final List<Actor> actors;

    public Movie(Long id, String title, Rating rating, String releaseDate, int runningTimeMinutes) {
        super(id);
        this.title = title;
        this.rating = rating;
        this.releaseDate = LocalDate.parse(releaseDate);
        this.runningTime = Duration.ofMinutes(runningTimeMinutes);
        this.actors = new ArrayList<>();
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
