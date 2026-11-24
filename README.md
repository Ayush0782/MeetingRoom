# Meeting Room Booking System

## About the Project

The **Meeting Room Booking System** is a Java-based application designed to manage meeting room reservations efficiently. It allows users to create bookings, check room availability, retrieve existing bookings, and cancel reservations.

The system prevents overlapping bookings by validating the requested time against existing reservations. It also ensures that bookings follow the defined time-duration rules.

## Features

- **Book Meeting Room:** Create new meeting reservations with a unique booking ID.
- **Time Validation:** Validates start time, end time, and booking duration.
- **Overlap Detection:** Prevents multiple bookings for the same room during overlapping time slots.
- **View All Bookings:** Retrieves and sorts bookings by date and start time.
- **Cancel Booking:** Cancels an existing booking using its booking ID.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- LocalDate
- LocalTime
- Duration
- Comparator
- Lambda Expressions

## Core Methods

| Method | Description |
|---|---|
| `bookMeetingRoom()` | Validates booking details and creates a new booking. |
| `isOverlapping()` | Checks whether the requested booking overlaps with an existing booking. |
| `getAllBookings()` | Retrieves all bookings and sorts them by date and start time. |
| `cancelBooking()` | Removes an existing booking using its booking ID. |
| `Booking()` Constructor | Initializes a booking object with its ID, date, start time, and end time. |

## How the System Works

1. The user provides a booking date, start time, and end time.
2. The system validates the time and booking duration.
3. It checks for overlapping bookings on the selected date.
4. If the slot is available, a new Booking object is created.
5. The booking is stored in an ArrayList.
6. Users can retrieve all bookings or cancel a booking using its ID.

## Overlap Detection Logic

The system uses the following condition to detect overlapping bookings:

```java
startTime.isBefore(existingEnd) &&
endTime.isAfter(existingStart)
```

This condition checks whether the new booking starts before an existing booking ends and ends after the existing booking starts.

If both conditions are true, the booking overlaps and is rejected.

## Example

**Existing Booking:** 10:00 AM – 11:00 AM

| Requested Time | Result |
|---|---|
| 9:00 AM – 10:00 AM | Allowed |
| 10:30 AM – 11:30 AM | Rejected |
| 11:00 AM – 12:00 PM | Allowed |

## Project Structure

```text
MeetingRoomBookingSystem/
│
├── Booking.java
├── BookingService.java
└── Main.java
```

- **Booking.java:** Represents a booking and stores its details.
- **BookingService.java:** Contains the booking creation, availability checking, retrieval, and cancellation logic.
- **Main.java:** Entry point for executing and testing the application.

## Learning Outcomes

- Understanding Object-Oriented Programming concepts in Java.
- Working with ArrayList to store and manage objects.
- Using LocalDate and LocalTime for date and time handling.
- Implementing booking conflict detection logic.
- Using Comparator for sorting data.
- Applying Lambda Expressions with collections.

## Future Enhancements

- Integrate a database to persist bookings.
- Develop a web-based user interface.
- Add user authentication.
- Support multiple meeting rooms.
- Implement REST APIs using Spring Boot.

---

**Developed as a Java project to practice object-oriented programming, collection handling, date-time validation, and real-world booking management logic.**
