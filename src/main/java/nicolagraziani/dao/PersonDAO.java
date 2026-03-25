package nicolagraziani.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import nicolagraziani.entities.Person;
import nicolagraziani.exceptions.PersonNotFoundException;

import java.util.UUID;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person newPerson) {
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(newPerson);
        transaction.commit();
        System.out.println(newPerson.getName() + " " + newPerson.getSurname() + " registrato con successo!");
    }

    public Person getById(String personId) {
        Person searched = em.find(Person.class, UUID.fromString(personId));
        if (searched == null) throw new PersonNotFoundException(UUID.fromString(personId));
        return searched;
    }

    public void delete(String personId) {
        Person searched = this.getById(personId);
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.remove(searched);
        transaction.commit();
        System.out.println("La persona " + searched.getName() + searched.getSurname() + " è stata eliminata con successo");
    }
}
