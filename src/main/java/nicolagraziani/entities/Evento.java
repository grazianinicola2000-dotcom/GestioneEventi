package nicolagraziani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "events")
public class Evento {
    @Id // serve per dichiarare quale sara la PRIMARY KEY della tabella
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Equivale al SERIAL, fa in modo che sia il DB a dare id univoco
    @Column(name = "event_id") // nome della colonna
    private long id; // e poi va dichiarata come attributo

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

    public Evento() {
    }

    public Evento(String title, LocalDate eventDate, String description, EventType type, int maxParticipants) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.type = type;
        this.maxParticipants = maxParticipants;
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

    public long getId() {
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

