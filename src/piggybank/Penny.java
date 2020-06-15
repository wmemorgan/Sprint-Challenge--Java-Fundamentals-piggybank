package piggybank;

public class Penny extends Money {

    public Penny(int quantity) {
        super(quantity);
        name = "Penny";
        faceValue = 0.01;
    }

    public Penny() {
        name = "Penny";
        faceValue = 0.01;
    }

    @Override
    public String getName() {
        return quantity > 1 ? "Pennies" : name;
    }
}