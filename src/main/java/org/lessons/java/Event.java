package org.lessons.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Event {
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int bookedSeats;
    
    public Event(String title, LocalDate date, int totalSeats, int bookedSeats) throws InvalidDateException, InvalidSeatsException{
        this.title = title;
        this.date = validateDate(date);
        this.totalSeats = validateSeats(totalSeats);
        this.bookedSeats = bookedSeats;
        // this.bookedSeats = 0;
    }

    /* TITLE METHOD */
    public String getTitle(){
        return title;
    }

    /* DATE METHODS */
    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date) throws InvalidDateException{
        this.date = validateDate(date);
    }

    private LocalDate validateDate(LocalDate date) throws InvalidDateException{
        if (date.isBefore(LocalDate.now()))
            throw new InvalidDateException(date + " has already passed! Try another date");
        else
            return date;
    }

    /* SEATS METHODS */
    /* Total seats */
    public int getSeats(){
        return totalSeats;
    }

    // public void setSeats(int totalSeats) throws InvalidSeatsException{
    //     this.totalSeats = validateSeats(totalSeats);
    // }

    private int validateSeats(int totalSeats) throws InvalidSeatsException{
        if (totalSeats <= 0)
            throw new InvalidSeatsException("Total seats can't be " + totalSeats + " or less!");
        else
            return totalSeats;
    }
    
    /* Booked seats */
    public int getBookedSeats(){
        return bookedSeats;
    }

    /* BOOK METHOD */

    public int bookSeats(Scanner scanner) throws InvalidSeatsException{
        System.out.println("How many seats do you want to book?");
        int seatsToBook = Integer.parseInt(scanner.nextLine());
        if(seatsToBook > totalSeats){
            System.out.println("You're trying to book more seats than there are!");
        } else {
            bookedSeats += seatsToBook;
            totalSeats -= seatsToBook;
        }
        
        return bookedSeats;
    }

    /* CANCEL METHOD */
    public int cancelReservation(Scanner scanner) throws InvalidSeatsException{
        System.out.println("How many reservations do you want to cancel?");
        int reservationsToCancel = Integer.parseInt(scanner.nextLine());
        if(reservationsToCancel > bookedSeats){
            System.out.println("You're trying to cancel more reservations than there are!");
        } else {
            bookedSeats -= reservationsToCancel;
            totalSeats += reservationsToCancel;
        }
        return bookedSeats;
    }

    /* OVERRIDE TO STRING */
    @Override
    public String toString() {
        return  "Title: " + getTitle() + ", Date: " + getDate() + ", Total seats: " + getSeats() + ", Seats already reserved: " + getBookedSeats() + "\n";
    }
    
}
