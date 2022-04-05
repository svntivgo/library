package co.com.sofka.library;

import co.com.sofka.library.models.Resource;
import co.com.sofka.library.services.ResourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@SpringBootTest
class LibraryApplicationTests {

	@Autowired
	ResourceService resourceService;

	Resource resource = new Resource("Principito", "Jorge", "Libro","Aventura" );

	@Test
	void newResource() {
		Mono<Resource> newResource = resourceService.addResource(resource);
		StepVerifier.create(newResource).expectNext(resource).verifyComplete();
	}

	@Test
	void getResources() {
		Flux<Resource> getResources = resourceService.getResources();
		StepVerifier.create(getResources).expectNextMatches(response -> resource.getClass().equals(response.getClass())).thenCancel().verify();
	}

}
