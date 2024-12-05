package Model;

import java.util.ArrayList;
import java.util.List;

public class Theater extends DataStoreObj {
    private final String name;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String phoneNumber;
    private final String website; // Added website field

    private final List<Auditorium> auditoriums;

    public Theater(Long id, String name, String streetAddress, String city, String state, String zipCode, String phoneNumber, String website) {
        super(id);
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.website = website; // Initialize website
        this.auditoriums = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addAuditorium(long id) {
        Auditorium auditorium = Datastore.getAuditoriumById(id);
        if (auditorium != null) {
            this.auditoriums.add(auditorium);
        }
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public String getZipcode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return String.format("%s (%s, %s, %s %s) [%s] - Website: %s",
                this.name, this.streetAddress, this.city, this.state, this.zipCode, this.phoneNumber, this.website);
    }
}
