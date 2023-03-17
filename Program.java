package com.udemy.cursojavacompletonelioalves.exercicios.exercicioHotel;

import com.udemy.cursojavacompletonelioalves.exercicios.exercicioHotel.model.entities.Reservation;
import com.udemy.cursojavacompletonelioalves.exercicios.exercicioHotel.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = leitor.nextInt();
            System.out.print("Check- in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(leitor.next());
            System.out.print("Check- out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(leitor.next());


            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check- in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(leitor.next());
            System.out.print("Check- out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(leitor.next());

            reservation.updateDate(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

    }


}



