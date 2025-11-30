Feature: User authentication

  The authenticated users can update invoices that are in 'Draft' status.

    Scenario: The user updates a draft invoice successfully
        Given I have an invoice in Draft status
        When I update the invoice details
        Then I should see a message "Los cambios se guardaron exitosamente"

