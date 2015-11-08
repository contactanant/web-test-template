package com.alph.example.webtest.cucumber.page;

import com.alph.example.webtest.selenium.WebDriverConfig;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.By;

import javax.inject.Inject;

@ScenarioScoped
public class BbcNewsPage {

    private WebDriverConfig webDriverConfig;

    @Inject
    public BbcNewsPage(WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
    }

    public void search(String text) {
        webDriverConfig.getWebDriver().findElement(By.id("orb-search-q")).sendKeys(text);
        webDriverConfig.getWebDriver().findElement(By.id("orb-search-button")).click();
    }

    public void clickWorldMenu() {
        webDriverConfig.getWebDriver().findElement(By.partialLinkText("World")).click();
    }
}
