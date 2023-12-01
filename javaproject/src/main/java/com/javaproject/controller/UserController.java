package com.javaproject.controller;

import com.javaproject.model.Book;
import com.javaproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Méthode qui récupère tous les livres loués par un utilisateur
    @GetMapping("/books/{id}")
    public ResponseEntity<Collection<Book>> getUserBooks(@RequestParam Long id){
        return ResponseEntity.ok(userService.getUserBooks(id));
    }
}
