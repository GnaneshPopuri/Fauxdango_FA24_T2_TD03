package Model;

import java.util.List;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*
 *  ______ _____ _   _ _ _____     _____  _   _   ___   _   _ _____  _____
 *  |  _  \  _  | \ | ( )_   _|   /  __ \| | | | / _ \ | \ | |  __ \|  ___|
 *  | | | | | | |  \| |/  | |     | /  \/| |_| |/ /_\ \|  \| | |  \/| |__
 *  | | | | | | | . ` |   | |     | |    |  _  ||  _  || . ` | | __ |  __|
 *  | |/ /\ \_/ / |\  |   | |     | \__/\| | | || | | || |\  | |_\ \| |___
 *  |___/  \___/\_| \_/   \_/      \____/\_| |_/\_| |_/\_| \_/\____/\____/
 *
 *
 *   _____ _   _ _____ _____     ______ _____ _      _____
 *  |_   _| | | |_   _/  ___|    |  ___|_   _| |    |  ___|
 *    | | | |_| | | | \ `--.     | |_    | | | |    | |__
 *    | | |  _  | | |  `--. \    |  _|   | | | |    |  __|
 *    | | | | | |_| |_/\__/ /    | |    _| |_| |____| |___
 *    \_/ \_| |_/\___/\____/     \_|    \___/\_____/\____/
 */

public class AuditoriumTest {

    @Test
    public void getShowings__Pass_nothing__Returns_correct_showings() {
        long[][] expecteds = {
                {1, 2}
                , {3, 4}
        };

        for (int i = 0; i < expecteds.length; i++) {
            Auditorium auditorium = Datastore.getAuditoriumById(i + 1);
            List<Showing> showings = auditorium.getShowings();

            for (int j = 0; j < expecteds[i].length; j++) {
                long showingId = expecteds[i][j];
                Showing expectedShowing = Datastore.getShowingById(showingId);
                String msg = String.format("Expected showing '%s' in auditorium '%s'", expectedShowing, auditorium);
                assertTrue(showings.contains(expectedShowing), msg);
            }

        }
    }

}
