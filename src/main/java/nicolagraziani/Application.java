package nicolagraziani;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nicolagraziani.dao.EventoDAO;
import nicolagraziani.entities.EventType;
import nicolagraziani.entities.Evento;
import nicolagraziani.exceptions.EventNotFoundException;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);

        Evento evento1 = new Evento("Concerto Rock Estate", LocalDate.of(2026, 7, 15), "Concerto all'aperto con band locali e ospiti internazionali", EventType.PUBBLICO, 500);
        Evento evento2 = new Evento("Fiera del libro", LocalDate.of(2026, 4, 10), "Evento culturale con autori, editori e presentazioni", EventType.PUBBLICO, 300);
        Evento evento3 = new Evento("Cena Aziendale Annuale", LocalDate.of(2026, 12, 6), "Evento riservato ai dipendenti con premiazioni", EventType.PRIVATO, 50);
        Evento evento4 = new Evento("Torneo di Calcio Amatoriale", LocalDate.of(2026, 6, 1), "Competizione sportiva tra squadre locali", EventType.PUBBLICO, 120);

//        eventoDAO.save(evento1);
//        eventoDAO.save(evento2);
//        eventoDAO.save(evento3);
//        eventoDAO.save(evento4);

        try {
            Evento searchedEvent = eventoDAO.getById(6);
            System.out.println(searchedEvent);
        } catch (EventNotFoundException e) {
            System.out.println(e.getMessage());
        }

        eventoDAO.delete(6);
//        eventoDAO.delete(3);
//        eventoDAO.delete(4);
//        eventoDAO.delete(5);
    }
}
