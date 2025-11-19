Feature: HU 1 - User Registration
  As a User
  I want to register in the system
  So that I can log in to the application

  Scenario: The user successfully registers in the application
    Given that I am on the registration page
    When I enter my registration data
    Then the system shows me the message "Registration is successful"

  Scenario Outline: The user enters a password that does not meet security rules
    Given that I am on the registration page
    When I enter a password "<password>"
    Then the system shows me the message "<message>"

    Examples:
      | password     | message                                   |
      | password123  | Password must have uppercase characters   |
      | Password123  | Password must have symbol characters      |
