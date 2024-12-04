package mk.ukim.finki.wp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String capacity;

    private String description;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private List<Event> events;

    public Location(Long id, String name, String address, String capacity, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
    }


    public Location() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public List<Event> getEvents() {
        return events;
    }
}

