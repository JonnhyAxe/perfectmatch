## Install Lambok 

https://howtodoinjava.com/automation/lombok-eclipse-installation-examples/#lombok-eclipse
s
## Jacoco Unit Tests Coverage Reports

In order to verify the Unit test coverage the Jacoco maven plugin is used and the report is generated under the target/site/jacoco/

## Sonar 

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

* https://blog.goyello.com/2010/07/29/quick-start-with-ehcache-annotations-for-spring/
* https://docs.spring.io/spring/docs/3.1.0.RC1/spring-framework-reference/html/cache.html
* https://code.google.com/archive/p/ehcache-spring-annotations/
* https://blog.zenika.com/2014/06/03/spring-cache/
* https://blog.goyello.com/2012/01/20/quick-start-with-methods-caching-using-spring-3-1-and-ehcache/
* https://dzone.com/articles/spring-cache-annotation-tips-and-tricks

## Couchbase
* https://blog.couchbase.com/couchbase-spring-cache/
