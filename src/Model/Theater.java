package Model;

import java.util.ArrayList;
import java.util.List;

public class Theater extends DataStoreObj {
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String website;

    private List<Auditorium> auditoriums;

    public Theater(String name, String streetAddress, String city, String state, String zipCode, String phoneNumber, String website) {
        this(null, name, streetAddress, city, state, zipCode, phoneNumber, website);

    }

    public Theater(Long id, String name, String streetAddress, String city, String state, String zipCode, String phoneNumber, String website) {
        super(id);
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.auditoriums = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addAuditorium(long id) {
        Auditorium auditorium = Datastore.getAuditoriumById(id);
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public String getZipcode() {
        return zipCode;
    }





    public String toString() {
        return String.format("%s (%s, %s, %s %s) [%s]", this.name, this.streetAddress, this.city, this.state, this.zipCode, this.phoneNumber);
    }
    private static List<Movie> movies = new ArrayList<>();
    public static List<Movie> searchMoviesByTitle(String text) {
        List<Movie> result = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(text.toLowerCase())) {
                result.add(movie);
            }
        }

        return result;
    }

}
