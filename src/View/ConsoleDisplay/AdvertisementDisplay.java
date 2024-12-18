package View.ConsoleDisplay;

import Model.Advertisement;
import Model.AdvertisementBank;


public class AdvertisementDisplay {
    private final AdvertisementBank adBank;

    public AdvertisementDisplay(AdvertisementBank adBank) {
        this.adBank = adBank;
    }

    private void displayAd(Advertisement ad) {
        System.out.println();
        System.out.println("=== " + ad.getText() + " ===");
    }

    public void displayNextAd() {
        displayAd(adBank.getNextAd());
    }
}
