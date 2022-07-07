@UI @success
Feature: To automate the BNZ client scenarios

  @BNZ
  Scenario: To verify the user can navigate to Payees page using the navigation menu in BNZ
    Given user is on BNZ client page
    When the user clicks on the Menu tab and selects the Payees option
    Then the user is able to validate that the payee page is loaded


  Scenario Outline: To verify the user can add a new payee in the Payees page in BNZ
    Given user is on BNZ client page
    When the user navigates to the payee page and add the payee details as "<name>", "<account number>"
    Then the user is able to see a successful message and the newly added payee in the payees list

    Examples:
      | name        | account number |
      | test user 1 | 1256768        |

  Scenario: To verify that payee name is a mandatory field in BNZ
    Given user is on BNZ client page
    And the user clicks on the Menu tab and selects the Payees option
    When the user clicks on the add payee button with an empty field of payee name
    Then the user is able to see the mandatory fields error message
    When the user populates the mandatory payee name field
    Then the error messages are no longer present


  Scenario: To verify that pages can be sorted by name in BNZ
    Given user is on BNZ client page
    When the user clicks on the Menu tab and selects the Payees option
    Then the user is able to verify the payee list in ascending order
    When the user clicks on the name header
    Then the user is able to verify that the payee list is sorted in descending order

  Scenario: To verify that user is able to make payment transfer in BNZ
    Given user is on BNZ client page
    And the user navigates to the payment transfer page
    When user transfer $500 from Everyday Account to Bills Account
    Then the user is able to see a successful message and be able to verify the current balance in both accounts