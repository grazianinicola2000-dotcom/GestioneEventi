package nicolagraziani.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import nicolagraziani.entities.Evento;
import nicolagraziani.exceptions.EventNotFoundException;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento newEvento) {
        //Prima di salvare(o in generale scrivere nel DB) bisogna "creare" una transazione
        EntityTransaction transaction = this.em.getTransaction();

        //Farla partire
        transaction.begin();

        //Ora bisogna rendere "persistente" il nuovo evento
        //Cosi facendo diventa MANAGED (sotto il controllo dell'EntityManager)
        em.persist(newEvento);

        //Per aggiungerlo alla taballa bisogna fare il commit della transazione
        transaction.commit();

        //Per rendere il tutto piu user friendly è buona cosa aggiungere un log
        System.out.println("l'Evento " + newEvento.getTitle() + " è stato salvato con successo!");
    }

    public Evento getById(long eventId) {
        Evento searched = em.find(Evento.class, eventId);
        if (searched == null) throw new EventNotFoundException(eventId);
        return searched;
    }

    public void delete(long eventId) {
        Evento searched = this.getById(eventId);
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.remove(searched);
        transaction.commit();
        System.out.println("L'evento " + searched.getTitle() + " è stato eliminato con successo");
    }
}
