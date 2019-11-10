README

Comments:
=========
http://localhost:8080/blogjee/rest/autor/all

http://localhost:8080/blogjee/rest/postagem/all

http://localhost:8080/blogjee/rest/comentario/all

criar novo autor
POST http://localhost:8080/blogjee/rest/autor/create
{
"name": "Emerson",
"id": null
}

criar nova postagem
POST http://localhost:8080/blogjee/rest/postagem/create
{
	"autorEntity": "3",
	"postagem": "teste de gravacao nova postagem",
	"id": null
}

criar novo comentario
POST http://localhost:8080/blogjee/rest/comentario/create
{
	"comentario": "teste de comentario da postagem 3",
	"data": 1573349982238,
	"postagemEntity": "3",
	"id": null
}

Commands:
=========

To run tests:  mvn test

To start application:  mvn -Dmaven.test.skip=true wildfly:run


Application Tests:	
==================

