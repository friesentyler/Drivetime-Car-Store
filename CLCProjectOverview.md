# CLC Project Overview

## 1

## 2
- The application will implement a user registration module and a login module.

- The application will be designed using an N-Layer architecture, with distinct and separate presentation components, business services, and persistence services.

- The application will adhere to industry best practices, exception handling, and error handling as discussed either in topic readings, and lectures. 
  - Presentation Spring MVC (Views, Models, and Controllers)
  - Spring Core (Business and Data Services)
  - Spring Data JDBC (Persistence)
  - Spring Core (IoC and DI)
  - Spring REST Services (APIs)
  - Bootstrap (Responsive Design)
  - Spring Boot Embedded Tomcat (as a JAR)
  - MySQL (Relational Database)

- The application presentation must be entirely written using Spring MVC compliant pages using Thymeleaf templates.

- The application must perform data validation on all form data entry fields.
- The application must support a responsive design using the Bootstrap framework.
- The application must not have business logic or business rules implemented in Spring MVC views, models, or controllers.
- The application must implement all CRUD methods on whatever business domain is being addressed (i.e., products, music, blogs, etc.).
    - A page that lists all "products" as a tabular report.
    - A page that allows a user to create a new "product."
    - A page that allows a user to display the details of a "product."
    - A page that allows a user to update an existing "product."
    - A page that allows a user to delete an existing "product."
- The application must use a relational database, such as MySQL or PostgreSQL. It should be noted that if you develop your application using Spring Data JDBC and use the CrudRepository, you could easily port your application over to use MongoDB, but this will not be possible until you finish Topic 5. You must receive permission from your instructor to use MongoDB.
- The application must use the Spring JDBC or Spring Data JDBC to access the database.
- The application must use Spring Beans to implement all business services and persistence services.
- The application must use proper declarative Spring annotations within all components and use dependency injection (DI) for all models, controllers, services, and resources required by the application.
- The application must be deployed using Spring Boot and use the embedded Tomcat (version 9.x or later).
- The application must not be able to access secure pages (all but the root, registration, and login pages) without first logging into the application. The application will automatically redirect the user to the login page if they try to access a secure page without first logging in. The application must be secured using Spring Security form-based authentication and a database.
- The APIs must not be anonymous, must be secured using Spring Security, and at a minimum, must use Basic HTTP Authentication using a database.
- The application classes must be fully documented using JavaDoc format

## 3

## 4

## 5

There are several of different risks that can arise in the process of this project. For starters, we need to be aware of the merge conflicts that can arise when pushing and pulling all of our commits. With the correct protocols, we can avoid this issue. Another risk/issue that we can avoid is reaching a point where the code is unmaintainable. We can avoid this by making readable code, and following industry practices to make our lines of code as efficient and clean as possible. These precautions will not only ensure the safety and of our project, but our future projects in the work place as we instill proper programming etiquette and protocols.
