import java.util.*;

class Room {
    int roomNumber;
    String type;
    double price;
    boolean isBooked;
    String customerName;

    Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
        this.customerName = "";
    }

    public void bookRoom(String customerName) {
        if (!isBooked) {
            isBooked = true;
            this.customerName = customerName;
            System.out.println("Room " + roomNumber + " booked successfully for " + customerName + ".");
        } else {
            System.out.println("Room " + roomNumber + " is already booked!");
        }
    }

    public void cancelBooking() {
        if (isBooked) {
            System.out.println("Booking for " + customerName + " in Room " + roomNumber + " is cancelled.");
            isBooked = false;
            customerName = "";
        } else {
            System.out.println("Room " + roomNumber + " is not booked yet!");
        }
    }

    public void showDetails() {
        System.out.println("Room No: " + roomNumber + " | Type: " + type + " | Price: $" + price +
                           " | Status: " + (isBooked ? "Booked (" + customerName + ")" : "Available"));
    }
}

public class HotelReservationSystem {
    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();

        int choice;
        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    viewAllRooms();
                    break;
                case 5:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    static void initializeRooms() {
        rooms.add(new Room(101, "Single", 2000));
        rooms.add(new Room(102, "Double", 3500));
        rooms.add(new Room(103, "Deluxe", 5000));
        rooms.add(new Room(104, "Suite", 7500));
    }

    static void viewAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        for (Room room : rooms) {
            if (!room.isBooked)
                room.showDetails();
        }
    }

    static void bookRoom() {
        System.out.print("Enter Room Number to book: ");
        int roomNumber = sc.nextInt();
        sc.nextLine(); // consume newline

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                if (!room.isBooked) {
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    room.bookRoom(name);
                    return;
                } else {
                    System.out.println("Room already booked!");
                    return;
                }
            }
        }
        System.out.println("Room not found!");
    }

    static void cancelBooking() {
        System.out.print("Enter Room Number to cancel booking: ");
        int roomNumber = sc.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                room.cancelBooking();
                return;
            }
        }
        System.out.println("Room not found!");
    }

    static void viewAllRooms() {
        System.out.println("\n--- All Rooms ---");
        for (Room room : rooms) {
            room.showDetails();
        }
    }
}
