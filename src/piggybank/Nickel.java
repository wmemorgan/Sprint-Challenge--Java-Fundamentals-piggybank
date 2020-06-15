package piggybank;

public class Nickel extends Money {

    public Nickel(int quantity) {
        super(quantity);
        name = "Nickel";
    }

    public Nickel() {
        name = "Nickel";
    }

    @Override
    public double getFaceValue() {
        return quantity * 0.05;
    }

}