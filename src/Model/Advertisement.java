package Model;

public class Advertisement extends DataStoreObj {
    private final String text;

    public Advertisement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
