package piggybank;

public class Penny extends Money {

    public Penny(int quantity) {
        super(quantity);
        name = "Penny";
    }

    public Penny() {
        name = "Penny";
    }

    @Override
    public String getName() {
        return quantity > 1 ? "Pennies" : name;
    }

    @Override
    public double getFaceValue() {
        return quantity * 0.01;
    }

}