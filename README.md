# perfectmatch


[![Build Status](https://travis-ci.org/JonnhyAxe/perfectmatch.svg?branch=master)](https://travis-ci.org/dwyl/learn-travis)


[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=JonnhyAxe_perfectmatch&metric=alert_status)](https://sonarcloud.io/dashboard?id=JonnhyAxe_perfectmatch)

## Project setup
---

Import the project in the in eclipse (for development java purposes) and Visual studio Code (for Vue development).

```
├─┬ backend     				  		→ backend module with Java/Spring Boot code
│ ├── src
│ └── pom.xml     
│ └── target/site/jacoco/index.html 	→ java unit tests coverage report
│ └── target/site/serenity/index.html 	→ java module acceptance tests coverage report
│ └── docker				→ Docker and docker compose files
├─┬ frontend    			→ frontend module with Vue.js code
│ ├── src
│ └── pom.xml 
│ └── README.md
│ └── /test/unit/coverage/lcov-report/index.html 	→ javascript unit tests coverage report
├─┬ swagger-vue-master 				  	→ Swagger Vuejs API code generator with Axios
│ └── README.md
├─┬ perfectmatch-acceptance-testing-with-cucumber → Acceptance Testing with Nightwatch.js, Cucumber.js and BrowserStack
│ └── README.md
├─┬ junit-webtests  				  → Automated web tests using Serenity, Cucumber and Maven
│ └── README.md
└── pom.xml     → Maven parent pom managing both modules
```

## First App run
---
Please keep in mind that this app uses an MongoDb running as an System service or as embedded (by default). 

Execute the following commands in order to build all projects:

```
> mvn --projects perfectmatch spring-boot:run -Dspring.profiles.active=dev
```
Alternatively execute the java class `<path_to_app>.Application` in the backend project.

Notice the dev profile activation in order to run an module that inserts data at load time for testing purposes. 

Now go to [http://localhost:8082/index.html#/](http://localhost:8080/index.html#/ ) and the app should load.

All javascrip files (under the folder node_mdules) and java dependencies are resolved and no additional steps is required. 
You can refer to the file [README.md](./perfectmatch-vue/README.md), to just resolve Javascript dependencies independently.

Additional info can be found in specific project folder:

* [Vue js module](./perfectmatch-vue/README.md)
* [Swagger Vuejs Api code generator](./swagger-vue-master/README.md)
* [Acceptance Testing with Nightwatch.js, Cucumber.js and BrowserStack](./perfectmatch-acceptance-testing-with-cucumber/README.md)
* [Automated web tests using Serenity, Cucumber and Maven](./junit-webtests/README.md)
* [Backend module](./perfectmatch/README.md)

## Fast feedback with webpack-dev-server
---

The webpack-dev-server, which will update and build every change through all the parts of the JavaScript build-chain, is pre-configured in Vue.js out-of-the-box! So the only thing needed to get fast feedback development-cycle is to cd into `"C:\<PATH_TO_GIT>\.....\vue"` and run:

```
npm run dev
```

That's it, the root page should be automatically opened! Every change in the Vue.js files are automatically updated, if not just refresh the page. You should confirm the change in the Chrome dev tools: 

* Ctrl + Shift + l
* Click on the Sources tab
* On the left list, navigate to webpack and choose the changed file 

Notice that the port is not the same when the app is started from the backend module. The main purpose is to have independent process in order to change Js and Java files independently. 
After the required change is made, just commit the changes and they should be correctly updated in the next build. The perfectmatch project pom is configured to copy the content of the `${project.parent.basedir}/frontend/target/dist` directoy, which has the most recent changes in the Vue.js files.

## Browser developer tools extension
---
These plugins are required to be installed by machine administrators 

Install vue-devtools Browser extension (https://chrome.google.com/webstore/detail/vuejs-devtools/nhdogjmejiglipccpnnnanhbledajbpd),  and DejaVue (https://chrome.google.com/webstore/detail/dejavue/jpigngmphmclcmikmcbcfplgnhlnefbp?hl=en) get better feedback on the Vue.js objects, 

e.g. in Chrome:

* Ctrl + Shift + l
* Click on the Vue tab
* On the left list, navigate to the required module and view the data state of the object 


## Ports

|     Application       |     Port          |
| ------------- | ------------- |
| Spring Cloud Config Server | 8888 |
|  |  |



## URLs

|     Application       |     URL          |
| ------------- | ------------- |
|Spring Cloud Config Server| http://localhost:8888/perfectmatch-webapp/default http://localhost:8888/perfectmatch-webapp/dev |



## IDEs (Optional with Visual Studio Code)
---


Install CodeMix (trial version) plugin for VueJs development. This is optional with Visual Studio Code. 
Note that with CodeMix plugin you lose the Vue Syntax Highlighting, after the trial expires´.

1. Install eclipse Java EE Photon Release (4.8.0) 

2. Add proxy configuration: 
>Window - Preferences -> Network Connections -> Proxy Bypass -> add http://domain:port  

3. Install CodeMix plugin: 

Help -> Install New Software -> http://www.genuitec.com/updates/codemix/ci/

4. Configure installed NodeJs

Window -> Preferences -> Javascript -> Tern -> Server -> Node.js -> "Node.js install" select "-- Choose your node.js install --" -> C:\dev\tools\node
 

## Maven NPM install with proxy maven settings (TODO)
---

There is an issue installing Chrome driver from maven. 
As the workaround execute the following command line, with the proper user and password, in the vue project

```
> npm config set strict-ssl false
> npm install -l --proxy=http://<USER>:<PASS>@purl:8080  --https-proxy=http://<USER>:<PASS>@url:8080
> cd ..
> mvn clean install
```

[INFO] > node install.js
[INFO]
[INFO] PhantomJS not found on PATH
[INFO] Download already available at C:\Users\MACHAD~1\AppData\Local\Temp\phantomjs\phantomjs-2.1.1-windows.zip
[INFO] Verified checksum of previously downloaded file
[INFO] Extracting zip contents
....
[INFO] Downloading https://chromedriver.storage.googleapis.com/2.41/chromedriver_win32.zip
[INFO] Saving to C:\Users\MACHAD~1\AppData\Local\Temp\chromedriver\chromedriver_win32.zip
[ERROR] ChromeDriver installation failed Error with http(s) request: Error: tunneling socket could not be established, statusCode=407
[WARNING] npm WARN vue-routing@1.0.0 No repository field.
[WARNING] npm WARN vue-routing@1.0.0 scripts['server'] should probably be scripts['start'].
[WARNING] npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.4 (node_modules\fsevents):
[WARNING] npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.4: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})
[ERROR]
[ERROR] npm ERR! code ELIFECYCLE
[ERROR] npm ERR! errno 1
[ERROR] npm ERR! chromedriver@2.41.0 install: `node install.js`
[ERROR] npm ERR! Exit status 1
[ERROR] npm ERR!
[ERROR] npm ERR! Failed at the chromedriver@2.41.0 install script.
[ERROR] npm ERR! This is probably not a problem with npm. There is likely additional logging output above.
[ERROR]
[ERROR] npm ERR! A complete log of this run can be found in:
[ERROR] npm ERR!     C:\Users\machadojo\AppData\Roaming\npm-cache\_logs\2018-09-11T14_49_28_475Z-debug.log
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 01:32 min
[INFO] Finished at: 2018-09-11T16:49:28+02:00
[INFO] Final Memory: 20M/243M
[INFO] ------------------------------------------------------------------------
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
[ERROR]
[ERROR] After correcting the problems, you can resume the build with the command
[ERROR]   mvn <goals> -rf :fxhub.mhubweb.nextgen.vue



## References:
 * https://github.com/angelozerr/tern.java/wiki/Tern-Linter-ESLint
 * https://github.com/vuejs/eslint-plugin-vue (<!-- eslint-disable -->)
 * https://github.com/vuejs/vue-devtools/blob/master/shells/electron/README.md
 * https://github.com/eirslett/frontend-maven-plugin/issues/652
 * https://medium.com/skyshidigital/8-vuejs-plugins-to-speed-up-your-front-end-development-61528155f280
 * https://hackernoon.com/a-tale-of-webpack-4-and-how-to-finally-configure-it-in-the-right-way-4e94c8e7e5c1
 * https://dev.to/rhymes/what-vuejs-framework-should-i-use-4nk1
 * https://blog.bitsrc.io/11-vue-js-component-libraries-you-should-know-in-2018-3d35ad0ae37f
 * https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet


## Testing References
 * https://vuejs.org/v2/guide/unit-testing.html
 * https://vuejs.org/v2/cookbook/unit-testing-vue-components.html
 * https://vue-test-utils.vuejs.org/
  
 



