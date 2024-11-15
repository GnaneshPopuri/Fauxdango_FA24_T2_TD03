package Model;

import java.util.List;

public class Theater extends DataStoreObj {
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String website;

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

    }

    public List<Auditorium> getAuditoriums() {
        return null;  // Change this to return the auditoriums
    }

    public String toString() {
        return String.format("%s (%s, %s, %s %s) [%s]", this.name, this.streetAddress, this.city, this.state, this.zipCode, this.phoneNumber);
    }

}
