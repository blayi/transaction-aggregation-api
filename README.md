# Transaction Aggregation API

This is a small Spring Boot API for working with transactions.

It can add transactions, show the saved transactions and calculate their total amount.

The transactions are stored in memory. This means the data is cleared when the application stops.

## Tools Used

- Java 21
- Spring Boot
- Maven
- JUnit
- Docker

## Run the Project

From the project folder, run:

```bash
mvn spring-boot:run
```

The API runs on:

```text
http://localhost:8080
```

Swagger can be opened here:

```text
http://localhost:8080/swagger-ui.html
```

Swagger can be used to view and test the endpoints.

## Endpoints

Add a transaction:

```text
POST /api/transactions
```

View all transactions:

```text
GET /api/transactions
```

View the transaction count and total amount:

```text
GET /api/transactions/summary
```

Example transaction:

```json
{
  "transactionId": "id01",
  "merchant": "Woolworths",
  "amount": 654,
  "transactionDateTime": "2026-10-19T11:22:00"
}
```

## Validation

A transaction needs:

- A transaction ID
- A merchant
- An amount greater than zero
- A date and time

Invalid transactions return a `400 Bad Request` response with a message explaining what is missing or incorrect.

## Tests

Run the tests with:

```bash
mvn test
```

## Docker

Build the image:

```bash
docker build -t transaction-aggregation-api .
```

Run the container:

```bash
docker run --rm -p 8080:8080 transaction-aggregation-api
```

GitHub Actions also builds the image, starts the container and checks that the API responds.