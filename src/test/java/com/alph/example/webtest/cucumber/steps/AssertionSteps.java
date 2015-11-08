package com.alph.example.webtest.cucumber.steps;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class AssertionSteps extends BaseSteps {

    @Then("^\"([^\"]*)\" link should be shown$")
    public void link_should_be_shown(String link) throws Throwable {
        assertEquals(link, getWebDriver().findElement(By.linkText(link)).getText());
    }

}
