package mk.ukim.finki.wp.web.controller;


import mk.ukim.finki.wp.model.Event;
import mk.ukim.finki.wp.model.Location;
import mk.ukim.finki.wp.service.EventService;
import mk.ukim.finki.wp.service.LocationService;
import mk.ukim.finki.wp.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EventController {

    private EventService eventService;
    private LocationService locationService;
    private ReservationService reservationService;

//    public EventController(EventService eventService, LocationService locationService) {
//        this.eventService = eventService;
//        this.locationService = locationService;
//    }


    public EventController(EventService eventService, LocationService locationService, ReservationService reservationService) {
        this.eventService = eventService;
        this.locationService = locationService;
        this.reservationService = reservationService;
    }

    @GetMapping("/events")
    public String getEventsPage(Model model) {
        model.addAttribute("events", eventService.listAll());
        return "listEvents";
    }

    @GetMapping("/events/add")
    public String getAddEventPage(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "add-event";
    }

    @PostMapping("/events/add")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam int popularityScore,
                            @RequestParam Long locationId) {
        Optional<Location> location = locationService.findById(locationId);

        if (location.isEmpty()) {
            return "redirect:/events/add";
        }
        eventService.save(name, description, popularityScore, locationId);
        return "redirect:/events";
    }

    @GetMapping("/events/edit/{id}")
    public String getEditEventPage(@PathVariable Long id, Model model) {
        Optional<Event> event = eventService.findById(id);
        if (event.isEmpty()) {
            return "redirect:/events";
        }
        model.addAttribute("event", event.get());
        model.addAttribute("name", event.get().getName());
        model.addAttribute("location", event.get().getLocation());
        model.addAttribute("locations", locationService.findAll());
        return "add-event";
    }

    @PostMapping("/events/edit/{id}")
    public String editEvent(@PathVariable Long id,
                            @RequestParam String name,
                            @RequestParam String description,
                            @RequestParam int popularityScore,
                            @RequestParam Long locationId) {
        Optional<Event> event = eventService.findById(id);
        if (event.isEmpty()) {
            return "redirect:/events";
        }
//        eventService.save(name, description, popularityScore, locationId);
//        return "redirect:/events";

        Event existingEvent = event.get();
        existingEvent.setName(name);
        existingEvent.setDescription(description);
        existingEvent.setPopularityScore(popularityScore);
        existingEvent.setLocation(locationService.findById(locationId).orElse(null));

        eventService.save(existingEvent.getName(), existingEvent.getDescription(), existingEvent.getPopularityScore(), existingEvent.getId());  // Save method should be able to handle both create and update

        return "redirect:/events";
    }

    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        return "redirect:/events";
    }

    @GetMapping("/reservations")
    public String getAllReservations(Model model) {
        model.addAttribute("reservations", reservationService.findAll()); // Adjust based on your service
        return "reservations";
    }


    @GetMapping("events/filter")
    public String getEventsByLocation(@RequestParam Long locationId, Model model) {
        model.addAttribute("events", eventService.getEventsByLocationId(locationId));
        model.addAttribute("locations", locationService.findAll());
        return "listEvents";
    }

    @GetMapping("/test/locations")
    @ResponseBody
    public List<Location> testLocations() {
        return locationService.findAll();
    }

}