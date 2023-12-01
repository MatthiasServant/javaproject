package com.javaproject.repository;

import com.javaproject.model.Book;
import com.javaproject.model.Loan;
import com.javaproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    public Collection<Loan> findAllByUser(User user);
    public Collection<Loan> findAllByBook(Book book);
    public Loan findByUserAndBook(User user, Book book);
}
