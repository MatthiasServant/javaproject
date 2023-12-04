# API Routes

==========

## Livres
    - `GET /books` : Récupère tous les livres
    - `GET /books/{id}` : Récupère un livre par son id
    - `POST /books` : Crée un livre
    - `PUT /books/{id}` : Modifie un livre
    - `DELETE /books/{id}` : Supprime un livre

## Auth
    - `POST /auth/login` : Connecte un utilisateur
    - `POST /auth/register` : Crée un utilisateur
    - `POST /auth/logout` : Déconnecte un utilisateur

## Users
    - `GET /user/books/{id}` : Récupère tous les livres d'un utilisateur

## Emprunts
    - `POST /loan/{userId}/{bookId}` : Emprunte un livre
    - `POST /loan/return/{userId}/{bookId}` : Rend un livre