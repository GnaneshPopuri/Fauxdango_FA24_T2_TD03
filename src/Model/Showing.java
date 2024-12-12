package Model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Showing extends DataStoreObj {
    private final String movie;
    private final String genre;
    private final int duration;
    private final Rating rating;
    private final int year;
    private final LocalTime startTime;
    private final int id;

    public Showing(int id, String movie, String genre, int duration, Rating rating, int year, String startTime) {
        this.id = id;
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
        String endTimeFormatted = startTime.plusMinutes(duration).format(DateTimeFormatter.ofPattern("HH:mm"));
        return String.format("%s (%s, %d) [%s] {%d min} {%s-%s}",
                movie, rating, year, genre, duration,
                startTime.format(DateTimeFormatter.ofPattern("HH:mm")), endTimeFormatted);
    }

}
