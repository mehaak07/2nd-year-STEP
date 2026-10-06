import java.util.Scanner;

public class FestivalBonusCalculator {

    // Common employee details and operation
    static abstract class Employee {
        String name;
        double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double calculateBonus();
    }

    // Full-time: 10% of salary
    static class FullTime extends Employee {

        FullTime(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double calculateBonus() {
            return monthlySalary * 0.10;
        }
    }

    // Part-time: 5% of salary
    static class PartTime extends Employee {

        PartTime(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double calculateBonus() {
            return monthlySalary * 0.05;
        }
    }

    // Intern: fixed ₹2000
    static class Intern extends Employee {

        Intern(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double calculateBonus() {
            return 2000;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTime(name, salary);
            } else if (type.equals("PARTTIME")) {
                employee = new PartTime(name, salary);
            } else {
                employee = new Intern(name, salary);
            }

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", employee.name, bonus);
            totalBonus = totalBonus + bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}
