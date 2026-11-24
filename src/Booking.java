
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Booking {

    private int bookingId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Booking(int bookingId, LocalDate date,
                   LocalTime startTime, LocalTime endTime) {

        this.bookingId = bookingId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void display() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(
                "Booking ID: " + bookingId +
                        " | Date: " + date.format(formatter) +
                        " | Start: " + startTime +
                        " | End: " + endTime
        );
    }
}

