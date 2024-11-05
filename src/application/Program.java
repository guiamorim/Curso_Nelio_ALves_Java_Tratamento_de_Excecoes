package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = sc.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkin = LocalDate.parse(sc.next(), dft);

        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkout = LocalDate.parse(sc.next(), dft);

        LocalDate now = LocalDate.now();
        Reservation reservation = new Reservation();

        //Operation 1 - Reservation Registry.
        // Validation step 1.1 - to check if the dates are future dates.
        if(checkin.isBefore(now) || checkout.isBefore(now)) {
            System.out.println("Error in reservation: Reservation dates must be in future dates.");
        }//Validation step 1.1 - to check if the check-out date are greater than check-in date
        else if(!checkout.isAfter(checkin)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        }
        else {
            reservation.setRoomNumber(number);
            reservation.updateDates(checkin, checkout);
            System.out.println(reservation);
        }
        System.out.println();

        // Operation 2 - Reservation updating.
        System.out.println("Enter date to update the reservation");

        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkin = LocalDate.parse(sc.next(), dft);

        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkout = LocalDate.parse(sc.next(), dft);

        // Validation step 2.1 - to check if the dates are future dates.
        if(checkin.isBefore(now) || checkout.isBefore(now)) {
            System.out.println("Error in reservation: Reservation dates for update must be in future dates.");
        }// Validation step 2.2 - to check if the check-out date are greater than check-in date.
        else if (!checkout.isAfter(checkin)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            reservation.updateDates(checkin, checkout);
            System.out.println(reservation);
        }







        sc.close();
    }
}