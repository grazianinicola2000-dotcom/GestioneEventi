package nicolagraziani.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID locationId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToMany(mappedBy = "location")
    private List<Evento> event;

    public Location() {
    }

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public List<Evento> getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", event=" + event +
                '}';
    }
}
