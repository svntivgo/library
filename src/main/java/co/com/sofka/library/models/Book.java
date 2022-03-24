package co.com.sofka.library.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "books")
public class Book {
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String Title;
    private String autor;
    private String category;
    private LocalDate borrowDate;
    private Boolean available = true;

    public Book(String title, String autor, String category) {
        Title = title;
        this.autor = autor;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
