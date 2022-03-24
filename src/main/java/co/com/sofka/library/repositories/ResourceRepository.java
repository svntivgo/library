package co.com.sofka.library.repositories;

import co.com.sofka.library.models.Resource;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ResourceRepository extends ReactiveMongoRepository<Resource, String> {
    Flux<Resource> findByTitle(String title);
}
