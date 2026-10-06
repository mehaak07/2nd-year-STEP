import java.util.Scanner;

public class CollegeFeeCounter {

    // Common parent class
    static abstract class Student {
        protected String name;

        Student(String name) {
            this.name = name;
        }

        abstract double calculateFee();
    }

    // Interface for students who use the bus
    interface UsesBus {
        double TRANSPORT_FEE = 12000;

        double getTransportFee();
    }

    // Day scholar: tuition 40000 + transport 12000
    static class DayScholar extends Student implements UsesBus {

        DayScholar(String name) {
            super(name);
        }

        @Override
        double calculateFee() {
            return 40000 + getTransportFee();
        }

        @Override
        public double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    // Hosteller: tuition 40000 + hostel fee 60000
    static class Hosteller extends Student {

        Hosteller(String name) {
            super(name);
        }

        @Override
        double calculateFee() {
            return 40000 + 60000;
        }
    }

    // Scholarship student: half tuition 20000 + transport 12000
    static class Scholar extends Student implements UsesBus {

        Scholar(String name) {
            super(name);
        }

        @Override
        double calculateFee() {
            return 20000 + getTransportFee();
        }

        @Override
        public double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new Scholar(name);
            }

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n", student.name, fee);
            totalCollected = totalCollected + fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}
