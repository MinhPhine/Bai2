package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // GET all
    @GetMapping
    public List<Book> getAll() {
        return service.getAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return service.getById(id);
    }

    // POST
    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.add(book);
    }

    // PUT
    @PutMapping("/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        return service.update(id, book);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.delete(id) ? "Deleted" : "Not Found";
    }
}
