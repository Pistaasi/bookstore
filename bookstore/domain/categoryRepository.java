package IidaRokka.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface categoryRepository extends CrudRepository<Category, Long> {
	// ei pakko olla mitään, voi jättää tyhjäksikin :D
}
