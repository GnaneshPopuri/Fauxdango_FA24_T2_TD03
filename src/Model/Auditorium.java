package Model;

import java.util.ArrayList;
import java.util.List;

public class Auditorium extends DataStoreObj {
    private final int auditoriumNumber;
    private final List<Showing> showings;

    public Auditorium(int auditoriumNumber) {
        this.auditoriumNumber = auditoriumNumber;
        this.showings = new ArrayList<>();
    }

    public List<Showing> getShowings() {
        return showings;
    }

    @Override
    public String toString() {
        return "Auditorium Number: " + auditoriumNumber;
    }
}
