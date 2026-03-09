package com.example.demo.Service;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1, "Java Basics", "James"));
        books.add(new Book(2, "Spring Boot", "Rod"));
    }

    public List<Book> getAll() {
        return books;
    }

    public Book getById(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Book add(Book book) {
        books.add(book);
        return book;
    }

    public Book update(int id, Book book) {
        for (Book b : books) {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                return b;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        return books.removeIf(b -> b.getId() == id);
    }
}
