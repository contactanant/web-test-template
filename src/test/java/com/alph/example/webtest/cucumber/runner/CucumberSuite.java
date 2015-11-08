package com.alph.example.webtest.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:build/cucumber-report"}, features = {"classpath:features"}, glue = {"com.alph.example.webtest.cucumber.steps"})
public class CucumberSuite {
}
