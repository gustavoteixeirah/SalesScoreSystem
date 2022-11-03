## Sales Score System

This repository holds the code for the required system, along with instructions to start the API and to make requests to the system.


### Starting the system
You can easily start the system by importing it as a project in IntelliJ IDEA IDE, going to the AppRunner class and executing the main method.
You'll also need to deploy a mongo database. The easiest way to do that is with Docker. I have provided a docker-compose file inside the project directory. To deploy it, you will need to have Docker working properly on your machine and then type the following command in a terminal inside the project folder:
```
docker-compose up -d
```
The mongodb container will start and the application will connect to it automatically.

### Requests
A Postman collection with examples on running request against the API is provided with the file:
```
SalesScore.postman_collection.json
```

You can test the API by importing the file into your Postman and executing the API calls.
