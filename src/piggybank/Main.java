package piggybank;

public class Main {

    public static void main(String[] args) {
        System.out.println("*** Cafe Morgan Piggy Bank & Trust ***");
        Dollar dollar = new Dollar(5);
        System.out.println(dollar);
        Dollar dollar2 = new Dollar();
        System.out.println(dollar2);
        
        Quarter quarter1 = new Quarter();
        Quarter quarter2 = new Quarter(5);
        System.out.println(quarter1);
        System.out.println(quarter2);
        
        Dime dime1 = new Dime();
        Dime dime2 = new Dime(7);
        System.out.println(dime1);
        System.out.println(dime2);
        
        Nickel nickel1 = new Nickel();
        Nickel nickel2 = new Nickel(3);
        System.out.println(nickel1);
        System.out.println(nickel2);
        
        Penny penny1 = new Penny();
        Penny pennies = new Penny(37);
        System.out.println(penny1);
        System.out.println(pennies);
    }
}