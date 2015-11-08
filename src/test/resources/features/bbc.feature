Feature: bbc.com browser testing

  Scenario: Deeplink world/news should show Asia link
    Given I visit bbc news
    When I search for "flying cars" on BBC news
    Then "Asia" link should be shown
