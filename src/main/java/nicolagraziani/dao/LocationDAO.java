package nicolagraziani.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import nicolagraziani.entities.Location;
import nicolagraziani.exceptions.LocationNotFoundException;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location newLocation) {
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(newLocation);
        transaction.commit();
        System.out.println("La location: " + newLocation.getName() + " è stata salvata con successo");
    }

    public Location getById(String locationId) {
        Location searched = em.find(Location.class, UUID.fromString(locationId));
        if (searched == null) throw new LocationNotFoundException(UUID.fromString(locationId));
        return searched;
    }

    public void delete(String locationId) {
        Location searched = this.getById(locationId);
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.remove(searched);
        transaction.commit();
        System.out.println("La location " + locationId + " è stata eliminata con successo");
    }
}
