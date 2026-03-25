package nicolagraziani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private UUID personId;

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String surname;
    @Column(nullable = false, length = 100)
    private String mail;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 1)
    private Gender gender;

    @OneToMany(mappedBy = "person")
    private List<Participation> participationList = new ArrayList<>();

    public Person() {
    }

    ;

    public Person(String name, String surname, String mail, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public UUID getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                '}';
    }
}
