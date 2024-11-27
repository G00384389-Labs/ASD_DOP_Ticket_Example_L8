 package ie.atu.sw;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TicketSystem {

    public static Ticket purchase(TicketOperation.Purchase pur) {
        return purchase(pur.attendee(), pur.concert(), pur.price());
    }

    public static Ticket purchase(Attendee attendee, Concert concert, double price) {
        var advisory = "";
        return new Ticket(concert, attendee, price, advisory);
    }

    public static String advisory(TicketOperation.Advisory adv) {
        var opt = advisory(adv.venue());
        return opt.isPresent() ? opt.get() : "Enjoy the concert";
    }

    public static Optional<String> advisory(Venue venue) {
        var sb = new StringBuilder();
        if (!venue.country().isEUMember())
            sb.append("bring a passport if travelling.");

        if (venue.country().temperature() >= 13.00d)
            sb.append("bring light clothing");
        if (venue.country().precipitation() >= 1000)
            sb.append("bring waterproof clothing");
        if (venue.capacity() > 10_000) sb.append("Large crowds expected");

        sb.append(
        switch(venue.type()) {
        case AMPHITHEATER, ARENA, STADIUM -> "Venue is tiered seating";
        default -> "";
        });
        return sb.length()  > 0 ? Optional.of(sb.toString()) : Optional.of(null);
    }

    public static Collection<Concert> search(TicketOperation.Search sch) {
        return search(sch.concerts(), sch.criteria());
    }

    public static Collection<Concert> search(Collection<Concert> concerts, Predicate<Concert> criteria) {
        return concerts.stream().filter(criteria).collect(Collectors.toList());
    }

}