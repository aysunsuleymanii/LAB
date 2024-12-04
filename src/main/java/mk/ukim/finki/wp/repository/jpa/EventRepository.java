package mk.ukim.finki.wp.repository.jpa;


import mk.ukim.finki.wp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByLocation_Id(Long locationId);

    List<Event> searchEventsByName(String name);

    Optional<Event> findByName(String eventName);

    void deleteByName(String name);

    List<Event> findAllByLocationId(Long locationId);
}

