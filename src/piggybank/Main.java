package piggybank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String pattern = "$0";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        List<Money> piggyBank = new ArrayList<>();

        System.out.println("\n*** Welcome to Cafe Morgan Piggy Bank & Trust ***\n");

        // Deposit money to bank
        piggyBank.add(new Quarter());
        piggyBank.add(new Dime());
        piggyBank.add(new Dollar(5));
        piggyBank.add(new Nickel(3));
        piggyBank.add(new Dime(7));
        piggyBank.add(new Dollar());
        piggyBank.add(new Penny(10));

        // Print contents
        System.out.println("Piggy Bank deposits:");
        for (Money m : piggyBank) {
            if (m.getName().contains("Dollar")) {
                System.out.println(decimalFormat.format(m.getFaceValue()));
            } else {
                System.out.println(m.quantity + " " + m.getName());
            }
        }
    }
}