# notes
Web application for notes

#Steps to start app locally
```
set JDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/notes
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
