package pro.developia.reactor.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserR2dbcRepository extends ReactiveCrudRepository<User, Long> {
}
