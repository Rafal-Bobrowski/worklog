# Worklog - RESTful Service

This project is designed to utilize various tools and technologies for learning and experimentation purposes. The application is developed with an API-first approach.

### Technologies Used
The project is based on Spring Boot and currently uses the following:
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Starter Web
- Project Lombok
- H2 database
- MapStruct
- OpenAPI Generator
- Springdoc OpenAPI UI
- 
## How to Use

### Create and Run Docker Image locally
1. Build the Docker image:
    ```sh
    docker build -f ./src/main/dockerBase/Dockerfile -t worklog .
    ```
2. Run the Docker container:
    ```sh
    docker run -p 8080:8080 -d worklog
    ```
    *Note: You can change the port `8080` as needed.*

*Note: Ensure to run `mvn package` before building the Docker image.*

### OpenAPI Definition
Access the OpenAPI definition using:
[Swagger UI](http://localhost:8080/swagger-ui/index.html)