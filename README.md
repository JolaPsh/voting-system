**Under development**

Graduation Project of Topjava Online Intership
REST API project with basic authentication for admin and regular users. 
Voting app for deciding in which restaurant 

Technology stack:
- Spring Boot
- Spring Security
- Spring Data JPA
- HSQL database, embedded
- Java 8 Stream API


Clone: https://github.com/JolaPsh/voting-system.git
Execute it with Maven: mvn spring-boot:run


Test
CURL

Git Bash

**restaurants**:
GET all restaurants:
curl -s http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin
GET restaurant with id 1001:
curl -s http://localhost:8080/rest/admin/restaurants/1001 --user admin@gmail.com:admin
DELETE restaurant with id 1001:
curl -s -X DELETE http://localhost:8080/rest/admin/restaurants/1001 --user admin@gmail.com:admin
CREATE restaurant: POST
curl -s -X POST -d '{ "title": "Tiget", "location": "3A Lenina Street"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin
UPDATE restaurant: PUT
curl -s -X PUT -d '{"id": 1004, "title":"FRONTO", "location":"3 Chapel Street, Lviv"}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/restaurants/1004 --user admin@gmail.com:admin

dishes:
localhost:8080/rest/admin/dishes GET
localhost:8080/rest/admin/dishes/1002 GET
localhost:8080/rest/admin/dishes/1002 DELETE
localhost:8080/rest/admin/dishes POST
localhost:8080/rest/admin/dishes/1002 PUT


user actions:
rest/profile/restaurants GET
rest/profile/restaurants/dishes GET
rest/profile/vote/1008 POST
rest/profile/vote/1008 GET

**REST API/ Spring Boot / JPA / HSQL**