# Java Automation MOBILE project

## Installation
You need to have:
* [JDK 1.8](https://www.oracle.com/ar/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* Set JAVA_HOME - MAVEN_HOME - ANDROID_HOME environment variables.
* [Appium desktop](https://github.com/appium/appium-desktop/releases)
* TestNG plugin (if you want to run with TestNG)
* Cucumber for Java plugin (if you want to run with Cucumber)
* [Android studio](https://developer.android.com/studio#downloads) (to use Appium desktop and inspect the apk)

## How it works
We have a BDD structure, so I recommend that see first the features file, then go step after step understand his behaviour.

## Run
### All testcases:
mvn clean test

### Only smoke:
mvn clean test "-Dcucumber.filter=-t @Smoke"

### Specific functionality:
mvn clean test "-Dcucumber.filter=-t @Login"

#### Functionalities availables:
@Login @Contacts

## Debug:
mvn clean test -DforkCount=0

## Technologies used:
* Java jdk 1.8
* Maven
* Appium
* TestNG (runner)
* Cucumber (BDD)

## Reports
The report, once we run the test, is located in target/cucumber-reports/index.html

## Project structure
* <i>src/test/resources/features</i> = features files with the scenarios, gherkin and data (BDD).
* <i>src/test/resources/app</i> = app available to test (apk only for now)
* <i>src/test/java/**/Hooks</i> = hooks in general of cucumber for this project (before and after)
* <i>src/main/resources</i> = cucumber options that are loaded from pom.xml file
* <i>src/main/java/**/steps</i> = steps that matches with gherkin from features files
* <i>src/main/java/**/views</i> = interactions with the views of the application
* <i>src/main/java/**/core</i> = different implementations:
    * DriverService: manage the driver instance
    * Browser package: Different browser implementations (their capabilities, driver class, etc) and BrowserType enum with the different types of browser
    * PropertyManager: loads the properties (located in config.properties) and use them in the lifecycle
    * Report package: implementation of the status report with a manager, and a service

## Some explanation
This framework is a basic mobile automation project, with a lot o variables hardcoded, without profiles, properties, log, waits and basic report.
A lot of things can be improved here.