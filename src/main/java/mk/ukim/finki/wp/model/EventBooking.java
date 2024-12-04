package mk.ukim.finki.wp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EventBooking {
    @Id
    String eventName;
    String attendeeName;
    String attendeeAddress;
    Long numberOfTickets;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.eventName = eventName;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }

    public EventBooking() {
    }

    public String getEventName() {
        return eventName;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public String getAttendeeAddress() {
        return attendeeAddress;
    }

    public Long getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public void setAttendeeAddress(String attendeeAddress) {
        this.attendeeAddress = attendeeAddress;
    }

    public void setNumberOfTickets(Long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
