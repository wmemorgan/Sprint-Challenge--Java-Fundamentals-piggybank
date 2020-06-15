package piggybank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PiggyBank {

    protected double totalListValue = 0.0;
    DecimalFormat decimalFormat = new DecimalFormat();

    public List<Money> piggyBank = new ArrayList<>();
    Map<Double, Integer> vault = new HashMap<>();

    public PiggyBank() {
        // Deposit money to bank
        piggyBank.add(new Quarter());
        piggyBank.add(new Dime());
        piggyBank.add(new Dollar(5));
        piggyBank.add(new Nickel(3));
        piggyBank.add(new Dime(7));
        piggyBank.add(new Dollar());
        piggyBank.add(new Penny(10));
    }

    public void removeEmptyDenom() {
        // Remove empty denominations
        piggyBank.removeIf(m -> m.getQuantity() == 0);
    }

    public void resetListValue() {
        this.totalListValue = 0.0;
    }

    public void getAllDeposits() {
        // Clear empty denominations
        removeEmptyDenom();
        String pattern = "$0";
        decimalFormat.applyPattern(pattern);

        // Print contents
        System.out.println("\nPiggy Bank contains:");
        for (Money m : piggyBank) {
            if (m.getName().contains("Dollar")) {

                System.out.println(decimalFormat.format(m.getTotalValue()));
            } else {
                System.out.println(m.getQuantity() + " " + m.getName());
            }
        }
        
        // Get cash on hand
        calcTotalDeposits();
    }
    
    public void calcTotalDeposits(){
        // Clear empty denominations
        removeEmptyDenom();
        // Reset list value
        resetListValue();
        // Calculate current total list value
        for (Money m : piggyBank) {
            this.totalListValue += m.getTotalValue();
        }

        decimalFormat.applyPattern("$0.00");
        System.out.println("\nThe piggy bank holds " + decimalFormat.format(this.totalListValue));
    }

    public void withdraw(double amount) {

        if (amount <= 0.00) {
            System.out.println("\nInvalid number. Please enter valid withdrawal");
        }

        else if (amount > this.totalListValue) {
            System.out.println("\nInsufficient funds. Please enter a lower amount");
        }

        else {
            decimalFormat.applyPattern("$0.00");
            System.out.println("\nWithdraw " + decimalFormat.format(amount) + " from the piggy bank");

            for (Money m : piggyBank) {
                // Get available amount of specified denomination
                double denomCashValue = amount / m.getFaceValue();
                // Round to nearest hundredth
                denomCashValue = Math.round(denomCashValue * 100.0) / 100.0;
                int denomQuantity = (int) (Math.floor(denomCashValue));

                // System.out.println("denomQty: " + denomQuantity);
                if (denomQuantity > 0 && m.getQuantity() > 0) {
                    //System.out.println(m.getQuantity() + " " + m.getName() + " available");
                    double denonAmt = denomQuantity * m.getFaceValue();
                    double subtractAmt = Math.min(denonAmt, m.getTotalValue());

                    // Update denomination quantity
                    int qtyToSubtract = Math.min(denomQuantity, m.getQuantity());
                    // System.out.println("Qty to subtract: " + qtyToSubtract);
                    m.subtract(qtyToSubtract);
                    amount -= subtractAmt;
                    // Round to the nearest hundredth
                    amount = Math.round(amount * 100.0) / 100.0;
                    // System.out.println("CURRENT AMT: " + amount);
                }
            }

            // Get current piggy bank contents
            getAllDeposits();
        }
    }
}