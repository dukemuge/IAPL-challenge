
Spring Boot, PostgreSQL, JPA, Hibernate REST API Demo



Technologies - Spring Boot One to One Mapping Example:
Java 8
Maven 3.5.4
SpringToolSuite version 3.9.4.RELEASE
SpringBoot 2.0.4.RELEASE
Swagger 3 for Documentation of Api


Tutorial


Spring Boot, PostgreSQL, JPA, Hibernate RESTful CRUD API Example
Steps to Setup

1. Clone the repository

git clone https://github.com/dukemuge/IAPL-challenge.git

2. Configure PostgreSQL

First, create a database named postgres_demo. Then, open src/main/resources/application.properties file and change the spring datasource username and password as per your PostgreSQL installation.

3. Run the app

Type the following command from the root directory of the project to run it -

mvn spring-boot:run

Alternatively, you can package the application in the form of a JAR file and then run it like so -

mvn clean package
java -jar target/0.0.1-SNAPSHOT.jar


4.Run the swagger ui and view  the documented API

Run the application, and navigate to the swagger UI URL http://localhost:8080/openapi/swagger-ui.html