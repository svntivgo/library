package co.com.sofka.library.services;

import co.com.sofka.library.models.Resource;
import co.com.sofka.library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public Mono<Void> deleteResourceById (String id) {
        return repository.deleteById(id);
    }

    public Mono<Resource> updateResoruceById (String id, Resource resource) {
        return repository.findById(id)
                .flatMap(object -> {
                    resource.setId(id);
                    return repository.save(resource);
                });
    }

    public String isResourceAvailable (String title) {
        Flux<Resource> unavailableResources = repository.findByTitle(title)
                .sort(Comparator.comparing(resource -> resource.getBorrowDate()))
                .filter(resource -> !resource.getAvailable());

        Flux<Resource> availableResources = repository.findByTitle(title)
                .filter(resource -> resource.getAvailable());

        Resource resourceFalse = unavailableResources.blockLast();

        if (availableResources.blockFirst() == null) {
            return "El recurso no esta disponible, el ultimo ejemplar fue prestado en: " + resourceFalse.getBorrowDate();
        }

        return "El recurso está disponible";

    }
}
