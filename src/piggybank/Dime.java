package piggybank;

public class Dime extends Money {

    public Dime(int quantity) {
        super(quantity);
        name = "Dime";
        faceValue = 0.10;
    }

    public Dime() {
        name = "Dime";
        faceValue = 0.10;
    }

}