package org.lessons.java;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{

    private LocalTime startTime;
    private double price;

    public Concert(String title, LocalDate date, int totalSeats, int bookedSeats, LocalTime startTime, double price)
            throws InvalidDateException, InvalidSeatsException, InvalidPriceException {
        super(title, date, totalSeats, bookedSeats);
        this.startTime = validateTime(startTime);
        this.price = validatePrice(price);
    }

    /* START TIME */
    public void setTime(LocalDate date) throws InvalidDateException{
        this.startTime = validateTime(startTime);
    }

    private LocalTime validateTime(LocalTime startTime) throws InvalidDateException{
        if (startTime.isBefore(LocalTime.now()))
            throw new InvalidDateException(startTime + " has already passed! Try again");
        else
            return startTime;
    }

    public LocalTime getTime(){
        return startTime;
    }
    
    /* PRICE */
    public void setTime(double price) throws InvalidPriceException{
        this.price = validatePrice(price);
    }

    private double validatePrice(double price) throws InvalidPriceException{
        if (price < 0)
            throw new InvalidPriceException("Price can't be negative!");
        else
            return price;
    }

    public double getPrice(){
        return price;
    }

    /* OVERRIDE TO STRING */
    @Override
    public String toString() {
        return  "Title: " + getTitle() + ", Date: " + getDate() + ", Start time: " + getTime() + ", Total seats: " + getSeats() +
        ", Seats already reserved: "+ getBookedSeats() + ", Price: " + getPrice() + "$" + "\n";
    }
}
