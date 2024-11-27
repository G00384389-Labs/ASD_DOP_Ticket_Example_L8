package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public record Attendee(String id, String name, String email, List<Ticket> tickets) {

	public Attendee(String name, String email, List<Ticket> tickets) {
		this(UUID.randomUUID().toString(), name, email, List.copyOf(tickets));
	}

	public Attendee {
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(email);
	}

	//	generate hashcode by source>generateHashCode&Equals>Yes>All the user attributes
	@Override
	public int hashCode() {
		return Objects.hash(email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		//	comapres attendees by if their email id and name match
		if (obj instanceof Attendee other) {
			return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name);

		}else {
			return false;
		}
	};

};
