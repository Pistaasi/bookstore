package IidaRokka.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import IidaRokka.bookstore.domain.Category;
import IidaRokka.bookstore.domain.bookEntity;
import IidaRokka.bookstore.domain.bookRepository;
import IidaRokka.bookstore.domain.categoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(bookRepository repository) {
		return (args) -> {
			log.info("save some books");
			repository.save(new bookEntity("Lord of the rings", "J.R.R Tolkien", "0-261-10325-3", 1995, 15.00));
			repository.save(new bookEntity("Noituri1", "Andrzej Sapkowski", "978-951-0-36569-4", 2010, 12.99));
			repository.save(new bookEntity("Muumit Rivieralla", "Tove Jansson", "978-951-0-40853-7", 2014, 10.99));
			log.info("fetch all books");
			for (bookEntity book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

	@Bean
	public CommandLineRunner categoryDefaults(categoryRepository catrepository) {
		return (args) -> {
			log.info("save some categories");
			catrepository.save(new Category("Fantasy"));
			catrepository.save(new Category("Science"));
			catrepository.save(new Category("Humour"));
			catrepository.save(new Category("Romance"));
			catrepository.save(new Category("Horror"));
			catrepository.save(new Category("Mystery"));

			log.info("fetch all categories");
			for (Category category : catrepository.findAll()) {
				log.info(category.toString());
			}
		};
	}

}
