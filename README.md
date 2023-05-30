## Retail-store

#### Please refer UML.png in the root directory for high level key classes relationships

Command to build the solution
```
./gradlew clean build
```

Command to run the application

```
java -jar <path_to>/retail-store-1.0.jar
```

Sample command to run application:

```
java -jar build/libs/retail-store-1.0.jar
```
Sample command to run tests:

```
./gradlew test
```

Test coverage report
```
Generate coverage report by executing tests using command : ./gradlew test

Test report path : build/reports/tests/test/index.html
```


Sample request and response
```
Request Body

{
  "totalAmount": 200,
  "isGroceries": false,
  "userType": "EMPLOYEE"
}

Response Body

{
    "netPayableAmount": 130.0
}
```

Input Description
```
totalAmount : double
isGroceries : Boolean
userType : Enum (EMPLOYEE, AFFILIATE, CUSTOMER_FOR_TWO_YEARS)
```
Sample curl command to hit API
```
curl --location --request POST 'localhost:8080/net-payable' \
--header 'Content-Type: application/json' \
--data-raw '{
  "totalAmount": 200,
  "isGroceries": false,
  "userType": "EMPLOYEE"
}'
```


To document the API, I would use a tool like Swagger or OpenAPI Specification (OAS) to provide a clear and structured documentation of the API endpoints, request parameters, response structures, and example usage.

```
POST /net-payable

{
    "totalAmount": 200,
    "isGroceries": false,
    "userType": "EMPLOYEE"
}


200 OK

{
    "netPayableAmount": 130.0
}

```
