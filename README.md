

# Rewards Application

The application calculates the reward points based on the transaction happened in last three months (month-wise rewards).

API's :

## Transactions API's:

**URL:** [localhost:8080/v1/transaction/get-all-transaction](localhost:8080/v1/transaction/get-all-transaction) <br>
**Method:** GET <br>
**Description:** Returns all the transactions happened till date. <br>


**URL:** [localhost:8080/v1/transaction/get-transaction-by-id?customerId=1](localhost:8080/v1/transaction/get-transaction-by-id?customerId=1) <br>
**Method:** GET <br>
**Description:** Returns all the transactions happened till date for the given customer id. <br>


**URL:** [localhost:8080/v1/transaction/save-transaction](localhost:8080/v1/transaction/save-transaction) <br>
**Method:** POST <br>
**Description:** Creates a Transaction Entry <br>

*Sample Request Body:*

    [
        {
            "customerId": "1",
            "customerName": "Aman",
            "purchaseAmount": 85.00,
            "purchaseDate":"2023-05-01"
        }
    ]


## Rewards API's:

**URL:** [localhost:8080/v1/rewards/get-total-purchase-by-id?customerId=1](localhost:8080/v1/rewards/get-total-purchase-by-id?customerId=1) <br>
**Method:** GET <br>
**Description:** Returns total purchases (in amount) happened by the given customer. <br>

**URL:** [localhost:8080/v1/rewards/get-rewards](localhost:8080/v1/rewards/get-rewards) <br>
**Method:** GET <br>
**Description:** Returns rewards for each customer month wise for the last three months for all customers. <br>

**URL:** [localhost:8080/v1/rewards/get-rewards-by-customer-id?customerId=1](localhost:8080/v1/rewards/get-rewards-by-customer-id?customerId=1) <br>
**Method:** GET <br>
**Description:** Returns rewards for each customer month wise for the last three months for the provided customer id. <br>

## To Run the Application

### Eclipse

1. Run as Java Application or Spring Boot Application (if using STS)

### CMD

1. Inside the project directory execute mvnw clean install
2. Navigate to target directory and execute the command 

    java -jar  **[jar-file-name]**

### IntelliJ

1. Run the *RewardsApplication.java* file

## Database

### Configuration

    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

*Modify the details as per your need in application.properties file, this are default details using h2 database.*
