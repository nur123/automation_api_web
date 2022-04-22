Feature: Add Quote
  @Test
  Scenario: Add Quote With Color Yellow
    Given user open add quote page
    When user input quote "Test"
    When user select color "Yellow"
    When user click button add quote