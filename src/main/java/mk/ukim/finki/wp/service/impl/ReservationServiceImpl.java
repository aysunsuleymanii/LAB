package mk.ukim.finki.wp.service.impl;


import mk.ukim.finki.wp.model.Reservation;
import mk.ukim.finki.wp.repository.jpa.ReservationRepository;
import mk.ukim.finki.wp.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return List.of();
    }

    @Override
    public void createReservation(String eventName, String userName, int ticketCount) {
        Reservation reservation = new Reservation();
        reservation.setEventName(eventName);
        reservation.setUserName(userName);
        reservation.setTicketCount(ticketCount);
        reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAllByUserName(String userName) {
        return reservationRepository.findByUserName(userName);
    }
}

