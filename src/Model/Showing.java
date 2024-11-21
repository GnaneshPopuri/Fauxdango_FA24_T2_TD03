package Model;

import java.time.LocalTime;

public class Showing extends DataStoreObj {
    private String movie;
    private String genre;
    private int duration;
    private Rating rating;
    private int year;
    private LocalTime startTime;
    private long id;

    public Showing(String movie, String genre, int duration, Rating rating, int year, String startTime) {
        this.movie = movie;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.year = year;
        this.startTime = LocalTime.parse(startTime);
    }

    public String getMovie() {
        return movie;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public Rating getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        // Assuming the rating has toString() defined like "PG"
        return String.format("%s (%s, %d) [%s] {%d min} {%s-%s}",
                movie, rating, year, genre, duration,
                startTime, startTime.plusMinutes(duration));
    }
}
