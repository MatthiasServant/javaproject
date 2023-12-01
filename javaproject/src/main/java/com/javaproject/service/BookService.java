package com.javaproject.service;

import com.javaproject.model.Book;
import com.javaproject.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Collection<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public Collection<Book> getBooksByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public Collection<Book> getBooksByTitle(String title){
        return bookRepository.findByTitle(title);
    }
}
