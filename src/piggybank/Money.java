package piggybank;

import java.text.DecimalFormat;

abstract class Money {

    String pattern = "$0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);

    protected static int maxId = 0;
    protected int id;
    protected String name;
    protected int quantity;
    protected double faceValue;

    public Money(int quantity) {
        maxId++;
        id = maxId;
        this.quantity = quantity;
    }

    public Money() {
        maxId++;
        id = maxId;
        quantity = 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return quantity > 1 ? name + "s" : name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    };

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public double getTotalValue() {
        return quantity * faceValue;
    }

    @Override
    public String toString() {
        return getName() + " " + "quantity: " + quantity + " face value: " + decimalFormat.format(getTotalValue());
    }

}