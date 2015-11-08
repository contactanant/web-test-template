package com.alph.example.webtest.cucumber.steps;

import com.alph.example.webtest.cucumber.page.BbcNewsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class UserSteps extends BaseSteps {

    @Given("^I visit bbc news$")
    public void I_visit_bbc_news() throws Throwable {
        getWebDriver().get("http://www.bbc.com/news");
    }

    @When("^I search for \"([^\"]*)\" on BBC news$")
    public void I_search_for_on_BBC_news(String searchText) throws Throwable {
        BbcNewsPage bbcNewsPage = new BbcNewsPage(getWebDriver());
        bbcNewsPage.search(searchText);
    }
}
