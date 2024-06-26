package org.lessons.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class EventsSchedule {
    private String title;
    private List<Event> events;

    public EventsSchedule(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Invalid title or events list");
        }
        this.title = title;
        this.events = new ArrayList<>();
    }

    public String getTitle(){
        return title;
    }
    
    public void addEvent(Event event){
        events.add(event);
    }

    @Override
    public String toString() {
        return "Schedule title: " + title + ", Scheduled events: " + events + "\n";
    }

    
    public List<Event> getEventsByDate(Scanner scanner){
        System.out.println("Insert event date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateString);
        
        List<Event> eventsThisDate = new ArrayList<>();
            for(Event event : events){
                if(date.equals(event.getDate())){
                    eventsThisDate.add(event);
                }
            } return eventsThisDate;
    }

    public int getEventsNumber(){
        return events.size();
    }

    public void emptyList(Scanner scanner){

        System.out.println("0-Empty list");    
        String choice = scanner.nextLine();

        switch (choice) {
            case "0":
                events = Collections.<Event>emptyList();
                break;
            default:
                break;
        }
    }

    // @Override
    // public int compareTo(Object o){
    //     for(Event event : events){
    //         return date.compareTo(event.date)
    // }
}