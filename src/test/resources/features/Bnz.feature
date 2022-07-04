Feature: To automate the bnz client scenarios

  Scenario: To verify the user can navigate to Payees page using the navigation menu
    Given user is on BNX client page
    When the user clicks on the Menu tab and selects the Payees option
    Then the user is able to validate that the payee page is loaded


  Scenario Outline: To verify the user can add a new payee in the Payees page
    Given user is on BNX client page
    When the user navigates to the payee page and add the payee details as "<name>", "<account number>"
    Then the user is able to see a successful message and the newly added payee in the payees list

    Examples:
      | name          | account number |
      | test user 3 | 1256768      |



