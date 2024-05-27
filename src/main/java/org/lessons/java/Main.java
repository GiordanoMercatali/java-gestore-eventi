package org.lessons.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws InvalidDateException, InvalidSeatsException, InvalidPriceException {
        Scanner scanner = new Scanner(System.in);
        final int bookedSeats = 0;
        // Event event = createEvent(scanner, bookedSeats);
        Concert concert = createConcert(scanner, bookedSeats);
        boolean exit = false;

        while(!exit){
            System.out.println("0-Exit");
            System.out.println("1-Book seats");
            System.out.println("2-Cancel a reservation");            
            String choice = scanner.nextLine();

            switch (choice) {
                case "0":
                    exit = true;
                    break;
                case "1":
                // event.bookSeats(scanner);
                concert.bookSeats(scanner);
                    break;
                case "2":
                // event.cancelReservation(scanner);
                concert.cancelReservation(scanner);
                    break;
                default:
                    System.out.println("Choose a valid option!");
                    break;
            }
        } System.out.println(concert.toString());
        // System.out.println(event.toString());
    }

    private static Event createEvent(Scanner scanner, int bookedSeats) throws InvalidDateException, InvalidSeatsException{
        Event event = null;
        while(event == null){
            System.out.println("Insert event title: ");
            String title = scanner.nextLine();
    
            // System.out.println("Insert event date (yyyy-MM-dd): ");
            LocalDate date = getDate(scanner);

            System.out.println("Inserts total seats: ");
            int totalSeats = Integer.parseInt(scanner.nextLine());

            try{
                event = new Event(title, date, totalSeats, bookedSeats);
            } catch(IllegalArgumentException e){
                System.out.println("Something went wrong with the creation of this event!");
            }
        } return event;
    }

  private static LocalDate getDate(Scanner scanner) {
    LocalDate date = null;
    while (date == null) {
      System.out.print("Insert date (yyyy-MM-dd): ");
      String dateString = scanner.nextLine();
      try {
        date = LocalDate.parse(dateString);
      } catch (DateTimeParseException e) {
        System.out.println("Invalid date format: " + e.getMessage());
      }
    }
    return date;
  }

  private static Concert createConcert(Scanner scanner, int bookedSeats)
    throws InvalidDateException, InvalidSeatsException, InvalidPriceException {
    Concert concert = null;
    while(concert == null){
        System.out.println("Insert event title: ");
        String title = scanner.nextLine();

        // System.out.println("Insert event date (yyyy-MM-dd): ");
        LocalDate date = getDate(scanner);

        System.out.println("Inserts total seats: ");
        int totalSeats = Integer.parseInt(scanner.nextLine());

        // System.out.println("Insert event start time (HH:mm): ");
        LocalTime startTime = getTime(scanner);

        System.out.println("Inserts price: ");
        double price = Double.parseDouble(scanner.nextLine());

        try{
            concert = new Concert(title, date, totalSeats, bookedSeats, startTime, price);
        } catch(IllegalArgumentException e){
            System.out.println("Something went wrong with the creation of this event!");
        }
    } return concert;
}

private static LocalTime getTime(Scanner scanner) {
    LocalTime startTime = null;
    while (startTime == null) {
      System.out.print("Insert start time (HH:mm): ");
      String timeString = scanner.nextLine();
      try {
        startTime = LocalTime.parse(timeString);
      } catch (DateTimeParseException e) {
        System.out.println("Invalid time format: " + e.getMessage());
      }
    }
    return startTime;
  }

}