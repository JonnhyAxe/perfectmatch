## Automated web tests using Serenity, Cucumber and Maven

Run the tests like this:

```
mvn clean verify
```

The reports will be generated in `target/site/serenity`.

Please keep in my that these tests uses Serenity Spring that use application context and DI capabilities for more flexible testing suites. 

## JBehave VS Cucumber

In order to understand which tool is better for a given part of the layer code under testing, and considering they have support for Serenity reporting, the following link have a good comparison.
* http://mkolisnyk.blogspot.com/2013/03/jbehave-vs-cucumber-jvm-comparison.html (2013 post)
* http://thucydides.info/docs/articles/an-introduction-to-serenity-bdd-with-cucumber.html

For the backend the Serenity Spring might be handy (https://mvnrepository.com/artifact/net.serenity-bdd/serenity-spring/2.0.8), as it allow us to load the application context and run intergration test for different layers (web/REST, Service and Repository), and gerenate the reports. 

Having a look on the dependencies, it looks like it has support for https://mvnrepository.com/artifact/net.serenity-bdd/serenity-cucumber/1.9.19. The following section has how to use. 


It is also possible to use Serenity with Jbehave and Spring https://www.baeldung.com/serenity-spring-jbehave

As a PoC the Serenity has the support to merge reports, therefore reports created by different projects may work if the use same versions.

## Serenity with Cucumber (without Serenity-spring)

* http://testerstories.com/2016/07/using-serenity-with-cucumber-part-1/
* http://testerstories.com/2016/07/using-serenity-with-cucumber-part-2/
* http://testerstories.com/2016/07/using-serenity-with-cucumber-part-3/
* https://github.com/serenity-bdd/serenity-demos

## Serenity with Cucumber and Spring/Spring Boot
* https://groups.google.com/forum/#!topic/thucydides-dev/_u62OTxEbZg
* http://blizzardcomputing.com/blog/microservices/component-testing-with-wiremock-part1
* http://www.blizzardcomputing.com/blog/microservices/component-testing-with-wiremock-part2
* https://github.com/serenity-bdd/serenity-core

## Serenity with JBehave 

* https://www.baeldung.com/serenity-spring-jbehave
