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

    public void setQuantity(int num) {
        this.quantity = num;
    };

    public void add(int num) {
        this.quantity += num;
    }

    public void subtract(int num) {
        if (this.quantity > 0) {
            //System.out.println("Start with " + getQuantity() + " " + getName());
            this.quantity -= num;
            // System.out.println("Subtract " + num + " from " + name + ": " + getQuantity());
        } else {
            System.out.println("Number exceeds available quantity");
        }
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