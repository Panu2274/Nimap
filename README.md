# Product and Category CRUD Application

This project is a Spring Boot application that implements a REST API for managing **Categories** and **Products**. The application uses JPA and Hibernate to manage a relational database with a **one-to-many relationship** between `Category` and `Product`:

- **Category**: Represents the category of products.
- **Product**: Represents items belonging to a specific category.

## Features

### Category Management
- Create, retrieve, update, and delete categories.
- Retrieve all categories with pagination support.

### Product Management
- Create, retrieve, update, and delete products.
- Retrieve all products of a specific category.

### One-to-Many Relationship
- Each category can contain multiple products.
- Products are linked to a category via a foreign key.

## Technologies Used
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL** (or any other relational database)
- **REST API**

