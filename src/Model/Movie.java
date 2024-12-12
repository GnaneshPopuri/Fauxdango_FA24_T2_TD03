package Model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Movie extends DataStoreObj {
    private final String title;
    private final String description;
    private final Rating rating;
    private final LocalDate releaseDate;
    private final Duration runningTime;
    private final List<Actor> actors;
    private final List<Genre> genres;

    // TODO: Modify Movie so that it uses the Builder pattern

    private Movie(Builder builder) {
        super(builder.id);
        this.title = builder.title;
        this.description = builder.description;
        this.rating = builder.rating;
        this.releaseDate = builder.releaseDate;
        this.runningTime = builder.runningTime;
        this.actors = builder.actors;
        this.genres = builder.genres;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Rating getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    @Override
    public String toString() {
        int runningTimeMinutes = (int) this.getRunningTime().toMinutes();
        String genreList = genres.stream()
                .map(Genre::name)  // Using the enum's name method
                .collect(Collectors.joining(", "));
        return String.format("%s (%s, %d) [%s] {%d min}", this.title, this.rating, this.releaseDate.getYear(), genreList, runningTimeMinutes);
    }



    // Builder Class
    public static class Builder {
        private Long id;
        private String title;
        private String description;
        private Rating rating;
        private LocalDate releaseDate;
        private Duration runningTime;
        private final List<Actor> actors = new ArrayList<>();
        private final List<Genre> genres = new ArrayList<>();

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withRating(Rating rating) {
            this.rating = rating;
            return this;
        }

        public Builder withReleaseDate(String releaseDate) {
            this.releaseDate = LocalDate.parse(releaseDate);
            return this;
        }

        public Builder withRunningTimeMinutes(int runningTimeMinutes) {
            this.runningTime = Duration.ofMinutes(runningTimeMinutes);
            return this;
        }

        public Builder addActor(Actor actor) {
            this.actors.add(actor);
            return this;
        }

        public Builder addGenre(Genre genre) {
            this.genres.add(genre);
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}