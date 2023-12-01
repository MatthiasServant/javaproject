package com.javaproject.service;

import com.javaproject.model.Book;
import com.javaproject.model.Loan;
import com.javaproject.model.User;
import com.javaproject.repository.BookRepository;
import com.javaproject.repository.LoanRepository;
import com.javaproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class LoanService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    public Loan loanBook(Long userId, Long bookId){
        User user = userRepository.findById(userId).orElse(null);
        if(user != null){
            Book bookToLoan = bookRepository.findById(bookId).orElse(null);
            if(bookToLoan != null && bookToLoan.getStock()>0){
                bookToLoan.setStock(bookToLoan.getStock()-1);
                bookRepository.save(bookToLoan);
                Loan loan = new Loan();
                loan.setUser(user);
                loan.setBook(bookToLoan);
                loan.setExpirationDate(new Date(System.currentTimeMillis() + 604800000));
                return loanRepository.save(loan);
            } else {
                throw new RuntimeException("Book not found or out of stock");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void returnBook(Long userId, Long bookId){
        User user = userRepository.findById(userId).orElse(null);
        if(user != null){
            Book bookToReturn = bookRepository.findById(bookId).orElse(null);
            if(bookToReturn != null){
                Loan loan = loanRepository.findByUserAndBook(user, bookToReturn);
                if(loan != null){
                    bookToReturn.setStock(bookToReturn.getStock()+1);
                    bookRepository.save(bookToReturn);
                    loanRepository.delete(loan);
                } else {
                    throw new RuntimeException("Loan not found");
                }
            } else {
                throw new RuntimeException("Book not found");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
