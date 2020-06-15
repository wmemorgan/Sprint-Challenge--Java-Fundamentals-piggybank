package piggybank;

public class Nickel extends Money {

    public Nickel(int quantity) {
        super(quantity);
        name = "Nickel";
        faceValue = 0.05;
    }

    public Nickel() {
        name = "Nickel";
        faceValue = 0.05;
    }

}