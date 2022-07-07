@API @success
Feature: To test the functionality of jsonplaceholder users api's

  Scenario: To verify the get request for users returning valid response
    Given that a user is making a get call to fetch the "users" details
    When the API call returns with a status code of 200
    Then the user is able to validate 10 users in the response

  Scenario Outline: To verify user is able to get request using id parameters
    Given that user is initializing the base uri
    When a user requests a get call with "<param>", "<value>" and "<endpoint>"
    Then user is able to verify the "<name>" in the response

    Examples:
      | param | value | endpoint | name                     |
      | id    | 8     | users    | Nicholas Runolfsdottir V |

   Scenario: To verify that user is able to make a post request
     Given that user is initializing the base uri
     When  user is adding a user into "users" using post call
     Then the API call returns with a status code of 201
     And  user is able to validate the added details in the response
