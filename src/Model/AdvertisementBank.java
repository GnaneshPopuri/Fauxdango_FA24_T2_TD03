package Model;

import java.util.List;

public class AdvertisementBank {
    private final List<Advertisement> ads = Datastore.getAllAdvertisements();
    int currentAdIndex = 0;

    public Advertisement getNextAd() {
        currentAdIndex++;
        if (currentAdIndex >= ads.size()) {
            currentAdIndex = 0;
        }

        return ads.get(currentAdIndex);
    }

}
