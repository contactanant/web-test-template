# web-test-template

Web Test using cucumber selenium in Java

This is a comprehensive projects which combines many popular technologies for enterprise level web test framework

Technologies Used
Java8
cucumber
selenium
browser stack
spring

You can use either gradle or maven, whichever you like 

## Running the tests using gradle

* gradle cucumber

## Run individual feature files or test scenarios 

e.g.
* gradle cukes -PfeaturePath="src/test/resources/features" -PscenarioName="Viewing a title with subtitle"
* gradle cukes -PfeaturePath="src/test/resources/features/bbc.feature"

You can also select to run certain tags, or exclude them:
* gradle cukes -PfeaturePath="src/test/resources/features/article/content/article_tools.feature" -Ptags="@smoke" -Ptags="~@ignore"

## Test Reports
Access test report in /path-to-project-dir/build/test-results/cucumber-report

