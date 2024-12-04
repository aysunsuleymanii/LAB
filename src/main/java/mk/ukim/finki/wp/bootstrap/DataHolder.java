package mk.ukim.finki.wp.bootstrap;


import jakarta.annotation.PostConstruct;

import mk.ukim.finki.wp.model.Event;
import mk.ukim.finki.wp.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Event> events = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Create location objects
        Location location1 = new Location(1L, "Stadium", "123 Main St", "5000", "Outdoor sports facility");
        Location location2 = new Location(2L, "Concert Hall", "456 Oak Ave", "2000", "Indoor concert venue");
        Location location3 = new Location(3L, "Theater", "789 Pine Rd", "1500", "Cultural performances");
        Location location4 = new Location(4L, "Conference Center", "101 Maple St", "300", "Business events");
        Location location5 = new Location(5L, "Park", "202 Birch Dr", "10000", "Public park for events");

        // Add events with associated locations
        events.add(new Event("Birthday", "celebration", 10, location1));
        events.add(new Event("Conference", "business", 20, location2));
        events.add(new Event("Wedding", "celebration", 50, location3));
        events.add(new Event("Concert", "music", 200, location2));
        events.add(new Event("Meeting", "business", 5, location4));
        events.add(new Event("Festival", "entertainment", 100, location1));
        events.add(new Event("Workshop", "education", 30, location3));
        events.add(new Event("Party", "celebration", 150, location5));
        events.add(new Event("Seminar", "education", 40, location4));
        events.add(new Event("Exhibition", "art", 60, location2));
    }
}


