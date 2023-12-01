package com.javaproject.controller;

import com.javaproject.model.Book;
import com.javaproject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController {
    //on fait une injection de dépendance de notre service pour pouvoir appeler les méthodes dans notre controller
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //Méthode qui récupère tous les livres
    @GetMapping()
    public ResponseEntity<Collection<Book>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    //Méthode qui récupère tous les livres d'un auteur
    @GetMapping("/author")
    public ResponseEntity<Collection<Book>> getBooksByAuthor(@RequestParam String author){
        return ResponseEntity.ok(bookService.getBooksByAuthor(author));
    }

    //Méthode qui récupère tous les livres d'un titre
    @GetMapping("/title")
    public ResponseEntity<Collection<Book>> getBooksByTitle(@RequestParam String title){
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    //Méthode qui récupère un livre par son id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    //Méthode qui créer un livre
    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }
}
