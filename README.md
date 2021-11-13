# LibraryApp - configuration

## Requirements
- Java Jdk 13 and above
- Maven Compiler
- PostgreSql Database
- Git

## Clone the Project
Run below command on your commandline;
 
``git clone https://github.com/Kajol232/LibraryApp.git``

or download the project zip file on https://github.com/Kajol232/LibraryApp/


## Set up Connection String(Postgre Sql)

  Change below properties in application.properties in the resources folder 
- spring.datasource.url=jdbc:postgresql://[database server - default = localhost]:[port - default = 5432]/[database name]
- spring.datasource.username = [your username]
- spring.datasource.password = [your password]

or use H2 Database by setting copying and replace above settings with below

- spring.datasource.url=jdbc:h2:mem:testdb
- spring.datasource.driverClassName=org.h2.Driver
- spring.datasource.username=sa
- spring.datasource.password=password
- spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

## Run Application

You can either run the application locally on any IDE preferable Intellij Idea or with below command via command line;

- mvn clean install
- mvn spring-boot:run

## API Documentation

Access the api documentation on http://localhost:8083/swagger-ui.html#
