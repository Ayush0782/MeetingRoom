
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static final BookingService bookingService =
            new BookingService();

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd-MM-uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("HH:mm")
                    .withResolverStyle(ResolverStyle.STRICT);

    public static void main(String[] args) {
        System.out.println("   MEETING ROOM BOOKING SYSTEM");
        while (true) {

            System.out.println("\n1. Book Meeting Room");
            System.out.println("2. View All Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {

                case "1":
                    bookMeetingRoom();
                    break;

                case "2":
                    viewBookings();
                    break;

                case "3":
                    cancelBooking();
                    break;

                case "4":
                    System.out.println(
                            "Thank you for using Meeting Room Booking System!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice! Please try again."
                    );
            }
        }
    }

    // Take input and book meeting room
    private static void bookMeetingRoom() {

        try {

            System.out.print(
                    "Enter meeting date (dd-MM-yyyy): "
            );

            LocalDate date = LocalDate.parse(
                    sc.nextLine().trim(), DATE_FORMAT
            );

            System.out.print("Enter start time (HH:mm): ");

            LocalTime startTime = LocalTime.parse(
                    sc.nextLine().trim(), TIME_FORMAT
            );

            System.out.print("Enter end time (HH:mm): ");

            LocalTime endTime = LocalTime.parse(
                    sc.nextLine().trim(), TIME_FORMAT
            );

            Booking booking = bookingService.bookMeetingRoom(
                    date, startTime, endTime
            );

            System.out.println("\nBooking successful!");
            booking.display();

        } catch (DateTimeParseException e) {

            System.out.println(
                    "Invalid date or time format!"
            );

            System.out.println(
                    "Use dd-MM-yyyy for date and HH:mm for time."
            );

        } catch (IllegalArgumentException e) {

            System.out.println("Rejected: " + e.getMessage());
        }
    }

    // Display all bookings
    private static void viewBookings() {

        List<Booking> allBookings =
                bookingService.getAllBookings();

        if (allBookings.isEmpty()) {

            System.out.println("\nNo bookings available.");
            return;
        }

        System.out.println("\n ALL BOOKINGS ");

        for (Booking booking : allBookings) {
            booking.display();
        }
    }

    // Cancel booking
    private static void cancelBooking() {

        try {

            System.out.print("Enter Booking ID to cancel: ");

            int bookingId = Integer.parseInt(
                    sc.nextLine().trim()
            );

            boolean cancelled =
                    bookingService.cancelBooking(bookingId);

            if (cancelled) {

                System.out.println(
                        "Booking cancelled successfully!"
                );

            } else {

                System.out.println("Booking ID not found.");
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter a valid booking ID."
            );
        }
    }
}
