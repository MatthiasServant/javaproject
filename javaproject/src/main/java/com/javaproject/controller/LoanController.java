package com.javaproject.controller;

import com.javaproject.service.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    //Méthode qui loue un livre à un utilisateur
    @PostMapping("/{userId}/{bookId}")
    public void loanBook(@RequestParam Long userId, @RequestParam Long bookId){
        loanService.loanBook(userId, bookId);
    }

    //Méthode qui rend un livre d'un utilisateur
    @PostMapping("/return/{userId}/{bookId}")
    public void returnBook(@RequestParam Long userId, @RequestParam Long bookId){
        loanService.returnBook(userId, bookId);
    }
}
