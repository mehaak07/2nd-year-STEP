import java.util.Scanner;

public class MovieTicketCounter {

    // Parent class: common things for every ticket
    static abstract class Ticket {
        static final double CONVENIENCE_FEE = 20;

        abstract double getPrice();

        double calculateAmount(int count) {
            return (getPrice() + CONVENIENCE_FEE) * count;
        }
    }

    // Regular seat
    static class Regular extends Ticket {
        @Override
        double getPrice() {
            return 150;
        }
    }

    // Premium seat
    static class Premium extends Ticket {
        @Override
        double getPrice() {
            return 250;
        }
    }

    // Recliner seat
    static class Recliner extends Ticket {
        @Override
        double getPrice() {
            return 400;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            if (seat.equals("REGULAR")) {
                ticket = new Regular();
            } else if (seat.equals("PREMIUM")) {
                ticket = new Premium();
            } else {
                ticket = new Recliner();
            }

            double amount = ticket.calculateAmount(count);

            System.out.printf("%s: %.2f%n", seat, amount);
            total = total + amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
