import java.util.Scanner;

public class HomeApplianceEnergyReport {

    // Common parent class
    static abstract class Appliance {
        abstract double getPower();

        double calculateUnits(double hours) {
            return (getPower() * hours) / 1000;
        }

        double calculateCost(double units) {
            return units * 8;
        }
    }

    // Optional saver mode
    interface SaverMode {
        double applySaver(double units);
    }

    // Fridge: 150 W, no saver mode
    static class Fridge extends Appliance {
        @Override
        double getPower() {
            return 150;
        }
    }

    // AC: 1500 W, supports saver mode
    static class AC extends Appliance implements SaverMode {
        @Override
        double getPower() {
            return 1500;
        }

        @Override
        public double applySaver(double units) {
            return units * 0.75;
        }
    }

    // TV: 100 W, no saver mode
    static class TV extends Appliance {
        @Override
        double getPower() {
            return 100;
        }
    }

    // Washer: 500 W, supports saver mode
    static class Washer extends Appliance implements SaverMode {
        @Override
        double getPower() {
            return 500;
        }

        @Override
        public double applySaver(double units) {
            return units * 0.75;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saverRequested = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saverRequested = true;
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge();
            } else if (type.equals("AC")) {
                appliance = new AC();
            } else if (type.equals("TV")) {
                appliance = new TV();
            } else {
                appliance = new Washer();
            }

            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(hours);

            if (saverRequested) {
                SaverMode saverAppliance = (SaverMode) appliance;
                units = saverAppliance.applySaver(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost = totalCost + cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}
