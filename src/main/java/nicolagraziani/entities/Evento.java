package nicolagraziani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "events")
public class Evento {
    @Id // serve per dichiarare quale sara la PRIMARY KEY della tabella
    @GeneratedValue
    // Equivale al SERIAL, fa in modo che sia il DB a dare id univoco
    @Column(name = "event_id") // nome della colonna
    private UUID id; // e poi va dichiarata come attributo

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false, length = 8)
    private EventType type;

    @Column(name = "max_participants", nullable = false)
    private int maxParticipants;

    @OneToMany(mappedBy = "event")
    private List<Participation> participationList;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Evento() {
    }

    public Evento(String title, LocalDate eventDate, String description, EventType type, int maxParticipants) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.type = type;
        this.maxParticipants = maxParticipants;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public String getDescription() {
        return description;
    }

    public EventType getType() {
        return type;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}

