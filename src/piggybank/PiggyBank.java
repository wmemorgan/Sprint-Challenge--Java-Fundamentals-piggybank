package piggybank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PiggyBank {

    String pattern = "$0";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);

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

        // Print contents
        System.out.println("Piggy Bank deposits:");
        for (

        Money m : piggyBank) {
            if (m.getName().contains("Dollar")) {
                System.out.println(decimalFormat.format(m.getTotalValue()));
            } else {
                System.out.println(m.quantity + " " + m.getName());
            }
        }

        // Aggregate deposits
        for (Money m : piggyBank) {
            double denom = m.getFaceValue();

            if (vault.containsKey(denom)) {
                int updatedTotalQuantity = vault.get(denom) + m.getQuantity();
                vault.put(denom, updatedTotalQuantity);
            } else {
                vault.put(denom, m.getQuantity());
            }
        }
    }
    
    public void getTotalDeposits() {
    
        double sum = 0.0;
        for (HashMap.Entry mapElem : vault.entrySet()) {
            double denomination = (double) mapElem.getKey();
            double quantity = Double.valueOf((int) mapElem.getValue());
            sum += denomination * quantity;
        }

        decimalFormat.applyPattern("$0.00");
        System.out.println("\nThe piggy bank holds " + decimalFormat.format(sum));
    }

    public void withdraw(double amount) {

        decimalFormat.applyPattern("$0.00");
        System.out.println("\nWithdrawal amount: " + decimalFormat.format(amount));
        double[] denom = { 0.01, 0.05, 0.1, 0.25, 1.0 };

        for (int i = denom.length - 1; i > 0; i--) {
            int denomQuantity = (int) (Math.floor(amount / denom[i]));
            if (denomQuantity > 0 && vault.get(denom[i]) > 0) {
                double totalValue = (double) vault.get(denom[i]) * denom[i];
                double denomAmt = denomQuantity * denom[i];
                double subtractAmt = Math.min(denomAmt, totalValue);

                // Update denomination quantity
                vault.put(denom[i], vault.get(denom[i]) - Math.min(denomQuantity, vault.get(denom[i])));
                
                // Decrement withdrawal amount
                amount -= subtractAmt;
                amount = Math.round(amount * 100.0) / 100.0;
            }
        }

        //System.out.println("Current vault contents: " + vault);
        // Get cash on hand
        getTotalDeposits();
    }
}