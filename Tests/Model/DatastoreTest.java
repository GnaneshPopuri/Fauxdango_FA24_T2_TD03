package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatastoreTest {

    @BeforeEach
    void setUp() {
        Datastore.resetData();
    }

    @Test
    void testSearchActorsByName() {
        List<Actor> results = Datastore.searchActorsByName("Tom Cruise");
        assertEquals(1, results.size());
        assertEquals("Tom", results.get(0).getFirstName());
    }

    @Test
    void testSearchMoviesByTitle() {
        List<Movie> results = Datastore.searchMoviesByTitle("Top Gun");
        assertEquals(1, results.size());
        assertEquals("Top Gun", results.get(0).getTitle());
    }

    @Test
    void testSearchTheatersByName() {
        List<Theater> results = Datastore.searchTheatersByName("AMC");
        assertEquals(1, results.size());
        assertTrue(results.get(0).getName().contains("AMC"));
    }

    @Test
    void testSearchTheatersByZipcode() {
        List<Theater> results = Datastore.searchTheatersByZipcode("19020");
        assertEquals(1, results.size());
        assertEquals("19020", results.get(0).getZipcode());
    }
}
