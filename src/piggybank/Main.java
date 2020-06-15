package piggybank;

public class Main {

    public static PiggyBank ourPiggyBank;

    public static void main(String[] args) {

        System.out.println("\n*** Welcome to Cafe Morgan Piggy Bank & Trust ***\n");
        // Instantiate bank
        ourPiggyBank = new PiggyBank();
        // Get aggregate deposits
        ourPiggyBank.getTotalDeposits();
        // Withdraw money
        ourPiggyBank.withdraw(1.50);
    }
}