package Model;

import java.time.LocalTime;

public class Showing extends DataStoreObj {
    private final String movie;
    private final String genre;
    private final int duration;
    private final Rating rating;
    private final int year;
    private final LocalTime startTime;
    private int id;

    public Showing(String movie, String genre, int duration, Rating rating, int year, String startTime) {
        this.movie = movie;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.year = year;
        this.startTime = LocalTime.parse(startTime);
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s (%s, %d) [%s] {%d min} {%s-%s}",
                movie, rating, year, genre, duration,
                startTime, startTime.plusMinutes(duration));
    }
}
