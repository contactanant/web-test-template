package com.alph.example.webtest.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:build/cucumber-report/parallel2"}, features = {"classpath:features/bbc.feature"}, glue = {"com.alph.example.webtest.cucumber.steps"})
public class RunCukesParallelSuite2 {
}
