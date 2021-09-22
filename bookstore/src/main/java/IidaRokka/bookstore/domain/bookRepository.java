package IidaRokka.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface bookRepository extends CrudRepository<bookEntity, Long> {
	// ei pakko olla mitään, voi jättää tyhjäksikin :D
}
