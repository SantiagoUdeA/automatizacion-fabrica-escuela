Feature: HU1 - User login

  As a user, I need to log in to access the Billing and Payments module.

  Scenario: The user logs in with valid credentials
    Given I am on the login page
    When I login with valid credentials
    Then I should be redirected to the main panel page

  Scenario: The user enters invalid credentials
    Given I am on the login page
    When I try to login with invalid credentials
    Then I should see the message "Email o contraseña incorrectos"