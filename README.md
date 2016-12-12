#notes
Web application for notes and sending emails(from notes)

#heroku
available on https://best-notes.herokuapp.com/

#Steps to start app locally
```
set JDBC_DATABASE_URL=jdbc:postgresql://<host>:<port>/<db-name>
set JDBC_DATABASE_USERNAME=<db-username>
set JDBC_DATABASE_PASSWORD=<db-password>
```
```
mvn clean install
```
```
java -jar target/dependency/webapp-runner.jar target/*.war
```
Type in browser
```
http://localhost:8080/
```
