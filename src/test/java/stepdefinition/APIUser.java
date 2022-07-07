package stepdefinition;

import actions.APIAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APIUser {

    APIAction apiAction = new APIAction();

    @Given("that a user is making a get call to fetch the {string} details")
    public void thatAUserIsMakingAGetCallToFetchTheUsersDetails(String endpoint) {
        apiAction.fetchingTheUserDetails(endpoint);
    }

    @When("the API call returns with a status code of {int}")
    public void theApiCallReturnsWithAstatusCodeOf(Integer statusCode) {
        apiAction.validatingTheStatusCode(statusCode);

    }

    @Then("the user is able to validate {int} users in the response")
    public void theUserIsAbleToValidateUsersInTheResponse(Integer userCount) {
        apiAction.validatingTheNoOfUserInResponse(userCount);
    }

    @Given("that user is initializing the base uri")
    public void thatUserIsInitializingTheBaseUri() {
        apiAction.initializingBaseUri();
    }

    @When("a user requests a get call with {string}, {string} and {string}")
    public void aUserRequestsAGetCallWithAnd(String queryParam, String value, String endpoint) {
        apiAction.getCallWithParams(queryParam,value,endpoint);
    }

    @Then("user is able to verify the {string} in the response")
    public void userIsAbleToVerifyTheInTheResponse(String name) {
        apiAction.validatingTheNameInResponse(name);
    }

    @When("user is adding a user into {string} using post call")
    public void userIsAddingAUserIntoUsingPostCall(String endpoint) throws Throwable {
        apiAction.addingANewUser(endpoint);
        }

    @And("user is able to validate the added details in the response")
    public void userIsAbleToValidateTheAddedDetailsInTheResponse() {
        apiAction.userIsValidatingTheResponseForNewlyAddedUser();
    }
}
