Feature: User authentication

  Users must authenticate to access the Billing and Payments module.

  Scenario: User gains access with valid credentials
    Given I provide valid authentication credentials
    When I attempt to sign in
    Then I should gain access to the application

  Scenario: User is informed when authentication fails
    Given I provide invalid authentication credentials
    When I attempt to sign in
    Then I should see the message "Email o contraseña incorrectos"
