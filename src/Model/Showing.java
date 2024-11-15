package Model;

import java.time.LocalTime;

public class Showing extends DataStoreObj {
    private String movie;
    private LocalTime startTime;
    public long getId;

    public Showing(String movie, String startTime) {
        this.movie = movie;
        this.startTime = LocalTime.parse(startTime);
    }

    public String getMovie() {
        return movie;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime);
    }

    @Override
    public String toString() {
        return "Movie: " + movie + ", Start Time: " + startTime.toString();
    }
}
