package co.com.sofka.library.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "books")
public class Resource {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String title;
    private String author;
    private String type;
    private String category;
    private LocalDate borrowDate;
    private Boolean available = true;

    public Resource(String title, String author, String type, String category) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.category = category;
        this.borrowDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (id != null ? !id.equals(resource.id) : resource.id != null) return false;
        if (title != null ? !title.equals(resource.title) : resource.title != null) return false;
        if (author != null ? !author.equals(resource.author) : resource.author != null) return false;
        if (type != null ? !type.equals(resource.type) : resource.type != null) return false;
        if (category != null ? !category.equals(resource.category) : resource.category != null) return false;
        if (borrowDate != null ? !borrowDate.equals(resource.borrowDate) : resource.borrowDate != null) return false;
        return available != null ? available.equals(resource.available) : resource.available == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (borrowDate != null ? borrowDate.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        return result;
    }
}
