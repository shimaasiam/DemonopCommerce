@smoke
Feature: select random menu category and select its sub category
  Scenario: select category and its sub category and verify displayed correctly
    When user select random category from menu and hover on it
    And user select sub category of selected category and click on it
    Then user will view sub category details and verify title