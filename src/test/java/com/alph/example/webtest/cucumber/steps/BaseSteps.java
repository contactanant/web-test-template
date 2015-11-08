package com.alph.example.webtest.cucumber.steps;

import com.alph.example.webtest.selenium.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {
    private WebDriverConfig webDriverConfig;

    protected WebDriverConfig getWebDriverConfig() {
        return webDriverConfig;
    }

    protected WebDriver getWebDriver() {
        return webDriverConfig.getWebDriver();
    }
}
