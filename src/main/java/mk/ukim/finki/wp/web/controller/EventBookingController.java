package mk.ukim.finki.wp.web.controller;


import mk.ukim.finki.wp.model.Reservation;
import mk.ukim.finki.wp.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventBookingController {
    private final ReservationService reservationService;


    public EventBookingController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reserve")
    public String showReserveForm() {
        // Show the reservation form
        return "listEvents";
    }


    @PostMapping("/reserve")
    public String createReservation(@RequestParam String eventName,
                                    @RequestParam String userName,
                                    @RequestParam int ticketCount,
                                    Model model) {
//        Reservation reservation = new Reservation();
//        reservation.setEventName(eventName);
//        reservation.setUserName(userName);
//        reservation.setTicketCount(ticketCount);

        reservationService.createReservation(eventName, userName, ticketCount);
        List<Reservation> reservations = reservationService.findAllByUserName(userName);

        model.addAttribute("reservations", reservations);

        return "bookingConfirmation";
    }

}
