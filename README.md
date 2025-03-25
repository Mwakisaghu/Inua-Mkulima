# Inua-Mkulima API

Inua-Mkulima is a lightweight and efficient REST API built with Undertow, designed to handle authentication, product management, transactions, and wallet services.

## Table of Contents
- [Project Setup](#project-setup)
- [Dependencies](#dependencies)
- [How to Clone](#how-to-clone)
- [API Endpoints](#api-endpoints)
  - [Authentication](#authentication)
  - [Product Management](#product-management)
  - [Transactions](#transactions)
  - [Wallet Management](#wallet-management)
- [Running Tests](#running-tests)

## Project Setup
### Prerequisites
- Java 17 or later
- Maven
- Git

### Steps to Set Up the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/Mwakisaghu/Inua-Mkulima.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Inua-Mkulima
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn exec:java
   ```

## Dependencies
The project uses the following dependencies:

```xml
<dependencies>
    <!-- Undertow Web Server -->
    <dependency>
        <groupId>io.undertow</groupId>
        <artifactId>undertow-core</artifactId>
        <version>2.2.8.Final</version>
    </dependency>

    <!-- SLF4J for logging -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.30</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>1.7.30</version>
    </dependency>

    <!-- JUnit & Mockito for testing -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.8.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>4.2.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## API Endpoints

### Authentication
#### **Login**
- **Endpoint:** `POST /auth/login`
- **Request Body:**
  ```json
  {
      "username": "farmer1",
      "password": "password123"
  }
  ```
- **Response:**
  ```json
  {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
  }
  ```

### Product Management
#### **Add Product**
- **Endpoint:** `POST /products`
- **Request Body:**
  ```json
  {
      "name": "Maize Seeds",
      "price": 500,
      "quantity": 20
  }
  ```
- **Response:**
  ```json
  {
      "message": "Product added successfully"
  }
  ```

#### **Get Products**
- **Endpoint:** `GET /products`
- **Response:**
  ```json
  [
      {
          "id": 1,
          "name": "Maize Seeds",
          "price": 500,
          "quantity": 20
      }
  ]
  ```

### Transactions
#### **Add Transaction**
- **Endpoint:** `POST /transactions`
- **Request Body:**
  ```json
  {
      "productId": 1,
      "buyerId": 2,
      "quantity": 5
  }
  ```
- **Response:**
  ```json
  {
      "message": "Transaction successful"
  }
  ```

### Wallet Management
#### **Get Wallet Balance**
- **Endpoint:** `GET /wallet`
- **Response:**
  ```json
  {
      "balance": 15000
  }
  ```

## Running Tests
To run tests, execute:
```sh
mvn test
```

