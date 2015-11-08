# web-test-template

Web Test using cucumber selenium in Java

This is a comprehensive projects which combines many popular technologies for enterprise level web test framework

Technologies Used
* Java8
* cucumber
* selenium
* google-guice

You can use either gradle or maven, whichever you like 

bbc.feature shows uses of webdriver (single instance across tests) marked as @Singleton
share-data-between-steps.feature shows how we can share data between steps
Note the uses of @ScenarioScoped which keeps data separate for each scenario

## Running the tests using gradle

from project root 

* ./gradlew clean test

you can supply a browser env variable like following (default browser is phantomjs)
* TEST_BROWSER=FIREFOX ./gradlew cukes

* ./gradlew cukes -PfeaturePath="src/test/resources/features"
* ./gradlew cukes -PfeaturePath="src/test/resources/features/bbc.feature"

You can also select to run certain tags, or exclude them:
* gradlew cukes -PfeaturePath="src/test/resources/features/features/bbc.feature" -Ptags="@RunThis"

You can also execute test using CucumberSuite as a junit test
 * gradlew cucumber

## Chrome Driver
if you want to use chrome, download it from https://sites.google.com/a/chromium.org/chromedriver/downloads 
copy the chrome driver to /usr/local/chromedriver

## Test Reports
Access test report in /path-to-project-dir/build/test-results/cucumber-report
