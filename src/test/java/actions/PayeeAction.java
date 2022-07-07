package actions;

import config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.Payee;
import static org.assertj.core.api.Assertions.assertThat;

public class PayeeAction {

    Payee payee = new Payee();
    Configuration config = new Configuration();
    public static String PAYEE_NAME = "";
    private static Logger Log = LogManager.getLogger(PayeeAction.class.getName());

    public void isAddingANewPayee(String name) {
        PAYEE_NAME = name;
        payee.clickOnAddANewPayee();
        payee.setPayeeName(PAYEE_NAME);
    }

    public void enteringTheBankingDetails(String accountNumber) {
        payee.setBankCode(config.getCustomProperty("BANK_CODE"));
        payee.setBranchCode(config.getCustomProperty("BRANCH_CODE"));
        payee.setAccountNumber(accountNumber);
        payee.setSuffixDetails(config.getCustomProperty("SUFFIX_DETAILS"));
        payee.addPayeeToList();
    }

    public void payeeSuccessfulMessage() {
        assertThat(payee.getPayeeAddConfirmationMsg()).isEqualTo(config.getCustomProperty("PAYEE_ADD_MSG"));
        Log.info("Step Passed: Confirmation message is displayed"+ payee.getPayeeAddConfirmationMsg());

    }

    public void newPayeeIsPresentInTheList() {
        assertThat(payee.validateNewPayeeInThePayeeList(PAYEE_NAME)).isTrue();
        Log.info("Step Passed: "+PAYEE_NAME+ " is present in the list");
    }

    public void validatingThePayeeFieldError() {
        assertThat(payee.validatePayeeNameError()).isEqualTo(config.getCustomProperty("PAYEE_NAME_MANDATORY_ERRMSG"));
        Log.info("Step Passed: Mandatory Field is showing errors");
    }

    public void addingAnEmptyPayee() {
        payee.setEmptyPayee();
    }

    public void errorIsNoLongerPresent() {
        assertThat(payee.isErrorDisplayed()).isFalse();
        Log.info("Step Passed: Error message is no longer present");
    }

    public void setPayeeName() {
        payee.setPayeeName("test");
    }

    public void payeeListIsInAscendingOrder() {
        assertThat(payee.isPayeeListIsInAscendingOrder()).isTrue();
        Log.info("Step Passed: Payee list is Ascending order");
    }

    public void clicksOnNameHeader() {
        payee.clickOnNameHeader();
    }

    public void payeeListIsInDescendingOrder() {
        assertThat(payee.isPayeeListIsInDescendingOrder()).isTrue();
        Log.info("Step Passed: Payee list is Descending order");
    }

    public void payeePageLoadedSuccessfully() {
        assertThat(payee.isPayeePageLoaded()).isEqualTo(config.getCustomProperty("PAYEE_PAGE_URL"));
        Log.info("Step Passed: Payee page loaded successfully");
    }
}
