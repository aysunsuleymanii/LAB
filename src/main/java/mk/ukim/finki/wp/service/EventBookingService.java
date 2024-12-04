package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.EventBooking;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
}
