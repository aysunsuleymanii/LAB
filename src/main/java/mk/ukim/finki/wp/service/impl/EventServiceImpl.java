package mk.ukim.finki.wp.service.impl;


import mk.ukim.finki.wp.model.Event;
import mk.ukim.finki.wp.model.Location;
import mk.ukim.finki.wp.repository.jpa.EventRepository;
import mk.ukim.finki.wp.repository.jpa.LocationRepository;
import mk.ukim.finki.wp.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;


    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.searchEventsByName(text);
    }

    @Override
    public Optional<Event> findByName(String eventName) {
        return this.eventRepository.findByName(eventName);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public void delete(String name) {
        eventRepository.deleteByName(name);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }


    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Long locationId) {
        Location location = locationRepository.findById(locationId).orElse(null);
        if (location == null) {
            return Optional.empty();
        }

        Event event = new Event(name, description, popularityScore, location);
        return Optional.of(eventRepository.save(event));
    }


    @Override
    public List<Event> getEventsByLocationId(Long locationId) {
        return eventRepository.findAllByLocation_Id(locationId);
    }

}
