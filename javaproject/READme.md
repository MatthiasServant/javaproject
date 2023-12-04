# Sujet Bibliothèque virtuelle

## Prérequis

- [Docker](https://docs.docker.com/install/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Maven](https://maven.apache.org/install.html)

## Lancement

### Lancement de la base de données et de l'application

```shell
docker-compose up -d
```

Si jamais vous avez une erreur, il suffit de lancer uniquement la base de données et de relancer l'application.

```shell
docker-compose up -d db
mvn spring-boot:run
```

## Documentation

La liste des routes est disponible dans le dossier [docs](docs/REST.md)\*