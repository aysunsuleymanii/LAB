package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();

    List<Event> searchEvents(String text);

    Optional<Event> findByName(String eventName);

    Optional<Event> findById(Long id);

    void delete(String name);

    void deleteById(Long id);

    Optional<Event> save(String name, String description, double popularityScore, Long locationId);


    public List<Event> getEventsByLocationId(Long locationId);



}
