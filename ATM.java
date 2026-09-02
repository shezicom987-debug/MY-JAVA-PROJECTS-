import java.util.*;

class ATMSystem {

    // Menu
    void menu() {
        System.out.println("\n========= ATM MENU =========");
        System.out.println("1 - CHECK BALANCE");
        System.out.println("2 - WITHDRAW BALANCE");
        System.out.println("3 - DEPOSIT BALANCE");
        System.out.println("4 - EXIT");
    }

    // Check balance
    void check_balance(double balance) {
        System.out.println("Your current balance is: " + balance);
    }

    // Withdraw
    double withdraw(double balance, Scanner sc) {
        System.out.print("Enter the amount to withdraw: ");
        double w_balance = sc.nextDouble();

        if (w_balance <= 0) {
            System.out.println("Invalid amount!");
        } else if (w_balance > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Successfully withdrew: " + w_balance);
            balance -= w_balance;
        }
        return balance;
    }

    // Deposit
    double deposit(double balance, Scanner sc) {
        System.out.print("Enter the amount to deposit: ");
        double d_balance = sc.nextDouble();

        if (d_balance <= 0) {
            System.out.println("Invalid amount!");
        } else {
            balance += d_balance;
            System.out.println("Successfully deposited: " + d_balance);
        }
        return balance;
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATMSystem atm = new ATMSystem();

        // === Store data for 10 users ===
        String[] names   = {"Anees", "Mansab", "Adnan", "Fatima", "Bilal", "Ayesha", "Hamza", "Zainab", "Usman", "Shahzaib"};
        int[] pins       = {1111, 2222, 3333, 4444, 5555, 6666, 7777, 8888, 9999, 1234};
        double[] balances = {5000, 3000, 7000, 2000, 10000, 2500, 6000, 4500, 8000, 5000};

        int userIndex = -1;

        // === Login ===
        System.out.println("======== WELCOME TO ATM ========");
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        // Find the user by PIN
        for (int i = 0; i < pins.length; i++) {
            if (pins[i] == enteredPin) {
                
                userIndex = i;
                break;
            }
        }

        if (userIndex == -1) {
            System.out.println("Incorrect PIN. Access Denied.");
        } else {
            System.out.println("\n Login successful. Welcome, " + names[userIndex] + "!");

            int choice;
            do {
                atm.menu();
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.check_balance(balances[userIndex]);
                        break;
                    case 2:
                        balances[userIndex] = atm.withdraw(balances[userIndex], sc);
                        break;
                    case 3:
                        balances[userIndex] = atm.deposit(balances[userIndex], sc);
                        break;
                    case 4:
                        System.out.println("\n👋 Thank you " + names[userIndex] + " for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        }

        sc.close();
    }
}
