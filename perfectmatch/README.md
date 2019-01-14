## Install Lambok 
---

In order to not to have IDE issues with project lambok install it with the following.

https://howtodoinjava.com/automation/lombok-eclipse-installation-examples/#lombok-eclipse

```
java -jar <path_to_lombok.jar> delombok src -d src-generator
```


## Jacoco Unit Tests Coverage Reports
---

In order to verify the Unit test coverage the Jacoco maven plugin is used and the report is generated under the target/site/jacoco/

## Docker
---

Open "Docker QuickStart Terminal"

```
cd /d/git/perfectmatch/perfectmatch/docker
./start_container.sh
```
Open the browser and access swagger ui with the docker IP, such as:

* http://192.168.99.100:8082/index.html#/ (first page load)
* http://192.168.99.100:8082/swagger-ui.html#/ (rest swagger ui)

All docker related files are located in the *docker* directory

- *Dockerfile*: this file describes the docker image of the service
- *docker-compose.yml*: this file manages 2 containers, a container based on the image created with *Dockerfile* file and a container based on the official MongoDB image.
- *docker-compose up --build -d*: build, start and link the 2 containers, this command is called from *start.sh*
- *./start-container.sh*: builds a jar file without the Embedded MondoDB dependency and calls *docker-compose up --build -d*
- *docker-compose down*: stop the containers and remove them
- *./stop-container.sh*: is identical to *docker-compose down*

https://spring.io/guides/gs/spring-boot-docker/

## Sonar 
---

Install sonar : https://www.sonarqube.org/downloads/
Start Sonar : https://docs.sonarqube.org/latest/setup/get-started-2-minutes/

```
C:\<<SONAR_INSTALLATION_DIR>>\windows-x86-xx\StartSonar.bat 
```

Run Sonar with maven plugin :

```
mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 
```

## EhCache 
---

* https://blog.goyello.com/2010/07/29/quick-start-with-ehcache-annotations-for-spring/
* https://docs.spring.io/spring/docs/3.1.0.RC1/spring-framework-reference/html/cache.html
* https://code.google.com/archive/p/ehcache-spring-annotations/
* https://blog.zenika.com/2014/06/03/spring-cache/
* https://blog.goyello.com/2012/01/20/quick-start-with-methods-caching-using-spring-3-1-and-ehcache/
* https://dzone.com/articles/spring-cache-annotation-tips-and-tricks

## Couchbase
---

* https://blog.couchbase.com/couchbase-spring-cache/
