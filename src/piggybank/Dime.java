package piggybank;

public class Dime extends Money {

    public Dime(int quantity) {
        super(quantity);
        name = "Dime";
    }

    public Dime() {
        name = "Dime";
    }

    @Override
    public double getFaceValue() {
        return quantity * 0.10;
    }

}