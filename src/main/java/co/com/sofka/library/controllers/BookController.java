package co.com.sofka.library.controllers;

import co.com.sofka.library.models.Book;
import co.com.sofka.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Book> addBook (@RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Book> getBookById (@PathVariable("id") String id) {
        return service.getBookById(id);
    }
}
