import java.util.HashMap;
import java.util.Scanner;

class User {
    String name;
    double balance;
    HashMap<String, Integer> myProducts = new HashMap<>();

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void portfolio() {
        System.out.println("\n--- Portfolio ---");
        System.out.println("Name: " + name);
        System.out.println("Balance: $" + balance);

        if (myProducts.isEmpty()) {
            System.out.println("No products owned yet.");
        } else {
            System.out.println("Owned Products:");
            for (String p : myProducts.keySet()) {
                System.out.println(p + " → " + myProducts.get(p) + " units");
            }
        }
    }
}

class Market {
    HashMap<String, Double> trade = new HashMap<>();

    Market() {
        trade.put("Apple", 178.5);
        trade.put("Tesla", 254.3);
        trade.put("Google", 134.2);
        trade.put("Amazon", 305.9);
    }

    public void view_market() {
        System.out.println("\n--- Market Prices ---");
        for (String key : trade.keySet()) {
            System.out.println(key + " → $" + trade.get(key));
        }
    }
}

class Buy {
    double Buy_product(Scanner sc, Market market, User user) {
        sc.nextLine(); // clear buffer
        System.out.print("Enter Name of the product: ");
        String product = sc.nextLine();

        if (market.trade.containsKey(product)) {
            System.out.print("Enter the Quantity: ");
            int quantity = sc.nextInt();

            double totalPrice = market.trade.get(product) * quantity;
            if (user.balance >= totalPrice) {
                user.balance -= totalPrice;
                user.myProducts.put(product, user.myProducts.getOrDefault(product, 0) + quantity);
                System.out.println("You bought " + quantity + " of " + product + " for $" + totalPrice);
                System.out.println("Remaining Balance: $" + user.balance);
                return totalPrice;
            } else {
                System.out.println("Insufficient Balance!");
                return 0.0;
            }
        } else {
            System.out.println("Item Not Found....");
            return 0.0;
        }
    }
}

class Sell {
    double sell_incm(Scanner sc, Market market, User user) {
        sc.nextLine(); // clear buffer
        System.out.print("Enter the Name of product: ");
        String product = sc.nextLine();

        if (market.trade.containsKey(product)) {
            if (!user.myProducts.containsKey(product) || user.myProducts.get(product) == 0) {
                System.out.println("You don't own this product!");
                return 0.0;
            }

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            int owned = user.myProducts.get(product);
            if (quantity > owned) {
                System.out.println("You only own " + owned + " units of " + product);
                return 0.0;
            }

            double income = market.trade.get(product) * quantity;
            user.balance += income;
            user.myProducts.put(product, owned - quantity);
            if (user.myProducts.get(product) == 0) {
                user.myProducts.remove(product);
            }

            System.out.println("You sold " + quantity + " of " + product + " for $" + income);
            System.out.println("New Balance: $" + user.balance);
            return income;

        } else {
            System.out.println("Product Not Found..");
            return 0.0;
        }
    }
}

public class StockMarketPlatform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User me = new User("Shahzaib Ali", 10000.00);
        Market market = new Market();
        Buy buyer = new Buy();
        Sell seller = new Sell();

        boolean run = true;

        do {
            System.out.println("\n<<<< Welcome to Trade Market Platform >>>>");
            System.out.println("1 → View Portfolio");
            System.out.println("2 → View Market");
            System.out.println("3 → Buy Product");
            System.out.println("4 → Sell Product");
            System.out.println("5 → Exit");
            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    me.portfolio();
                    break;

                case 2:
                    market.view_market();
                    break;

                case 3:
                    buyer.Buy_product(sc, market, me);
                    break;

                case 4:
                    seller.sell_incm(sc, market, me);
                    break;

                case 5:
                    run = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Choice..");
            }
        } while (run);

        sc.close();
    }
}
