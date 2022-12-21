### Spring Boot Validation
Login and Registration form validation using Spring Boot and Hibernate Validator

### Prerequisites
* Java 8
* Maven 3.3.9
* Spring Boot 2.0.0
* Hibernate Validator 6.0.9
* Thymeleaf 3.0.9
* Bootstrap 4.1.1

### Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.example.demo.DemoApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

```
mvn spring-boot:run
```

### Running the application using Docker
You can run the application using Docker by executing the following command:

```
docker run -p 8080:8080 -t springio/gs-validating-form-input
```

### Deploying the application to Heroku
You can deploy the application to Heroku by executing the following command:

```
heroku create
git push heroku master
heroku open
```

### Running the tests
You can run the tests by executing the following command:

```
mvn test
```

### CI/CD
The application is configured to be built and deployed to AWS using Circle CI and to Heroku with GitHub actions. The configuration can be found in the [config.yml](./.circleci/config.yml) and [maven.yml](./.github/workflows/maven.yml) files.

### Built With
* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Hibernate Validator](http://hibernate.org/validator/) - Validation framework
* [Spring Data JPA](https://projects.spring.io/spring-data-jpa/) - Data Access
* [Thymeleaf](https://www.thymeleaf.org/) - Template engine
* [Bootstrap](https://getbootstrap.com/) - Front-end framework

### License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details


