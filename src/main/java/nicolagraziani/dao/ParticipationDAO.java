package nicolagraziani.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import nicolagraziani.entities.Evento;
import nicolagraziani.entities.Participation;
import nicolagraziani.exceptions.ParticipationNotFoundException;

import java.util.UUID;

public class ParticipationDAO {
    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Participation newParticipation) {
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(newParticipation);
        transaction.commit();
        System.out.println(newParticipation.getPerson() + " parteciperà all'evento: " + newParticipation.getEvent());
    }

    public Evento getById(String participationId) {
        Evento searched = em.find(Evento.class, UUID.fromString(participationId));
        if (searched == null) throw new ParticipationNotFoundException(UUID.fromString(participationId));
        return searched;
    }

    public void delete(String participationId) {
        Evento searched = this.getById(participationId);
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.remove(searched);
        transaction.commit();
        System.out.println("La partecipazione " + participationId + " è stata eliminata con successo");
    }
}
