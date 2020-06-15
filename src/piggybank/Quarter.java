package piggybank;

public class Quarter extends Money {

    public Quarter(int quantity) {
        super(quantity);
        name = "Quarter";
        faceValue = 0.25;
    }

    public Quarter() {
        name = "Quarter";
        faceValue = 0.25;
    }

}