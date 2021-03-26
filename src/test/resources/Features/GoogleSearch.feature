Feature: Feature To Test Google Search Functionality

  Scenario: Validate Google Search is Working
    Given browser is open
    And User is on Google Search Page
    When User Enter a Text in Search Box
    And Hit Enter Button
    Then User is Navigated to Search Results
