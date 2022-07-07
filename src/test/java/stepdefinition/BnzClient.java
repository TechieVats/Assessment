package stepdefinition;

import actions.ClientAction;
import actions.PayeeAction;
import actions.PaymentAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BnzClient {
    ClientAction userIs = new ClientAction();
    PayeeAction user = new PayeeAction();
    PaymentAction userPay = new PaymentAction();

    @Given("user is on BNZ client page")
    public void userIsOnBnzClientPage() {
        userIs.navigateToBnzClient();
    }

    @When("the user clicks on the Menu tab and selects the Payees option")
    public void theUserClicksOnTheMenuTabAndSelectsThePayeesOption() {
        userIs.navigatingToThePayeePage();
    }

    @Then("the user is able to validate that the payee page is loaded")
    public void theUserIsAbleToValidateThatThePayeePageIsLoaded() {
        user.payeePageLoadedSuccessfully();
    }

    @Then("the user is able to see a successful message and the newly added payee in the payees list")
    public void theUserIsAbleToSeeASuccessfulMessageAndTheNewlyAddedPayeeInThePayeesList() {
            user.payeeSuccessfulMessage();
            user.newPayeeIsPresentInTheList();
    }

    @When("the user navigates to the payee page and add the payee details as {string}, {string}")
    public void theUserNavigatesToThePayeePageAndAddThePayeeDetailsAs(String name, String accountNumber) {
        userIs.navigatingToThePayeePage();
        user.isAddingANewPayee(name);
        user.enteringTheBankingDetails(accountNumber);
    }

    @When("the user clicks on the add payee button with an empty field of payee name")
    public void theUserClicksOnTheAddPayeeButtonWithAnEmptyFieldOfPayeeName() {
        user.addingAnEmptyPayee();
    }

    @Then("the user is able to see the mandatory fields error message")
    public void theUserIsAbleToSeeTheMandatoryFieldsErrorMessage() {
        user.validatingThePayeeFieldError();
    }

    @When("the user populates the mandatory payee name field")
    public void theUserPopulatesTheMandatoryPayeeNameField() {
        user.setPayeeName();
    }

    @Then("the error messages are no longer present")
    public void theErrorMessagesAreNoLongerPresent() {
        user.errorIsNoLongerPresent();
    }

    @Then("the user is able to verify the payee list in ascending order")
    public void theUserIsAbleToVerifyThePayeeListInAscendingOrder() {
        user.payeeListIsInAscendingOrder();
    }

    @When("the user clicks on the name header")
    public void theUserClicksOnTheNameHeader() {
        user.clicksOnNameHeader();
    }

    @Then("the user is able to verify that the payee list is sorted in descending order")
    public void theUserIsAbleToVerifyThatThePayeeListIsSortedInDescendingOrder() {
        user.payeeListIsInDescendingOrder();
    }

    @And("the user navigates to the payment transfer page")
    public void theUserNavigatesToThePaymentTransferPage() {
        userIs.navigatingToPaymentTransferPage();
    }

    @When("user transfer ${double} from Everyday Account to Bills Account")
    public void userTransferFromEveryDayAccountToBillsAccount(double amount) {
        userPay.isTransferringAmountFromEverydayToBills(amount);
    }

    @Then("the user is able to see a successful message and be able to verify the current balance in both accounts")
    public void theUserIsAbleToSeeASuccessfulMessageAndBeAbleToVerifyTheCurrentBalanceInBothAccounts() {
        userPay.validatingSuccessfulTransferMsg();
        userIs.navigatingToPaymentTransferPage();
        userPay.validatingTheBalanceAfterTransaction();
    }
}
