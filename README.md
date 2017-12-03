# Blog
A simple blog using angular 5 and Spring Boot

# Set up
Install Node.js and npm if they are not already on your machine (at least node 6.9.x and npm 3.x.x), for instance if you are in OSX you can use brew (brew install node).

Besides that you should run the script located in ./back/src/main/resources/Sql/MySQL/SetUpDDBB.sql to set up the DDBB structure (MYSQL) and you should update the file ./back/src/main/resources/application.properties with the location and login of your DDBB.

# Start
In order to start the project first run the backend:
```sh
$ git clone https://github.com/CesarPerez/Blog.git
$ cd Blog/back
# Run Backend restful API
$ ./mvnw spring-boot:run
```
Then in another tab run the frontend:
```sh
$ cd Blog/front
# download dependencies locally
$ npm install
# run Frontend 
$ npm start
```

Open your favourite browser and go to http://localhost:4200/, you should see the app.
