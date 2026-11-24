
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookingService {

    private ArrayList<Booking> bookings = new ArrayList<>();

    private int nextBookingId = 1;

    // Create a new booking
    public Booking bookMeetingRoom(
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime) {

        // Validate end time
        if (!endTime.isAfter(startTime)) {
            throw new IllegalArgumentException(
                    "End time must be after start time."
            );
        }

        // Validate exactly one hour
        long duration = Duration.between(
                startTime, endTime
        ).toMinutes();

        if (duration != 60) {
            throw new IllegalArgumentException(
                    "Only 1-hour booking slots are allowed."
            );
        }

        // Check overlapping bookings
        if (isOverlapping(date, startTime, endTime)) {
            throw new IllegalArgumentException(
                    "Meeting room is already booked for this time slot."
            );
        }

        // Create booking
        Booking booking = new Booking(
                nextBookingId++,
                date,
                startTime,
                endTime
        );

        bookings.add(booking);

        return booking;
    }

    // Check overlapping bookings
    private boolean isOverlapping(
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime) {

        for (Booking booking : bookings) {

            if (booking.getDate().equals(date)) {

                LocalTime existingStart =
                        booking.getStartTime();

                LocalTime existingEnd =
                        booking.getEndTime();

                if (startTime.isBefore(existingEnd) &&
                        endTime.isAfter(existingStart)) {

                    return true;
                }
            }
        }

        return false;
    }

    // View all bookings
    public List<Booking> getAllBookings() {

        ArrayList<Booking> sortedBookings =
                new ArrayList<>(bookings);

        sortedBookings.sort(
                Comparator.comparing(Booking::getDate)
                        .thenComparing(Booking::getStartTime)
        );

        return sortedBookings;
    }

    // Cancel booking
    public boolean cancelBooking(int bookingId) {

        return bookings.removeIf(
                booking -> booking.getBookingId() == bookingId
        );
    }
}
