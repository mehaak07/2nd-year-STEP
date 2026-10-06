import java.util.Scanner;

public class CityCabFareMeter {

    // Common rules for every cab
    static abstract class Cab {
        abstract double getRate();

        double calculateFare(double km) {
            double fare = km * getRate();

            if (fare < 100) {
                fare = 100;
            }

            return fare;
        }
    }

    // Night service is an optional ability
    interface NightService {
        double applyNightCharge(double fare);
    }

    // Mini: ₹10/km, no night service
    static class Mini extends Cab {
        @Override
        double getRate() {
            return 10;
        }
    }

    // Sedan: ₹14/km + night service
    static class Sedan extends Cab implements NightService {
        @Override
        double getRate() {
            return 14;
        }

        @Override
        public double applyNightCharge(double fare) {
            return fare * 1.20;
        }
    }

    // SUV: ₹18/km + night service
    static class SUV extends Cab implements NightService {
        @Override
        double getRate() {
            return 18;
        }

        @Override
        public double applyNightCharge(double fare) {
            return fare * 1.20;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini();
            } else if (type.equals("SEDAN")) {
                cab = new Sedan();
            } else {
                cab = new SUV();
            }

            // Mini cannot provide night service
            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total = total + fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
