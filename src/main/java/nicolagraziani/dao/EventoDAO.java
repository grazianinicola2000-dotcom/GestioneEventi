package nicolagraziani.dao;

import jakarta.persistence.EntityManager;
import nicolagraziani.entities.Evento;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento newEvento) {
    }
}
