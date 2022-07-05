package actions;

import config.Configuration;
import pages.Payee;

import static org.assertj.core.api.Assertions.assertThat;

public class PayeeAction {

    Payee payee = new Payee();
    Configuration config = new Configuration();
    public static String PAYEE_NAME = "";

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
    }

    public void newPayeeIsPresentInTheList() {
        assertThat(payee.validateNewPayeeInThePayeeList(PAYEE_NAME)).isTrue();
    }

    public void validatingThePayeeFieldError() {
        assertThat(payee.validatePayeeNameError()).isEqualTo(config.getCustomProperty("PAYEE_NAME_MANDATORY_ERRMSG"));
    }

    public void addingAnEmptyPayee() {
        payee.setEmptyPayee();
    }

    public void errorIsNoLongerPresent() {
        assertThat(payee.isErrorDisplayed()).isFalse();
    }

    public void setPayeeName() {
        payee.setPayeeName("test");
    }

    public void payeeListIsInAscendingOrder() {
       assertThat(payee.isPayeeListIsInAscendingOrder()).isTrue();
    }

    public void clicksOnNameHeader() {
        payee.clickOnNameHeader();
    }

    public void payeeListIsInDescendingOrder() {
        assertThat(payee.isPayeeListIsInDescendingOrder()).isTrue();
    }

    public void payeePageLoadedSuccessfully() {
        assertThat(payee.isPayeePageLoaded()).isEqualTo(config.getCustomProperty("PAYEE_PAGE_URL"));
    }
}
