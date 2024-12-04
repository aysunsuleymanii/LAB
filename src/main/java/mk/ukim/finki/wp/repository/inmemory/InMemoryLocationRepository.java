package mk.ukim.finki.wp.repository.inmemory;


import mk.ukim.finki.wp.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryLocationRepository {
    private List<Location> locations = new ArrayList<>();

    public InMemoryLocationRepository() {
        locations.add(new Location(1L, "Stadium", "123 Main St", "5000", "Outdoor sports facility"));
        locations.add(new Location(2L, "Concert Hall", "456 Oak Ave", "2000", "Indoor concert venue"));
        locations.add(new Location(3L, "Theater", "789 Pine Rd", "1500", "Cultural performances"));
        locations.add(new Location(4L, "Conference Center", "101 Maple St", "300", "Business events"));
        locations.add(new Location(5L, "Park", "202 Birch Dr", "10000", "Public park for events"));
    }


    public List<Location> findAll() {
        return locations;
    }

    public Optional<Location> findById(Long id) {
        return locations.stream().filter(l -> l.getId().equals(id)).findFirst();
    }
}

