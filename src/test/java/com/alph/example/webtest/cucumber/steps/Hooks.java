package com.alph.example.webtest.cucumber.steps;

import com.alph.example.webtest.selenium.WebDriverConfig;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;

import javax.inject.Inject;

@ScenarioScoped
public class Hooks {

    WebDriverConfig webDriverConfig;

    @Inject
    public Hooks(WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
    }

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
