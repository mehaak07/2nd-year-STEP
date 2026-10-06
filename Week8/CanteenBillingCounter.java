import java.util.Scanner;

public class CanteenBillingCounter {

    // Parent class
    static abstract class Customer {

        abstract double calculateFinalAmount(double amount);
    }

    // Student
    static class Student extends Customer {

        @Override
        double calculateFinalAmount(double amount) {
            return amount * 0.90;
        }
    }

    // Staff
    static class Staff extends Customer {

        @Override
        double calculateFinalAmount(double amount) {
            return amount * 0.95;
        }
    }

    // Guest
    static class Guest extends Customer {

        @Override
        double calculateFinalAmount(double amount) {
            return amount + 10;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            // Create the appropriate customer object
            if (type.equals("STUDENT")) {
                customer = new Student();
            } else if (type.equals("STAFF")) {
                customer = new Staff();
            } else {
                customer = new Guest();
            }

            // Polymorphism
            double finalAmount = customer.calculateFinalAmount(amount);

            System.out.printf("%s: %.2f%n", type, finalAmount);

            grandTotal = grandTotal + finalAmount;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}
