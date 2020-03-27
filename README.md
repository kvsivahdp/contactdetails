# contactdetails
Simple contacts database to store personal and company contact details.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
### Prerequisites
```
Java 1.8, Apache Maven 3.6.0, MySQL5
```
### Install and Run
```
Database contacts must exist, prior to running the application
```
Database name [contacts]
```
Mention database username and password in the following property file:
```
application.properties
```
$ git clone https://github.com/kvsivahdp/contactdetails.git
$ cd contactdetails
$ mvn clean install
$ mvn spring-boot:run
```
## Running the tests
Swagger UI may be used to visualize, interact and test directly with the API
```
http://localhost:7001/swagger-ui.html
```
## Built With
* [spring-boot](https://docs.spring.io/spring-boot/docs/current/reference/html/) - The web framework used
* [JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference) - Data persistence
* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL Database](https://dev.mysql.com/doc/) - RDBMS to persist data
* [Swagger UI](https://swagger.io/tools/swagger-ui/) - Tool to test and document Rest API’s
