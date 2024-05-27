package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidDateException, InvalidSeatsException {
        Scanner scanner = new Scanner(System.in);

        Event event = createEvent(scanner);
        System.out.println(event.toString());
    }

    private static Event createEvent(Scanner scanner) throws InvalidDateException, InvalidSeatsException{
        Event event = null;
        while(event == null){
            System.out.println("Insert event title: ");
            String title = scanner.nextLine();
    
            System.out.println("Insert event date (yyyy-MM-dd): ");
            LocalDate date = getDate(scanner);

            System.out.println("Inserts total seats: ");
            int totalSeats = Integer.parseInt(scanner.nextLine());

            try{
                event = new Event(title, date, totalSeats, 0);
            } catch(IllegalArgumentException e){
                System.out.println("Error");
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