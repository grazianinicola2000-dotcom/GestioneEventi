package nicolagraziani.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "participation")
public class Participation {
    @Id
    @GeneratedValue
    @Column(name = "participation_id")
    private UUID participationId;

    @Column(name = "state")
    private State state;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Evento event;

    public Participation() {
    }

    public Participation(State state, Person person, Evento event) {
        this.state = state;
        this.event = event;
        this.person = person;
    }

    public UUID getParticipationId() {
        return participationId;
    }

    public State getState() {
        return state;
    }

    public Person getPerson() {
        return person;
    }

    public Evento getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "participationId=" + participationId +
                ", state=" + state +
                ", person=" + person +
                ", event=" + event +
                '}';
    }
}
