package nicolagraziani;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nicolagraziani.dao.EventoDAO;
import nicolagraziani.dao.LocationDAO;
import nicolagraziani.dao.ParticipationDAO;
import nicolagraziani.dao.PersonDAO;
import nicolagraziani.entities.*;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);
        PersonDAO pd = new PersonDAO(em);
        ParticipationDAO pad = new ParticipationDAO(em);
        LocationDAO ld = new LocationDAO(em);

//        Location l1 = ld.getById("b3e1c227-1650-446b-8671-6d5130154f2c");
//        Location l2 = ld.getById("07d5edd9-1b9a-4411-b8ff-1318da038892");
//        Location l3 = ld.getById("2ed2e394-a67d-4dce-9b09-f087bef0af2a");

        Evento evento1 = new Evento("Concerto Rock Estate", LocalDate.of(2026, 7, 15), "Concerto all'aperto con band locali e ospiti internazionali", EventType.PUBBLICO, 500);
        Evento evento2 = new Evento("Fiera del libro", LocalDate.of(2026, 4, 10), "Evento culturale con autori, editori e presentazioni", EventType.PUBBLICO, 300);
        Evento evento3 = new Evento("Cena Aziendale Annuale", LocalDate.of(2026, 12, 6), "Evento riservato ai dipendenti con premiazioni", EventType.PRIVATO, 50);
        Evento evento4 = new Evento("Torneo di Calcio Amatoriale", LocalDate.of(2026, 6, 1), "Competizione sportiva tra squadre locali", EventType.PUBBLICO, 120);
        Evento evento5 = new Evento("Conserto di beneficenza", LocalDate.of(2026, 6, 1), "Competizione sportiva tra squadre locali", EventType.PUBBLICO, 120);

//        Person p1 = new Person("Nicola", "Graziani", "graziani.nicola@gmail.com", LocalDate.of(2000, 12, 16), Gender.M);
//        Person p2 = new Person("Francesco", "Bortoletto", "bortoletto.francesco@gmail.com", LocalDate.of(2000, 8, 28), Gender.M);
//        Person p3 = new Person("Paola", "Bau", "bau.paolao@gmail.com", LocalDate.of(2000, 5, 4), Gender.F);

//        Location l1 = new Location("parco comunale", "Vicenza");
//        Location l2 = new Location("Stadio San Siro", "Milano");
//        Location l3 = new Location("Ristorante da Gino", "Padova");

//        ld.save(l1);
//        ld.save(l2);
//        ld.save(l3);

//        evento1.setLocation(l1);
//        evento2.setLocation(l1);
//        evento3.setLocation(l2);
//        evento4.setLocation(l2);
//        evento5.setLocation(l3);
//
//        eventoDAO.save(evento1);
//        eventoDAO.save(evento2);
//        eventoDAO.save(evento3);
//        eventoDAO.save(evento4);
//        eventoDAO.save(evento5);

        Evento e1 = eventoDAO.getById("01f4f0e9-351c-4a00-bc1e-f7053428f64a");
        Evento e2 = eventoDAO.getById("6095866d-a7f3-448a-83e4-421739632a14");
        Evento e3 = eventoDAO.getById("ff9f7ae1-15d8-4c92-abf8-3e07293d2f2a");


        Person p1 = pd.getById("2f864d86-4572-4241-8cf4-004d9649c42d");
        Person p2 = pd.getById("5f2326e0-4322-4c09-bccf-bd56c0a92eee");
        Person p3 = pd.getById("8c8368f2-be5e-41a8-a27e-e55a11af1f36");
//
        Participation pa1 = new Participation(State.CONFIRMED, p1, e1);
        Participation pa2 = new Participation(State.CONFIRMED, p2, e2);
        Participation pa3 = new Participation(State.CONFIRMED, p3, e3);

        pad.save(pa1);
        pad.save(pa2);
        pad.save(pa3);


        em.close();
        emf.close();
    }
}
