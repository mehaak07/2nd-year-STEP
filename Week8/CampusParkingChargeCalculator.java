import java.util.Scanner;

public class CampusParkingChargeCalculator {

    // Common operation
    static abstract class Vehicle {
        abstract double calculateCharge(int hours);
    }

    // Bike: ₹10 per hour
    static class Bike extends Vehicle {
        @Override
        double calculateCharge(int hours) {
            return hours * 10;
        }
    }

    // Car: ₹30 first hour + ₹20 for every additional hour
    static class Car extends Vehicle {
        @Override
        double calculateCharge(int hours) {
            return 30 + (hours - 1) * 20;
        }
    }

    // Truck: ₹50 per hour, minimum ₹100
    static class Truck extends Vehicle {
        @Override
        double calculateCharge(int hours) {
            double charge = hours * 50;

            if (charge < 100) {
                charge = 100;
            }

            return charge;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            if (type.equals("BIKE")) {
                vehicle = new Bike();
            } else if (type.equals("CAR")) {
                vehicle = new Car();
            } else {
                vehicle = new Truck();
            }

            double charge = vehicle.calculateCharge(hours);

            System.out.printf("%s: %.2f%n", type, charge);
            total = total + charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
