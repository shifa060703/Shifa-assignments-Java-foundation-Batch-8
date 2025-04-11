package javatask1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Order Delivery Status
        System.out.print("Enter order status: ");
        String status = sc.nextLine();

        if (status.equalsIgnoreCase("Delivered")) {
            System.out.println("Order has been delivered.");
        } else if (status.equalsIgnoreCase("Processing")) {
            System.out.println("Order is still processing.");
        } else if (status.equalsIgnoreCase("Cancelled")) {
            System.out.println("Order was cancelled.");
        } else {
            System.out.println("Invalid status.");
        }

        // 2. Parcel Weight Category
        System.out.print("Enter parcel weight in kg: ");
        double weight = sc.nextDouble();

        switch ((int) weight) {
            case 0, 1, 2:
                System.out.println("Light Parcel");
                break;
            case 3, 4, 5:
                System.out.println("Medium Parcel");
                break;
            default:
                System.out.println("Heavy Parcel");
        }

        sc.nextLine(); // consume leftover newline

        // 3. Login System
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if ((username.equals("employee") && password.equals("emp123")) ||
            (username.equals("customer") && password.equals("cust123"))) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }

        // 4. Courier Assignment (Dummy Logic)
        String[] couriers = {"Courier1", "Courier2", "Courier3"};
        int[] load = {2, 1, 0}; // lower = more available
        int minLoad = Integer.MAX_VALUE;
        int assignedIndex = -1;

        for (int i = 0; i < load.length; i++) {
            if (load[i] < minLoad) {
                minLoad = load[i];
                assignedIndex = i;
            }
        }

        if (assignedIndex != -1) {
            System.out.println("Assigned to " + couriers[assignedIndex]);
        } else {
            System.out.println("No couriers available.");
        }

        sc.close();
    }
}
