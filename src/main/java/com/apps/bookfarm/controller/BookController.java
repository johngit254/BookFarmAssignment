package com.apps.bookfarm.controller;

import com.apps.bookfarm.model.Author;
import com.apps.bookfarm.model.Book;
import com.apps.bookfarm.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @GetMapping
    List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    String addNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @PutMapping("{id}")
    String updateBook(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Author author,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) Integer isbn,
            @RequestParam(required = false) Integer length,
            @RequestParam(required = false) String subjects) {
        return bookService.updateBook(id, title, author, publisher, isbn, length, subjects);
    }

    @DeleteMapping("{id}")
    String deleteBook(@PathVariable("id") Long id) {
        return bookService.deleteBook(id);
    }
}
