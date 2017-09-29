# perfectmatch

#How to run

mvn spring-boot:run

#How to Test
http://localhost:8080/login

#Add Embedded DB
https://github.com/JonnhyAxe/sample-spring-boot-data-jpa-embedded

Then, you can access h2's console at: localhost:8080/h2-console Simply type in the url jdbc:h2:mem:PM_TEST;MVCC=true;DB_CLOSE_DELAY=-1;MODE=Oracle (spring.datasource.url)  in JDBC URL field and perfect_match (spring.datasource.username) in the user name field



