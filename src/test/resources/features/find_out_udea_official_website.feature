Feature: Find out UDEA official website
  As a student I want to find out the official website of the University of Antioquia (UDEA)
  So that I can access accurate information about the university

  Scenario: Search for UDEA official website using a search engine
    Given I am on the Google homepage
    When I search for U de A
    Then I should see tge UdeA's official website


