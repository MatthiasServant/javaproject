package com.javaproject.repository;

import com.javaproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Collection<Book> findByAuthor(String author);
    public Collection<Book> findByTitle(String title);
}
