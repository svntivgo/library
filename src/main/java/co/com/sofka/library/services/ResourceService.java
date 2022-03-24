package co.com.sofka.library.services;

import co.com.sofka.library.models.Resource;
import co.com.sofka.library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ResourceService {
    @Autowired
    ResourceRepository repository;

    public Mono<Resource> addResource (Resource resource) {
        return repository.save(resource);
    }

    public Mono<Resource> getResourceById (String id) {
        return repository.findById(id);
    }

    public Flux<Resource> getResources () {
        return repository.findAll();
    }
}
