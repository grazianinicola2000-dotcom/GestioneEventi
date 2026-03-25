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

        try {
            em.getTransaction().begin();


            Location l1 = new Location("Parco Comunale", "Vicenza");
            Location l2 = new Location("San Siro", "Milano");
            Location l3 = new Location("Ristorante da Gino", "Padova");

            em.persist(l1);
            em.persist(l2);
            em.persist(l3);


            Evento evento1 = new Evento("Concerto Rock", LocalDate.of(2026, 7, 15), "Live music", EventType.PUBBLICO, 500);
            Evento evento2 = new Evento("Fiera Libro", LocalDate.of(2026, 4, 10), "Cultura", EventType.PUBBLICO, 300);
            Evento evento3 = new Evento("Cena Aziendale", LocalDate.of(2026, 12, 6), "Privato", EventType.PRIVATO, 50);


            evento1.setLocation(l1);
            evento2.setLocation(l1);
            evento3.setLocation(l2);

            em.persist(evento1);
            em.persist(evento2);
            em.persist(evento3);


            Person p1 = new Person("Nicola", "Graziani", "nicola@gmail.com", LocalDate.of(2000, 12, 16), Gender.M);
            Person p2 = new Person("Francesco", "Bortoletto", "fra@gmail.com", LocalDate.of(2000, 8, 28), Gender.M);
            Person p3 = new Person("Paola", "Bau", "paola@gmail.com", LocalDate.of(2000, 5, 4), Gender.F);

            em.persist(p1);
            em.persist(p2);
            em.persist(p3);


            Participation pa1 = new Participation(State.PENDING, p1, evento1);
            Participation pa2 = new Participation(State.CONFIRMED, p2, evento2);
            Participation pa3 = new Participation(State.CONFIRMED, p3, evento3);

            em.persist(pa1);
            em.persist(pa2);
            em.persist(pa3);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }


        em.close();
        emf.close();
    }
}
