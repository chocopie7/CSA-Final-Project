import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ArrayList<Client> ClientList = new ArrayList<>();
        ArrayList<Goods> GoodsList = new ArrayList<>();

        System.out.println("Logistics Cost Calculator");

        while (running) {
            try {
                System.out.println("\nOptions:");
                System.out.println("1. See or Add Client");
                System.out.println("2. See or Add Goods");
                System.out.println("3. Calculate Logistics");
                System.out.println("4. Exit Program");
                System.out.print("\nEnter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> handleClients(scanner, ClientList);
                    case 2 -> handleGoods(scanner, GoodsList);
                    case 3 -> calculateLogistics(scanner, ClientList, GoodsList);
                    case 4 -> {
                        System.out.println("Exiting program. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please select a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        scanner.close();
    }

    private static void handleClients(Scanner scanner, ArrayList<Client> ClientList) {
        System.out.println("\n1. See Clients");
        System.out.println("2. Add Clients");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                if (ClientList.isEmpty()) {
                    System.out.println("No clients available.");
                } else {
                    System.out.println(ClientList);
                }
            } else if (choice == 2) {
                System.out.print("\nAdd Client Name: ");
                String name = scanner.nextLine();
                System.out.print("\nAdd City Name: ");
                String cityname = scanner.nextLine();
                System.out.print("\nAdd Longitude: ");
                double longitude = Double.parseDouble(scanner.nextLine());
                System.out.print("\nAdd Latitude: ");
                double latitude = Double.parseDouble(scanner.nextLine());
                Client sendto = new Client(name, new Locations(cityname, longitude, latitude));
                ClientList.add(sendto);
                System.out.println("\nClient added successfully!");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error while handling clients. Please try again.");
        }
    }

    private static void handleGoods(Scanner scanner, ArrayList<Goods> GoodsList) {
        System.out.println("\n1. See Goods");
        System.out.println("2. Add Goods");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                if (GoodsList.isEmpty()) {
                    System.out.println("No goods available.");
                } else {
                    System.out.println(GoodsList);
                }
            } else if (choice == 2) {
                System.out.print("\nAdd Item Name: ");
                String name = scanner.nextLine();
                System.out.print("\nAdd Item ID: ");
                int itemid = Integer.parseInt(scanner.nextLine());
                System.out.print("\nAdd Item Weight: ");
                double itemweight = Double.parseDouble(scanner.nextLine());
                System.out.print("\nPerishable? (T/F): ");
                boolean perishable = scanner.nextLine().equalsIgnoreCase("T");
                System.out.print("\nShip By (days): ");
                int shipby = Integer.parseInt(scanner.nextLine());
                GoodsList.add(new Goods(name, itemid, itemweight, perishable, shipby));
                System.out.println("Goods added successfully!");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error while handling goods. Please try again.");
        }
    }

    private static void calculateLogistics(Scanner scanner, ArrayList<Client> ClientList, ArrayList<Goods> GoodsList) {
        try {
            if (ClientList.isEmpty() || GoodsList.isEmpty()) {
                System.out.println("Both clients and goods must be available for logistics calculation.");
                return;
            }

            System.out.println("Clients: " + ClientList);
            System.out.print("Choose sender index: ");
            int sender = Integer.parseInt(scanner.nextLine());
            System.out.print("Choose receiver index: ");
            int receiver = Integer.parseInt(scanner.nextLine());

            if (sender < 0 || sender >= ClientList.size() || receiver < 0 || receiver >= ClientList.size()) {
                System.out.println("Invalid sender or receiver index.");
                return;
            }

            System.out.println("Goods: " + GoodsList);
            System.out.print("Choose goods index: ");
            int goodsChoice = Integer.parseInt(scanner.nextLine());

            if (goodsChoice < 0 || goodsChoice >= GoodsList.size()) {
                System.out.println("Invalid goods index.");
                return;
            }

            new Logistics(ClientList.get(sender), ClientList.get(receiver), GoodsList.get(goodsChoice));
        } catch (Exception e) {
            System.out.println("Error during logistics calculation. Please try again.");
        }
    }
}
