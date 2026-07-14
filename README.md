# University Management System

A Java desktop application for managing university entities using PostgreSQL as a persistent storage backend.

## Features

- Add Universities
- Add Professors
- View all records
- Update existing data
- Delete records
- Sort data
- PostgreSQL database integration
- Object-Oriented Design

## Technologies

- Java 25
- Maven
- PostgreSQL
- JDBC
- IntelliJ IDEA

## Project Structure

src/
│
├── config/
├── database/
├── entities/
├── services/
├── utils/
└── Main.java

## Database

PostgreSQL

Tables:

- universities
- professors

## Installation

Clone repository

```bash
git clone https://github.com/dinrkz/oop.git
```

Create database

```sql
CREATE DATABASE oop_db;
```

Configure

```
DatabaseConfig.java
```

Build

```bash
mvn clean install
```

Run

```bash
mvn exec:java
```

## Example

```
1. Add Professor
2. Add University
3. Show Data
4. Update
5. Delete
6. Exit
```

## Architecture

The project follows Object-Oriented Programming principles:

- Encapsulation
- Inheritance
- Polymorphism
- Separation of Concerns

## Future Improvements

- GUI (JavaFX)
- Authentication
- REST API
- Hibernate ORM
- Unit Tests
- Docker support

## Author

din
