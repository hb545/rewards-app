# Rewards Application

The application calculates the reward points based on the transaction happened in last three months (month-wise rewards).

API's :

## Transactions API's:

URL: localhost:8080/v1/transaction/get-all-transaction
Method: GET
Description: Returns all the transactions happened till date.


URL: localhost:8080/v1/transaction/get-transaction-by-id?customerId=1
Method: GET
Description: Returns all the transactions happened till date for the given customer id.


URL: localhost:8080/v1/transaction/save-transaction
Method: POST
Description: Creates a Transaction Entry
Sample Request Body:

[
    {
        "customerId": "1",
        "customerName": "Aman",
        "purchaseAmount": 85.00,
        "purchaseDate":"2023-05-01"
    }
]


## Rewards API's:

URL: localhost:8080/v1/rewards/get-total-purchase-by-id?customerId=1
Method: GET
Description: Returns total purchases (in amount) happened by the given customer.

URL: localhost:8080/v1/rewards/get-rewards
Method: GET
Description: Returns rewards for each customer month wise for the last three months for all customers.

URL: localhost:8080/v1/rewards/get-rewards-by-customer-id?customerId=1
Method: GET
Description: Returns rewards for each customer month wise for the last three months for the provided customer id.

## To Run the Application

### Eclipse

1. Run as Java Application or Spring Boot Application (if using STS)

### CMD

1. Inside the project directory execute mvnw clean install
2. Navigate to target directory and execute the command java -jar <jar-file-name>

### IntelliJ

1. Run the RewardsApplication.java file

