package kg.megacom.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

    List<Customer> findByBirthdayDateBetween (LocalDate before, LocalDate after);
    List<Customer> findByLastNameOrFirstName(String firstName, String lastName);
    List<Customer> findByAgeLessThan(int age);
    List<Customer> findByAgeLessThanEqual(int age);
    List<Customer> findByAgeGreaterThan(int age);
    List<Customer> findByAgeGreaterThanEqual(int age);
    List<Customer> findByFirstNameLike (String firstName);
    List<Customer> findByFirstNameNotLike (String firstName);
    List<Customer> findByFirstNameStartingWith (String firstName);
    List<Customer> findByFirstNameEndingWith (String firstName);
    List<Customer> findByFirstNameContaining (String firstName);
    List<Customer> findByLastNameNot (String lastName);




//    List<Customer> findNameAndLastName(String firstName, String lastName);


}