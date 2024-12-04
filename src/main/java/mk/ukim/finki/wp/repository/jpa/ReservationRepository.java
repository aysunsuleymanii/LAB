package mk.ukim.finki.wp.repository.jpa;

import mk.ukim.finki.wp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUserName(String userName);

    List<Reservation> findByUserName(String userName);
}
