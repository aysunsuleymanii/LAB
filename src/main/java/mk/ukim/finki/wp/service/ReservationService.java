package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> findAll();

    void createReservation(String eventName, String userName, int ticketCount);

    List<Reservation> findAllByUserName(String userName);
}
