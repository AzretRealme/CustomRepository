package kg.megacom.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class JpaApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer", LocalDate.of(2000, 2, 2), 22, true));
			repository.save(new Customer("Chloe", "O'Brian", LocalDate.of(2000, 2, 3), 21, false));
			repository.save(new Customer("Kim", "Bauer", LocalDate.of(2000, 2, 5), 23, true));
			repository.save(new Customer("David", "Palmer", LocalDate.of(2000, 2, 9), 20, false));
			repository.save(new Customer("Michelle", "Dessler", LocalDate.of(2000, 2, 7), 19, false));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info(repository.findByBirthdayDateBetween(LocalDate.of(2000, 2, 2), LocalDate.of(2001, 1, 1)).toString());
			log.info("--------------------------------");
			log.info("");


			log.info("Customer found with findByFirstNameOrLastName(Bauer, Michelle):");
			log.info(repository.findByLastNameOrFirstName("Bauer", "Michelle").toString());


			log.info("Customer found with findByAgeLessThan(22):");
			log.info(repository.findByAgeLessThan(22).toString());

			log.info("Customer found with findByAgeLessThanEqual(20):");
			log.info(repository.findByAgeLessThanEqual(20).toString());

			log.info("Customer found with findByAgeGreaterThan(22):");
			log.info(repository.findByAgeGreaterThan(22).toString());

			log.info("Customer found with findByAgeGreaterThanEqual(20):");
			log.info(repository.findByAgeGreaterThanEqual(20).toString());

			log.info("Customer found with findByFirstnameLike(David):");
			log.info(repository.findByFirstNameLike("David").toString());

			log.info("Customer found with findByFirstNameNotLike(Chloe):");
			log.info(repository.findByFirstNameNotLike("Chloe").toString());

			log.info("Customer found with findByFirstnameStartingWith(Kim):");
			log.info(repository.findByFirstNameStartingWith("Kim").toString());

			log.info("Customer found with findByFirstNameEndingWith(Jack):");
			log.info(repository.findByFirstNameEndingWith("Jack").toString());

			log.info("Customer found with findByFirstNameContaining(Jack):");
			log.info(repository.findByFirstNameContaining("Jack").toString());

			log.info("Customer found with findByLastNameNot():");
			log.info(repository.findByLastNameNot("Bauer").toString());


			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }


//			repository.findNameAndLastName("Michelle", "Dessler").forEach(twoName -> {
//				log.info(twoName.toString());
//			});


		};
	}
}
