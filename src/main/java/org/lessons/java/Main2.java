package org.lessons.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    
    public static void main(String[] args) throws InvalidDateException, InvalidSeatsException, InvalidPriceException {
        Scanner scanner = new Scanner(System.in);
        final int bookedSeats = 0;
        // Event event = createEvent(scanner, bookedSeats);
        boolean exit = false;

        EventsSchedule eventsSchedule = createSchedule(scanner, exit);

        System.out.println(eventsSchedule.toString());

        List<Event> eventsOnDate = eventsSchedule.getEventsByDate(scanner);
        System.out.println("These events happen in the chosen date: " + eventsOnDate);
        
    }

    private static EventsSchedule createSchedule(Scanner scanner, boolean exit) throws InvalidDateException, InvalidSeatsException {
        // EventsSchedule eventsSchedule = null;
    
        System.out.println("Schedule title");
        String title = scanner.nextLine();
        EventsSchedule eventsSchedule = new EventsSchedule(title);
        // List<Event> events = new ArrayList<>();
        
    
        while (!exit) {
            System.out.println("0-Exit");
            System.out.println("1-Add event");
            String choice = scanner.nextLine();
    
            switch (choice) {
                case "0":
                    exit = true;
                    break;
                case "1":
                    Event event = createEvent(scanner, 0);
                    eventsSchedule.addEvent(event);
                    // events.add(event);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
        return eventsSchedule;
    }
    
    

    private static Event createEvent(Scanner scanner, int bookedSeats) throws InvalidDateException, InvalidSeatsException{
        Event event = null;
        while(event == null){
            System.out.println("Insert event title: ");
            String title = scanner.nextLine();
    
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