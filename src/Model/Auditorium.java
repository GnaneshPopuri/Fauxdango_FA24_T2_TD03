package Model;

import java.util.ArrayList;
import java.util.List;

public class Auditorium extends DataStoreObj {
    private int auditoriumNumber;
    private List<Showing> showings;

    public Auditorium(int auditoriumNumber) {
        this.auditoriumNumber = auditoriumNumber;
        this.showings = new ArrayList<>();
    }

    public void addShowing(long showingId) {
        Showing showing = Datastore.getShowingById(showingId);
        if (showing != null) {
            this.showings.add(showing);
        }
    }

    public List<Showing> getShowings() {
        return showings;
    }

    @Override
    public String toString() {
        return "Auditorium Number: " + auditoriumNumber;
    }
}
