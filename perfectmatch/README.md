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
./start_containers.sh
```
Open the browser and access swagger ui with the docker IP, such as:

* http://192.168.99.100:8082/index.html#/ (first page load)
* http://192.168.99.100:8082/swagger-ui.html#/ (REST swagger ui)

All docker related files are located in the *docker* directory

- *Dockerfile*: this file describes the docker image of the service
- *docker-compose.yml*: this file manages 2 containers, a container based on the image created with *Dockerfile* file and a container based on the official MongoDB image.
- *docker-compose up --build -d*: build, start and link the 2 containers, this command is called from *start.sh*
- *./start-containers.sh*: builds a jar file without the Embedded MondoDB dependency and calls *docker-compose up --build -d*
- *docker-compose down*: stop the containers and remove them
- *./stop-containers.sh*: is identical to *docker-compose down*

Spring Boot apps run on port 8082 inside the container by default and we mapped that to the same port on the host using "-p" on the command line (HOST:CONTAINER)

Docker Registry???

References
* https://spring.io/guides/gs/spring-boot-docker/
* https://medium.freecodecamp.org/expose-vs-publish-docker-port-commands-explained-simply-434593dbc9a3

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

## Java 11

* Download Java 11 from Oracle
* install and define PATH and Java home with new installed version
* Install Eclispse plugin - https://marketplace.eclipse.org/content/java-11-support-eclipse-2018-09-49
* Downlaod the latest mvn version (optional)


https://medium.com/criciumadev/its-time-migrating-to-java-11-5eb3868354f9
https://winterbe.com/posts/2018/08/29/migrate-maven-projects-to-java-11-jigsaw/

## swagger 

java -jar swagger-codegen-cli-2.4.2.jar generate  -i http://localhost:8080/v2/api-docs.json  --api-package com.perfectmatch.web.client.api  --model-package com.perfectmatch.web.client.model  --invoker-package com.perfectmatch.web.client.invoker   --group-id com.baeldung  --artifact-id spring-swagger-codegen-api-client  --artifact-version 0.0.1-SNAPSHOT  -l java  --library resttemplate  -o perfectmatch-swagger-codegen-api-client

https://www.baeldung.com/spring-boot-rest-client-swagger-codegen

## EhCache 
---

In order to speed up performance, specially for the service that compute music matchs with the predefined rules in large data sets, is convenient to retrieve (and therefore cache) data mostly used. 

* https://blog.goyello.com/2010/07/29/quick-start-with-ehcache-annotations-for-spring/
* https://docs.spring.io/spring/docs/3.1.0.RC1/spring-framework-reference/html/cache.html
* https://code.google.com/archive/p/ehcache-spring-annotations/
* https://blog.zenika.com/2014/06/03/spring-cache/
* https://blog.goyello.com/2012/01/20/quick-start-with-methods-caching-using-spring-3-1-and-ehcache/
* https://dzone.com/articles/spring-cache-annotation-tips-and-tricks

## Couchbase
---

* https://blog.couchbase.com/couchbase-spring-cache/
