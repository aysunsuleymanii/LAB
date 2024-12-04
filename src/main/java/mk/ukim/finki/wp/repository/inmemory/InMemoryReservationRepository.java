package mk.ukim.finki.wp.repository.inmemory;

import mk.ukim.finki.wp.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryReservationRepository {
    private final List<Reservation> reservations = new ArrayList<>();

    public void save(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> findAll() {
        return reservations;
    }
}

