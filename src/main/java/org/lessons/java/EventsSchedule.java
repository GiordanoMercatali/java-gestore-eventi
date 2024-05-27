package org.lessons.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EventsSchedule {
    private String title;
    private List<Event> events;

    public EventsSchedule(String title, List<Event> events) {
        if (title == null || title.isEmpty() || events == null) {
            throw new IllegalArgumentException("Invalid title or events list");
        }
        this.title = title;
        this.events = events;
    }

    @Override
    public String toString() {
        return "Schedule title: " + title + ", Scheduled events: " + events + "\n";
    }
}