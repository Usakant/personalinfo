# PersonalInfo Application

A Spring Boot application for managing personal information with REST API endpoints.

## Features

- Create, Read, Update, and Delete personal information
- RESTful API endpoints
- JPA/Hibernate ORM with H2 in-memory database
- Spring Boot 4 with Java 21
- Maven build tool

## Project Structure

```
personalinfo/
├── src/
│   ├── main/
│   │   ├── java/com/personalinfo/
│   │   │   ├── PersonalInfoApplication.java      (Main application class)
│   │   │   ├── controller/
│   │   │   │   └── PersonController.java         (REST API endpoints)
│   │   │   ├── service/
│   │   │   │   └── PersonService.java            (Business logic)
│   │   │   ├── repository/
│   │   │   │   └── PersonRepository.java         (Data access layer)
│   │   │   └── entity/
│   │   │       └── Person.java                   (JPA entity)
│   │   └── resources/
│   │       └── application.properties             (Configuration)
│   └── test/
│       └── java/com/personalinfo/
│           └── PersonalInfoApplicationTests.java (Unit tests)
└── pom.xml                                        (Maven configuration)
```

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Git

### Building the Project

```bash
mvn clean install
```

### Running the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Person Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/persons` | Create a new person |
| GET | `/api/persons` | Get all persons |
| GET | `/api/persons/{id}` | Get person by ID |
| GET | `/api/persons/email/{email}` | Get person by email |
| PUT | `/api/persons/{id}` | Update person by ID |
| DELETE | `/api/persons/{id}` | Delete person by ID |

### Example Request

```json
POST /api/persons
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1-123-456-7890",
  "address": "123 Main Street",
  "city": "San Francisco",
  "state": "CA",
  "zipCode": "94103"
}
```

## Database Configuration

The application uses H2 in-memory database by default. You can access the H2 Console at:

```
http://localhost:8080/h2-console
```

Default credentials:
- Username: `sa`
- Password: (leave empty)
- JDBC URL: `jdbc:h2:mem:testdb`

## Dependencies

- Spring Boot 4.0.0
- Spring Data JPA
- Spring Web
- H2 Database
- Lombok
- Spring Boot DevTools

## Technologies Used

- **Framework**: Spring Boot 4
- **Language**: Java 21
- **Build Tool**: Maven
- **Database**: H2 (in-memory)
- **ORM**: Hibernate (via Spring Data JPA)

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
