package mk.ukim.finki.wp.repository.inmemory;

import mk.ukim.finki.wp.bootstrap.DataHolder;
import mk.ukim.finki.wp.model.Event;
import mk.ukim.finki.wp.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryEventRepository {


    public List<Event> findAll() {
        return DataHolder.events;
    }


    public List<Event> searchEvents(String text) {
        return DataHolder.events
                .stream()
                .filter(e -> e.getName().contains(text) || e.getDescription().contains(text))
                .collect(Collectors.toList());
    }

    public Optional<Event> save(String name, String description, double popularityScore, Location location) {
        Event newEvent = new Event(name, description, popularityScore, location);
        DataHolder.events.removeIf(e -> Objects.equals(e.getName(), name));
        DataHolder.events.add(newEvent);
        return Optional.of(newEvent);
    }


    public Optional<Event> findByName(String eventName) {
        return DataHolder.events
                .stream()
                .filter(e -> e.getName().toLowerCase().equals(eventName)).findFirst();
    }

    public void deleteById(Long id) {
        DataHolder.events.removeIf(i -> i.getId().equals(id));
    }

    public void delete(String name) {
        DataHolder.events.removeIf(i -> i.getName().equals(name));
    }

    public Optional<Event> findById(Long id) {
        return DataHolder.events.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }
}

