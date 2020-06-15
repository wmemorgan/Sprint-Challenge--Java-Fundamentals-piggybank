package piggybank;

public class Dollar extends Money {

    public Dollar(int quantity) {
        super(quantity);
        name = "Dollar";
        faceValue = 1.0;
    }

    public Dollar() {
        name = "Dollar";
        faceValue = 1.0;
    }

}