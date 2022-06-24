
# Welcome to Cinema Web App!
![enter image description here](https://i.imgur.com/bBLr71w.jpg)

Simple WEB application that supports registration, authentication and CRUD operations.

## Structure
3 layers architecture
- Data access layer: DAO
- Business logic layer: Services
- Presentation layer: Controllers

## Technologies
- Java
- Spring (Web, Security, Core)
- Hibernate
- MySQL
- Apache Tomcat
- Maven

## Endpoints and roles for them
- POST: /register - all
- GET: /cinema-halls - user/admin
- GET: /movies - user/admin
- GET: /movie-sessions/available - user/admin
- POST: /cinema-halls - admin
- POST: /movies - admin
- POST: /movie-sessions - admin
- PUT: /movie-sessions/{id} - admin
- GET: /users/by-email - admin
- DELETE: /movie-sessions/{id} - admin
- GET: /orders - user
- POST: /orders/complete - user
- PUT: /shopping-carts/movie-sessions - user
- GET: /shopping-carts/by-user - user

## How to run project
1. Clone the project on your IDE
2. Install MySQL and Apache Tomcat
3. Edit database config (URL, username, password) in ```db.properties``` in ```resources``` folder:

``` java
#MySQL properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:YOUR DATABASE URL
db.user=YOUR USERNAME
db.password=YOUR PASSWORD
```
4. Configure Tomcat.
5. Run project.
6. For login use admin(admin@i.ua:admin123)
