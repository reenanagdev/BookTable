# BookTable

Instructions to execute Spring boot application for Table reservation system.

Pre-requisite:

1. Postman to be used for testing REST-API.

2. DDL and master data creation script provided. This needs to be executed before testing API. Details provided in instructions below.

Instructions

1. Import the project into eclipse.

2. Start the application from Boot dashboard.

2. Once service is up navigate to http://localhost:8080/h2-console/ from your favorite browser. Details below: jdbc-url: jdbc:h2:file:./reservationdb username: sa password: password

3. Run data.sql from BookTable/src/main/resources folder in h2 console. This is required to create data for testing.

4. In Postman, Open new Request window. Below APIs can be tested. Get table details: http://localhost:8080/booktable/tables Get user details: http://localhost:8080/booktable/users Get reservation details: http://localhost:8080/booktable/reservations Post request for table booking: http://localhost:8080/booktable/reservation Sample payload for above POST request for table booking: { "dateTime": "2021-08-03T13:14:02", "duration": 60, "seats": 2, "tableId": 1, "userId": 1 }

5. API can also be tested via Swagger. Swagger url: http://localhost:8080/swagger-ui/
