package IidaRokka.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
