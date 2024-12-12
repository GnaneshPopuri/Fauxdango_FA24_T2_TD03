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

    public int getAuditoriumNumber() {
        return auditoriumNumber;
    }

    public List<Showing> getShowings() {
        return showings;
    }

    public void addShowing(Showing showing) {
        this.showings.add(showing);
    }

    @Override
    public String toString() {
        return "Auditorium Number: " + auditoriumNumber;
    }
}
