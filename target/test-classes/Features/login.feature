Feature: Feature To Test Login functionality

  Scenario: Check login is Successful with valid credentials
    Given chrome browser is open
    And user is on login page
    When user enters username and password
    And clicks on login button
    Then user navigated to homepage
