package com.udemy.cursojavacompletonelioalves.exercicios.exercicioHotel;

import com.udemy.cursojavacompletonelioalves.exercicios.exercicioHotel.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = leitor.nextInt();
        System.out.print("Check- in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(leitor.next());
        System.out.print("Check- out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(leitor.next());

        Reservation reservation = null;
        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check- in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(leitor.next());
            System.out.print("Check- out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(leitor.next());


        }
        String error = reservation.updateDate(checkIn, checkOut);
        if (error != null) {
            System.out.println(error);
        } else {
            System.out.println(reservation);

        }
        leitor.close();
    }

}

