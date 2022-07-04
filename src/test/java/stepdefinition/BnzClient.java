package stepdefinition;

import actions.ClientAction;
import actions.PayeeAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BnzClient {
    ClientAction userIs = new ClientAction();
    PayeeAction user = new PayeeAction();

    @Given("user is on BNX client page")
    public void user_is_on_bnx_client_page() {
        userIs.navigateToBnzClient();
    }

    @When("the user clicks on the Menu tab and selects the Payees option")
    public void theUserClicksOnTheMenuTabAndSelectsThePayeesOption() {
        userIs.navigatingToThePayeePage();
    }

    @Then("the user is able to validate that the payee page is loaded")
    public void theUserIsAbleToValidateThatThePayeePageIsLoaded() {
    }

    @Then("the user is able to see a successful message and the newly added payee in the payees list")
    public void theUserIsAbleToSeeASuccessfulMessageAndTheNewlyAddedPayeeInThePayeesList() {
            user.payeeSuccefulMessage();
    }

    @When("the user navigates to the payee page and add the payee details as {string}, {string}")
    public void theUserNavigatesToThePayeePageAndAddThePayeeDetailsAs(String name, String accountNumber) {
        userIs.navigatingToThePayeePage();
        user.isAddingANewPayee(name,accountNumber);
    }
}
