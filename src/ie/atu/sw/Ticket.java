 package ie.atu.sw;

import java.util.UUID;
import static java.util.Objects.requireNonNull;

public record Ticket(String id, Concert concert, Attendee attendee, double price, String advisory) {

    public Ticket(Concert concert, Attendee attendee, double price, String advisory) {
        this(UUID.randomUUID().toString(),concert, attendee, price, advisory);
    }
    public Ticket{
        requireNonNull(id);
        requireNonNull(concert);
        requireNonNull(attendee);
        requireNonNull(advisory);

        if (price < 0) {
            throw new IllegalStateException("Tickets can't be negatively priced");
        }
    }

}