**REST / Spring Boot / JPA / HSQL**
##
**Graduation Project of <a href="https://github.com/JolaPsh/topjava">Topjava</a>  Intership**
##
This Java project offers a `RESTful API` with basic authentication for admin and regular users. 


> **Voting system for deciding where to have lunch.** 
Only one vote per day per person, a person can change his vote until 11 a.m.
User chooses restaurant based upon today's dish.

 **Here you can find task and project requirements <a href="https://github.com/JolaPsh/voting-system/blob/master/graduation.md">graduation.md</a>**

 **Technology stack:**
 - Spring Boot
 - Spring Security
 - REST
 - Spring Data JPA
 - HSQL DB
 - Maven
 - JUnit

##
**How to use this program**

**1. Clone a repository:**

```sh
 git clone https://github.com/JolaPsh/voting-system.git
```

**2. Open the project using the IDE**

**3. Execute initial script to create database schema, see src/resources/init_hsqldb.sql**

**4. Set up an environment variable `LOG_FILE` in your OS, specify the path to your project, for example: D:\Git\voting_app.** 

**5. Run your program or just execute it with Maven:** 

```sh
mvn spring-boot:run
```

**6. Use Postman to test this API, you can add it from Google Chrome Web Store or
use another REST Client Tool on your own. See also examples of curl commands <a href="https://github.com/JolaPsh/voting-system/blob/master/curl.md">curl.md</a>** 
##
