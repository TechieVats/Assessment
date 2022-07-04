package actions;

import config.Configuration;
import pages.Payee;

public class PayeeAction {

    Payee payee = new Payee();
    Configuration config = new Configuration();

    public void isAddingANewPayee(String name, String accountNumber) {
        payee.clickOnAddANewPayee();
        payee.setPayeeName(name);
        payee.setBankCode(config.getCustomProperty("BANK_CODE"));
        payee.setBranchCode(config.getCustomProperty("BRANCH_CODE"));
        payee.setAccountNumber(accountNumber);
        payee.setSuffixDetails(config.getCustomProperty("SUFFIX_DETAILS"));
        payee.addPayeeToList();
    }

    public void payeeSuccefulMessage(){

        System.out.println("Alert message: "+payee.getPayeeAddConfirmationMsg());
    }
}
