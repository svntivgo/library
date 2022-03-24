package co.com.sofka.library.services;

import co.com.sofka.library.models.Resource;
import co.com.sofka.library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ResourceService {
    @Autowired
    ResourceRepository repository;

    public Mono<Resource> addBook (Resource resource) {
        return repository.save(resource);
    }

    public Mono<Resource> getBookById (String id) {
        return repository.findById(id);
    }
}
