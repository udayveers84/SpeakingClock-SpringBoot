# Speaking Clock

The Speaking Clock project is a simple application that converts the current time into words. It allows users to input the time in a 24-hour clock format and receive the corresponding time in words.

## Technologies Used

- Java 11
- Spring Boot
- Gradle Wrapper
- Swagger

## Prerequisites

- Java 11 or higher installed on your machine
- Gradle Wrapper included in the project

## Getting Started

Follow the steps below to get started with the Speaking Clock project:

1. Clone the repository:

   ```shell
   git clone https://github.com/bikash-hutait/SPEAKING-CLOCK.git
   ```

2. Navigate to the project directory:

   ```shell
   cd speaking-clock
   ```

3. Build the project using the Gradle Wrapper:

   ```shell
   ./gradlew build
   ```

4. Run the application:

   ```shell
   ./gradlew bootRun
   ```

5. Access the application:

   Open a web browser and go to [http://localhost:8080](http://localhost:8080)

## API Endpoints

The Speaking Clock project provides the following API endpoints:

- `GET /convert`: Converts the given time in a 24-hour clock format to words.
  - Request Parameter:
    - `time`: The time to convert (e.g., "08:34").
  - Example: `GET /convert?time=08:34`

## Documentation

The project uses Swagger for API documentation. You can access the Swagger documentation by opening the following URL in your web browser: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


## Authors

- Bikash Hutait
- Jane Smith

## Acknowledgments

We would like to acknowledge the following resources and libraries that were used in the development of the Speaking Clock project:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Swagger](https://swagger.io/)

Feel free to explore and use the Speaking Clock project to convert the current time into words. If you have any feedback or suggestions, please don't hesitate to reach out and let me know.

Enjoy using the Speaking Clock!
