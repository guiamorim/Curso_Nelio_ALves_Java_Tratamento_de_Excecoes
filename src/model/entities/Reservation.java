package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;

    public Reservation(Integer roomNumber, LocalDate checkinDate, LocalDate checkoutDate) {
        this.roomNumber = roomNumber;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public Reservation() {
    }

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public long  duration(){
        return ChronoUnit.DAYS.between(checkinDate, checkoutDate);
    }

    public void updateDates(LocalDate checkinDate, LocalDate checkoutDate) {
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber
                + ", check-in Date: " + dtf.format(checkinDate)
                + ", check-out Date: " + dtf.format(checkoutDate)
                + ", " + duration() + " nights";
    }
}
