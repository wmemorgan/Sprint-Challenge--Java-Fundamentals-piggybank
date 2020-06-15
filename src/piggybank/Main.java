package piggybank;

public class Main {

    public static PiggyBank ourPiggyBank;

    public static void main(String[] args) {

        System.out.println("\n*** Welcome to Cafe Morgan Piggy Bank & Trust ***");
        // Instantiate bank
        ourPiggyBank = new PiggyBank();
        // Display piggy bank contents:
        ourPiggyBank.getAllDeposits();
        // Withdraw money
        ourPiggyBank.withdraw(1.50);
    }
}