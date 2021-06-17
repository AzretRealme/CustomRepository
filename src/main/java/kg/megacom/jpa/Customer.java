package kg.megacom.jpa;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean active;

    private LocalDate birthdayDate;

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", birthdayDate=" + birthdayDate +
                '}';
    }

    protected Customer() {}


    public boolean isActive() {
        return active;
    }

    public Customer(String firstName, String lastName, LocalDate birthdayDate, int age, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.age = age;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }
}