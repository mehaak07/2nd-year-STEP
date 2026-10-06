import java.util.Scanner;

public class HostelElectricityBill {

    // Common operation
    static abstract class Room {
        abstract double calculateBill(int units);
    }

    // Single room: ₹8 per unit
    static class SingleRoom extends Room {
        @Override
        double calculateBill(int units) {
            return units * 8;
        }
    }

    // Shared room: ₹6 per unit, divided among occupants
    static class SharedRoom extends Room {
        private int occupants;

        SharedRoom(int occupants) {
            this.occupants = occupants;
        }

        @Override
        double calculateBill(int units) {
            return (units * 6.0) / occupants;
        }
    }

    // AC room: ₹10 per unit + ₹200 fixed charge
    static class AcRoom extends Room {
        @Override
        double calculateBill(int units) {
            return (units * 10) + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom();
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(occupants);
            } else {
                room = new AcRoom();
            }

            double bill = room.calculateBill(units);

            System.out.printf("%s: %.2f%n", type, bill);
            total = total + bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
