import java.util.Scanner;

public class ParcelShippingDesk {

    // Common operation for every parcel
    static abstract class Parcel {
        protected double weightKg;
        protected double declaredValue;

        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        abstract double calculateCharge();
    }

    // Separate capability for insurable parcels
    interface Insurable {
        double calculateInsurance();
    }

    // Standard parcel cannot be insured
    static class Standard extends Parcel {

        Standard(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        double calculateCharge() {
            return 40 + (10 * weightKg);
        }
    }

    // Express parcel can be insured
    static class Express extends Parcel implements Insurable {

        Express(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        double calculateCharge() {
            return 80 + (15 * weightKg);
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    // Fragile parcel can be insured
    static class Fragile extends Parcel implements Insurable {

        Fragile(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        double calculateCharge() {
            return 40 + (10 * weightKg) + 50;
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            if (type.equals("STANDARD")) {
                parcel = new Standard(weight, declaredValue);
            } else if (type.equals("EXPRESS")) {
                parcel = new Express(weight, declaredValue);
            } else {
                parcel = new Fragile(weight, declaredValue);
            }

            double charge = parcel.calculateCharge();
            double insurance = 0;

            if (parcel instanceof Insurable) {
                Insurable insurableParcel = (Insurable) parcel;
                insurance = insurableParcel.calculateInsurance();
            }

            double total = charge + insurance;
            grandTotal = grandTotal + total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}
