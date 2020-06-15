package piggybank;

public class Dollar extends Money {
    
    public Dollar(int quantity) {
        super(quantity);
        name = "Dollar";
    }
    
    public Dollar() {
        name = "Dollar";
    }

    @Override
    public double getFaceValue() {
        return quantity * 1.0;
    }
    
}