import java.util.Scanner;
import java.time.LocalDate;

public class StreamingPlanRenewalReminder {

    // Common operation
    static abstract class Plan {
        abstract int getValidityDays();

        LocalDate calculateRenewalDate(LocalDate startDate) {
            return startDate.plusDays(getValidityDays());
        }
    }

    // Basic: 30 days
    static class Basic extends Plan {
        @Override
        int getValidityDays() {
            return 30;
        }
    }

    // Standard: 90 days
    static class Standard extends Plan {
        @Override
        int getValidityDays() {
            return 90;
        }
    }

    // Premium: 365 days
    static class Premium extends Plan {
        @Override
        int getValidityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new Basic();
            } else if (type.equals("STANDARD")) {
                plan = new Standard();
            } else {
                plan = new Premium();
            }

            LocalDate renewalDate = plan.calculateRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}
