package piggybank;

public class Quarter extends Money {

    public Quarter(int quantity) {
        super(quantity);
        name = "Quarter";
    }

    public Quarter() {
        name = "Quarter";
    }

    @Override
    public double getFaceValue() {
        return quantity * 0.25;
    }

}