package com.alph.example.webtest.cucumber.steps;

import com.alph.example.webtest.cucumber.page.BbcNewsPage;
import com.alph.example.webtest.domain.User;
import com.alph.example.webtest.selenium.WebDriverConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

import javax.inject.Inject;

@ScenarioScoped
public class UserSteps extends BaseSteps {

    private User user;
    private BbcNewsPage bbcNewsPage;

    @Inject
    public UserSteps(WebDriverConfig webDriverConfig, User user, BbcNewsPage bbcNewsPage) {
        super(webDriverConfig);
        this.user = user;
        this.bbcNewsPage = bbcNewsPage;
    }

    @Given("^I visit bbc news$")
    public void I_visit_bbc_news() throws Throwable {
        getWebDriver().get("http://www.bbc.com/news");
    }

    @When("^I search for \"([^\"]*)\" on BBC news$")
    public void I_search_for_on_BBC_news(String searchText) throws Throwable {
        bbcNewsPage.search(searchText);
    }

    @When("^I create user with name \"([^\"]*)\"$")
    public void I_create_user_with_name(String name) throws Throwable {
        this.user.setName(name);
    }

    @When("^I click on the World menu$")
    public void I_click_on_the_World_menu() throws Throwable {
        bbcNewsPage.clickWorldMenu();
    }
}
