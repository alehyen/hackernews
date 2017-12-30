# Bootcamp Ismail
## Spring Boot Backend

- L'application est une copie de site web Hacker News.
- Un utilisateur peut s'inscrire/se connecter pour qu'il peut ajouter des posts ou des commentaires.
- Seul le propriétaire du post a le droit de le supprimer.
- Tout utilisateur peut ajouter des commentaires
- Pour le signin/signup on a utilisé le protocole OAUTH2.
- L'utilisateur doit imperativement se connecter pour qu'il peut ajouter un Post ou voir la liste des Posts.

## Dependencies

- MongoDB avec une base de données avec le nom hackernews déjà en place.
- Java 8.
- Maven
- Postman pour tester l'app.

## Routes

- POST /oauth/token?grant_type=password&username=<email>&password=<password hasher avec sha256> pour avoir l'access token
- POST   /user  (il faut specifier email et password dans le body de la requête)
- GET /user/{id}
- GET /posts?access_token=<access-token>
- POST /posts?access_token=<access-token> (specifier info du post dans le body)
- PUT /posts/{id}?access_token=<access-token>
- DELETE /posts/{id}?access_token=<access-token>
- POST /posts/{id}/comments?access_token=<access-token>