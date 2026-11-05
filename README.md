# Transaction Aggregation API

A simple Spring Boot API that stores transactions and calculates a transaction summary.

The project currently stores transactions in memory. This means that the transactions are removed when the application is stopped.

## Technologies Used

- Java 21
- Spring Boot
- Maven
- JUnit
- Docker

## Features

- Add a transaction
- View all transactions
- View the number of transactions
- Calculate the total transaction amount
- Validate transaction information

## Project Structure

- `model` contains the transaction information.
- `service` stores the transactions and calculates the total amount.
- `controller` provides the API endpoints.

## Validation Rules

A transaction must have:

- A transaction ID
- A merchant name
- An amount greater than zero
- A transaction date and time

If validation fails, the API returns a `400 Bad Request` response with the fields that need to be corrected.

Example validation response:

```json
{
  "amount": "Amount must be greater than zero",
  "transactionDateTime": "Transaction date and time are required",
  "merchant": "Merchant is required",
  "transactionId": "Transaction ID is required"
}
```

## Run the Application

Run the following command from the project folder:

```bash
mvn spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

## API Documentation

After starting the application, Swagger can be opened at:

```text
http://localhost:8080/swagger-ui.html
```

Swagger shows the available endpoints and can also be used to test the API.
```

## API Endpoints

### Add a Transaction

```text
POST /api/transactions
```

Example request:

```json
{
  "transactionId": "id01",
  "merchant": "Woolworths",
  "amount": 654,
  "transactionDateTime": "2026-10-19T11:22:00"
}
```

### View All Transactions

```text
GET /api/transactions
```

### View Transaction Summary

```text
GET /api/transactions/summary
```

Example response:

```json
{
  "transactionCount": 2,
  "totalAmount": 1354
}
```

## Run the Tests

```bash
mvn test
```

## Run with Docker

Build the Docker image:

```bash
docker build -t transaction-aggregation-api .
```

Run the container:

```bash
docker run --rm -p 8080:8080 transaction-aggregation-api
```
## Automatic Docker Check

GitHub Actions automatically:

- Builds the Docker image
- Starts the Docker container
- Checks that the transactions endpoint responds
- Stops the container after the check
