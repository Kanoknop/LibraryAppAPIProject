# springboot-library-app-project

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) library app.

## Requirements

For building and running the application you need:

- [JDK 19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)

## Dependencies
- Lombok
- Spring Web
- PostgreSQL Driver
- Spring Data JPA

## How to use
- There are 3 tables
  1) book_information
  2) student_information
  3) borrow_list
  All of the tables can add, update, delete, and get lists and are also related to each other
- borrow_list will get some information from the book and student table e.g. name
