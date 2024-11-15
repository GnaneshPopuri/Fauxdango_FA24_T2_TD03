package Model;

import java.util.List;

public class Auditorium extends DataStoreObj {
    private int auditoriumNumber;
//    private List<Showing> showings;

    public Auditorium(int auditoriumNumber) { // add this as a parameter after the task showings is completed: List<Showing> showings
        this.auditoriumNumber = auditoriumNumber;
//        this.showings = showings;
    }

    /* public List<Showing> getShowings() {
        return showings;
    } */

    /* public void addShowing(Showing showing) {
        this.showings.add(showing);
    } */

    @Override
    public String toString() {
        return String.valueOf(auditoriumNumber);
    }
}
