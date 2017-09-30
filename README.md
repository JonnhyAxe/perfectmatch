# perfectmatch

#How to run

mvn spring-boot:run

#How to Test
http://localhost:8080/login

#Add Embedded DB
https://github.com/JonnhyAxe/sample-spring-boot-data-jpa-embedded

Then, you can access h2's console at: localhost:8080/h2-console Simply type in the url jdbc:h2:mem:PM_TEST;MVCC=true;DB_CLOSE_DELAY=-1;MODE=Oracle (spring.datasource.url)  in JDBC URL field and perfect_match (spring.datasource.username) in the user name field

#ADD Embedded DB to latest Spring Release

https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/

#Test Repository Endpoints

http://localhost:8080/sample/repo
http://localhost:8080/music/repo
http://localhost:8080/matches/repo


#Maven download dependencies Spurces and JavaDocs 
#https://stackoverflow.com/questions/310720/get-source-jar-files-attached-to-eclipse-for-maven-managed-dependencies
mvn dependency:sources
OR 
mvn clean install dependency:sources -Dmaven.test.skip=true

mvn dependency:resolve -Dclassifier=javadoc


#SQL 
Select * from Music where artist = 'Latmun'

TODOS:
SAMPLE entity with two @ID