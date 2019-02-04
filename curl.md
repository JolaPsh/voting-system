**Use Git Bash as a cURL command-line tool.**


**CURL examples**


##
**Admin**:
##

**GET all restaurants:**

 `curl -s http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin`
 
**GET restaurant with id 1001:**

 `curl -s http://localhost:8080/rest/admin/restaurants/1001 --user admin@gmail.com:admin` 
 
 **DELETE restaurant with id 1001:**
 
 `curl -s -X DELETE http://localhost:8080/rest/admin/restaurants/1001 --user admin@gmail.com:admin`
 
**CREATE restaurant:**

 `curl -s -X POST -d '{"title":"Tiget", "location": "3A Lenina Street"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin`
 
 **UPDATE restaurant:**
 
`curl -s -X PUT -d '{"id": 1006, "title": "Fransua", "location": "47a Lychakivska Street, Lviv"}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/restaurants/1006 --user admin@gmail.com:admin`

**GET all dishes:**

`curl -s http://localhost:8080/rest/admin/dishes --user admin@gmail.com:admin`

**GET dish with id 1007**

`curl -s http://localhost:8080/rest/admin/dishes/1007 --user admin@gmail.com:admin`

**DELETE dish with id 1007:**

 `curl -s -X DELETE http://localhost:8080/rest/admin/dishes/1007 --user admin@gmail.com:admin`
 
**CREATE dish:** 

`curl -s -X POST -d '{"date":"2018-09-20", "name": "Shrimp&vegetables", "price": 84, "restaurant" : {"id": 1000, "title": "Local", "location": "33 Dark Spurt, Lviv"}}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/dishes --user admin@gmail.com:admin`

**UPDATE dish:** 

`curl -s -X PUT -d '{"id": 1013, "date":"2018-09-20", "name":"Mint tea", "price": 20, "restaurant" : {"id": 1005, "title": "Shekspire", "location": "17 Kosmonavtov street, Lviv"}}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/dishes/1013 --user admin@gmail.com:admin`

##
**User:**
##

**GET vote for user and date:**
`curl -s http://localhost:8080/rest/vote?date=2019-01-27 --user herbert@gmail.com:herbert`

**GET vote history for user with id 1017:**

`curl -s http://localhost:8080/rest/vote/history --user herbert@gmail.com:herbert`

`curl -s http://localhost:8080/rest/vote/history?endDate=2019-01-28T22:00:00.000+0000 --user herbert@gmail.com:herbert`


**GET all restaurants:**

`curl -s http://localhost:8080/rest/restaurants/dishes --user dominik@gmail.com:12345678`

**CREATE(UPDATE) vote:**

`curl -s -X POST -d ' {"restaurant_id": 1004"} ' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/vote/1004 --user dominik@gmail.com:12345678`

**GET restaurants by title:**

`curl -s http://localhost:8080/rest/restaurants/searchByTitle?title=ocal --user herbert@gmail.com:herbert`