package com.alph.example.webtest.cucumber.steps;

import com.alph.example.webtest.selenium.WebDriverConfig;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    //TODO: Instantiate webdriverConfig here
    WebDriverConfig webDriverConfig;

    @Before
    public void beforeScenario(Scenario scenario) {
        //TODO: placeholder to do more stuff before scenario
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        embedScreenshotOnFailure(scenario);
        webDriverConfig.resetBrowser();
    }

    public void embedScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            webDriverConfig.saveSourceAndScreenshot(scenario);
        }
    }
}
