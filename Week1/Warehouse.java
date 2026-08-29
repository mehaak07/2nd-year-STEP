import java.util.Scanner;

class Warehouse {

    void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        int highest = sectionA[0];
        String section = "Section A";
        int index = 0;

        // Calculate total of Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA = totalA + sectionA[i];

            if (sectionA[i] > highest) {
                highest = sectionA[i];
                section = "Section A";
                index = i;
            }
        }

        // Calculate total of Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB = totalB + sectionB[i];

            if (sectionB[i] > highest) {
                highest = sectionB[i];
                section = "Section B";
                index = i;
            }
        }

        // Print totals
        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        // Check balance
        if (totalA == totalB) {
            System.out.println("Status: Balanced");
        } else {
            System.out.println("Status: Not Balanced");
        }

        System.out.println("Highest Quantity: " + highest +
                           " (" + section + ", Item " + (index + 1) + ")");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] sectionA = new int[3];
        int[] sectionB = new int[3];

        System.out.println("Enter Section A quantities:");
        for (int i = 0; i < 3; i++) {
            sectionA[i] = sc.nextInt();
        }

        System.out.println("Enter Section B quantities:");
        for (int i = 0; i < 3; i++) {
            sectionB[i] = sc.nextInt();
        }

        Warehouse obj = new Warehouse();
        obj.analyzeInventory(sectionA, sectionB);
    }
}
