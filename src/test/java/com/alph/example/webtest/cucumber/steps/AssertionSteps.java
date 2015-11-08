package com.alph.example.webtest.cucumber.steps;

import com.alph.example.webtest.domain.User;
import com.alph.example.webtest.selenium.WebDriverConfig;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.By;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@ScenarioScoped
public class AssertionSteps extends BaseSteps {

    private User user;

    @Inject
    public AssertionSteps(WebDriverConfig webDriverConfig, User user) {
        super(webDriverConfig);
        this.user = user;
    }

    @Then("^\"([^\"]*)\" link should be shown$")
    public void link_should_be_shown(String link) throws Throwable {
        assertEquals(link, getWebDriver().findElement(By.partialLinkText(link)).getText());
    }

    @Then("^reverse of the name should be \"([^\"]*)\"$")
    public void reverse_of_the_name_should_be(String text) throws Throwable {
        // Express the Regexp above with the code you wish you had
        assertEquals(text, new StringBuffer(user.getName()).reverse().toString());
    }

    @Then("^I should see a link \"([^\"]*)\"$")
    public void I_should_see_a_link(String linkName) throws Throwable {
        assertEquals(linkName, getWebDriver().findElement(By.partialLinkText(linkName)).getText());
    }
}
