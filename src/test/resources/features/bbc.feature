Feature: BBC News website

  Scenario: search flying cars
    Given I visit bbc news
    When I search for "flying cars" on BBC news
    Then "Self-flying cars in the sky?" link should be shown

  Scenario: Deeplink world/news should show Asia link
    Given I visit bbc news
    When I click on the World menu
    Then I should see a link "Asia"
