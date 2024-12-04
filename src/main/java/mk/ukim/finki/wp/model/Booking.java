package mk.ukim.finki.wp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    String eventName;

    public Booking(String eventName) {
        this.eventName = eventName;
    }

    public Booking() {
    }
}
