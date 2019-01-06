

## Jacoco Unit Tests Coverage Reports

In order to verify the Unit test coverage the Jacoco maven plugin is used and the report is generated under the target/site/jacoco/


##Test pyramid
In order to keep our tests running fast : 
https://martinfowler.com/articles/practical-test-pyramid.html
https://content.pivotal.io/blog/what-is-a-unit-test-the-answer-might-surprise-you

## Unit Testing

In order to test exceptions and associated messages the following code can be used
```
import static org.assertj.core.api.Assertions.*;

assertThatThrownBy(() -> Address.ofCountry(null)).hasMessage("Country can not be null.");
```

```
import static org.assertj.core.api.Assertions.*;


assertThatThrownBy(() -> { <<Code under testing>>}).hasMessage("Expected Message");

```

## Spring Testing Strategy

https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html



https://www.baeldung.com/spring-tests

There are some tricks we can apply in Spring to keep it low and optimized our build time, as well as some pitfalls that might impact its speed:

###  Using profiles – how profiles impact performance
Every time we pull a test with a new profile, a new ApplicationContext gets created. Which enables or disables certain areas of our App

### Reconsidering @MockBean – how mocking hits performance

Every time @MockBean appears in a class, the ApplicationContext cache gets marked as dirty, hence the runner will clean the cache after the test-class is done (extra seconds to our build.).

### Refactoring @MockBean – alternatives to improve performance

Refactor @MockBean with @MockMvc to test only HTTP layer and backend service invocation. So we’ll end up persisting the entity as 
the side effect.

### Thinking carefully about @DirtiesContext – a useful but dangerous annotation and how not to use it

@DirtiesContext allow us to modify the ApplicationContext in our tests and the common uses cases cache reset or in memory DB resets. @DirtiesContext is an extremely expensive resource when it comes to execution time, therefore it should be used if no
better alternative exists.

### Using test slices – a cool tool that can help or get on our way

Spring will create a reduced application (including minimal configuration effort) context for a specific slice of your app.
This particular feature if used wisely can help us build narrow tests. 

* @JsonTest: Registers JSON relevant components
* @DataJpaTest: Registers JPA beans, including the ORM available
* @JdbcTest: Useful for raw JDBC tests, takes care of the data source and in memory DBs without ORM frills
* @DataMongoTest: Tries to provide an in-memory mongo testing setup
* @WebMvcTest: A mock MVC testing slice without the rest of the app
* all :  https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-test-autoconfigure/src/main/java/org/springframework/boot/test/autoconfigure

### Using class inheritance – a way to organize tests in a safe manner

Simple, powerful and pragmatic way of keeping the build fast by providing a solid setup, our team will simply extend it, knowing that everything ‘just works’. 

### State management – good practices to avoid flakey tests

The result of a test should be consistent regardless of whether it is executed in isolation or together with other tests.
Create and AbstractSpringIntegrationTest (entral place to manage state) and clean/reset the side effects with @Before.

### Refactoring into unit tests – the best way to get a solid and snappy build

Whenever we find some integration tests testing a bunch of cases of core business logic, it’s time to break them down into unit tests.

https://dzone.com/articles/unit-and-integration-tests-in-spring-boot-2

### Unit and Integration Tests for RestControllers in Spring Boot

https://thepracticaldeveloper.com/2017/07/31/guide-spring-boot-controller-tests/

There are two main strategies we can identify in Spring for server-side scope tests:
* writing Controller tests using the MockMVC approach (real Unit Test by fine-grain our assertions for the Controller.)
* making use of RestTemplate (integration purpose with Spring’s WebApplicationContext).

First strategy is using MockMVC in standalone mode it is not necessary to load any context, and it’s closer to the definition of a Unit Test.
The web server is completely mocked and should be tested/delegated to Integration Tests.

* MockitoJUnitRunner - detects that the framework is being used, and initializes for us all the fields annotated with @Mock 
* Use @InjectMocks for the controllers so the @Mock are injected inside it.
* MockMVC instance to perform all kind of fake requests (GET, POST, etc.) 
* JacksonTesterobject 
* explicitly configure filters and controller advices

The second strategy is to use MockMVC witWebApplicationContext 
* @RunWith(SpringRunner.class) to initialize the context and inject beans
* @WebMvcTest(NamedController.class) - loads the required controller to test and the surrounding configurations. The filter and Controller Advice will be injected
* @MockBean injects the controller to be tested
* Response are fake and of type MockHttpServletResponse, instead of ResponseEntity as the real requests returns 


The third strategy is to use SpringBootTest with a MOCK WebEnvironment. 
 * use @SpringBootTest or @SpringBootTest(webEnvironment = WebEnvironment.MOCK) annotation to write an inside-server test as we do not load a real server (????)
 * can't use RestTemplate since we don’t have any web server
 * use  MockMVC, which now is getting configured thanks to the annotation @AutoconfigureMockMVC
 * loads all the context, therefore a more complete workflow can be used 
 
 The last strategy is to use @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) or @SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) 
 * loads a real HTTP server (such as filtering, interceptors, authentication, etc.)
 * is helpful when you want to run parallel tests, to avoid port clashing.
 * responses are ResponseEntity type
 * have the ability to mock the repository layer with @MockBean annotation.
 * Inject TestRestTemplate which provides extra functionalities

For  the strategy 2, 3 and 4 reuse the Spring context after it loads for the first time, therefore bear in mind the side effects and use @DirtiesContext to clean it or create an @Before function that cleans it. 

## BBDMockito 

https://thepracticaldeveloper.com/2018/05/10/write-bdd-unit-tests-with-bddmockito-and-assertj/

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

## EhCache 

* https://blog.goyello.com/2010/07/29/quick-start-with-ehcache-annotations-for-spring/
* https://docs.spring.io/spring/docs/3.1.0.RC1/spring-framework-reference/html/cache.html
* https://code.google.com/archive/p/ehcache-spring-annotations/
* https://blog.zenika.com/2014/06/03/spring-cache/
* https://blog.goyello.com/2012/01/20/quick-start-with-methods-caching-using-spring-3-1-and-ehcache/
* https://dzone.com/articles/spring-cache-annotation-tips-and-tricks

## Couchbase
* https://blog.couchbase.com/couchbase-spring-cache/
