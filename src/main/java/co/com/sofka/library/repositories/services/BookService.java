package co.com.sofka.library.repositories.services;

import co.com.sofka.library.models.Book;
import co.com.sofka.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    public Mono<Book> addBook (Book book) {
        return repository.save(book);
    }
}
