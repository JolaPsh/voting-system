**Use Git Bash as a cURL command-line tool.**


**CURL examples**


##
**Admin**:
##

**GET all restaurants:**

 `curl -s http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin`
 
**GET restaurant with id 1001:**

 `curl -s http://localhost:8080/rest/admin/restaurants/1009 --user admin@gmail.com:admin`
 
 **DELETE restaurant with id 1009:**
 
 `curl -s -X DELETE http://localhost:8080/rest/admin/restaurants/1009 --user admin@gmail.com:admin`
 
**CREATE restaurant:**

 `curl -s -X POST -d '{"title":"Tiget", "location": "3A Lenina Street", "dish": {"id": 1006, "name": "Mint tea", "date": "2018-10-24", "price":25}}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/restaurants --user admin@gmail.com:admin`
 
 **UPDATE restaurant:**
 
`curl -s -X PUT -d '{"id": 1015, "title": "Fransua", "location": "47a Lychakivska Street, Lviv", "dish": {"id": 1006, "name": "Mint tea", "date": "2018-10-24", "price": 25}}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/restaurants/1015 --user admin@gmail.com:admin`

**GET all dishes:**

`curl -s http://localhost:8080/rest/admin/dishes --user admin@gmail.com:admin`

**GET dish with id 1000**

`curl -s http://localhost:8080/rest/admin/dishes/1000 --user admin@gmail.com:admin`

**DELETE dish with id 1000:**

 `curl -s -X DELETE http://localhost:8080/rest/admin/dishes/1000 --user admin@gmail.com:admin`
 
**CREATE dish:** 

`curl -s -X POST -d '{"date":"2018-09-20", "name": "Shrimp&vegetables", "price": 84}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/admin/dishes --user admin@gmail.com:admin`

**UPDATE dish:** 

`curl -s -X PUT -d '{"id": 1006, "date":"2018-09-20", "name":"Mint tea", "price": 20}}' -H 'Content-Type: application/json' http://localhost:8080/rest/admin/dishes/1006 --user admin@gmail.com:admin`

##
**User:**
##
**GET user vote history:**

`curl -s http://localhost:8080/rest/vote/1017 --user herbert@gmail.com:herbert`

**GET all restaurants:**

`curl -s http://localhost:8080/rest/restaurants --user dominik@gmail.com:12345678`

**GET all restaurant with dishes:**

`curl -s http://localhost:8080/rest/restaurants/dishes?date=2018-10-06 --user dominik@gmail.com:12345678`

**CREATE(UPDATE) vote:**

`curl -s -X POST -d ' {"user_id": 1018, "restaurant_id": 1010"} ' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/rest/vote/1010 --user dominik@gmail.com:12345678`

**GET restaurants by title:**

`curl -s http://localhost:8080/rest/restaurants/searchByTitle?title=ocal --user herbert@gmail.com:herbert`