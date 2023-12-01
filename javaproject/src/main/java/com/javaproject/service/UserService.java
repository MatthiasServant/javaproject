package com.javaproject.service;

import com.javaproject.model.Book;
import com.javaproject.model.Loan;
import com.javaproject.model.User;
import com.javaproject.repository.BookRepository;
import com.javaproject.repository.LoanRepository;
import com.javaproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserService {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;

    public Collection<Book> getUserBooks(Long id){
        User user = userRepository.findById(id).orElse(null);
        Collection<Loan> loans = loanRepository.findAllByUser(user);
        return loans.stream().map(Loan::getBook).toList();
    }
}
