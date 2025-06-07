Feature: Main Screen

  @smoke
  Scenario: Display welcome message
    Given I launch the application
    When the main screen is displayed
    Then I should see "Hello Android!" text

  @ui
  Scenario: Basic UI interaction
    Given I launch the application
    When I interact with the main screen
    Then the application should respond correctly