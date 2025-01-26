How to run:

Prerequisites: docker, java, maven

Redisdb:
docker run --name redis -d -p 6379:6379 redis

Postgresdb:
docker run --name postgres-db -e POSTGRES_DB=testdb -e POSTGRES_USER=your_user -e POSTGRES_PASSWORD=your_password -p 5432:5432 -d postgres:14

Springbootapp:
mvn clean install
mvn spring-boot:run

Enviroments:
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=staging"

Try it out:
add:
curl -X POST http://localhost:8080/products \                                        
-H "Content-Type: application/json" \
-d '{"name": "Test Product3"}'

getAll:
curl -X GET "http://localhost:8080/products" -H "Content-Type: application/json"

getById:
java-postgresql-test % curl -X GET "http://localhost:8080/products/1" -H "Content-Type: application/json" 
