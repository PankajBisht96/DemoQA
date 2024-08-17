Feature: Verify Elements Tab

  Background: User is on Elements home page
    Given DemoQA application is launched
    And User clicks on Elements tab
    And User is on Elements page

  Scenario: Validate Text-Box tab
    When User clicks on Text-Box button
    And enters the required details "TB01"
    And clicks on submit button
    Then entered data is displayed correctly "TB01"
