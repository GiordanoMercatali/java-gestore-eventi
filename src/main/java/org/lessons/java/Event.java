package org.lessons.java;

import java.time.LocalDate;

public class Event {
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int bookedSeats;
    
    public Event(String title, LocalDate date, int totalSeats, int bookedSeats) throws InvalidDateException, InvalidSeatsException{
        this.title = title;
        this.date = validateDate(date);
        this.totalSeats = validateSeats(totalSeats);
        // this.bookedSeats = bookedSeats;
        this.bookedSeats = 0;
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
            throw new InvalidDateException("This date has passed! Try another");
        else
            return date;
    }

    /* SEATS METHODS */
    /* Total seats */
    public int getSeats(){
        return totalSeats;
    }

    public void setSeats(int totalSeats) throws InvalidSeatsException{
        this.totalSeats = validateSeats(totalSeats);
    }

    private int validateSeats(int totalSeats) throws InvalidSeatsException{
        if (totalSeats <= 0)
            throw new InvalidSeatsException("Total seats can't be 0 or less!");
        else
            return totalSeats;
    }
    
    /* Booked seats */
    public int getBookedSeats(){
        return bookedSeats;
    }
    
}
