package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws InvalidDateException, InvalidSeatsException {
        Scanner scanner = new Scanner(System.in);
        final int bookedSeats = 0;
        Event event = createEvent(scanner, bookedSeats);
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
                event.bookSeats(scanner);
                    break;
                case "2":
                event.cancelReservation(scanner);
                    break;
                default:
                    System.out.println("Choose a valid option!");
                    break;
            }
        } System.out.println(event.toString());
    }

    private static Event createEvent(Scanner scanner, int bookedSeats) throws InvalidDateException, InvalidSeatsException{
        Event event = null;
        while(event == null){
            System.out.println("Insert event title: ");
            String title = scanner.nextLine();
    
            System.out.println("Insert event date (yyyy-MM-dd): ");
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

}