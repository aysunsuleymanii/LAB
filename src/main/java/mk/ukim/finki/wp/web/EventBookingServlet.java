package mk.ukim.finki.wp.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.model.EventBooking;
import mk.ukim.finki.wp.service.EventBookingService;
import mk.ukim.finki.wp.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class EventBookingServlet extends HttpServlet {

    private final EventBookingService eventBookingService;
    private final EventService eventService;


    public EventBookingServlet(EventBookingService eventBookingService, EventService eventService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
    }

    @PostMapping("/eventBooking")
    public String handleEventBooking(@RequestParam String eventName,
                                     @RequestParam String attendeeName,
                                     @RequestParam String attendeeAddress,
                                     @RequestParam int numTickets,
                                     Model model) {
        EventBooking booking = eventBookingService.placeBooking(eventName, attendeeName, attendeeAddress, numTickets);

        model.addAttribute("booking", booking);
        return "booking-confirmation";
    }

    @GetMapping("/booking-confirmation")
    public String showBookingConfirmation(Model model) {
        return "bookingConfirmation";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String eventName = req.getParameter("eventName");
        String attendeeName = req.getParameter("attendeeName");
        String attendeeAddress = req.getParameter("attendeeAddress");
        int numTickets = Integer.parseInt(req.getParameter("numTickets"));

        req.setAttribute("booking", eventBookingService.placeBooking(eventName, attendeeName, attendeeAddress, numTickets));
        req.getRequestDispatcher("/templates/bookingConfirmation.html").forward(req, resp);
    }
}

