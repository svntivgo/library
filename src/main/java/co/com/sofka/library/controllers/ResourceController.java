package co.com.sofka.library.controllers;

import co.com.sofka.library.models.Resource;
import co.com.sofka.library.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ResourceController {

    @Autowired
    ResourceService service;

    @PostMapping("/resource")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Resource> addResource (@RequestBody Resource resource) {
        return service.addResource(resource);
    }

    @GetMapping("/resource/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    private Mono<Resource> getResourceById (@PathVariable("id") String id) {
        return service.getResourceById(id);
    }

    @GetMapping("/resource")
    @ResponseStatus(HttpStatus.FOUND)
    private Flux<Resource> getResources () {
        return service.getResources();
    }
}
