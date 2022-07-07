package actions;

import config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pages.Payment;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;

public class PaymentAction {

    Payment payment = new Payment();
    Configuration config = new Configuration();
    private static Logger Log = LogManager.getLogger(PaymentAction.class.getName());
    public static Double FROM_ACCOUNT_BALANCE =0.00;
    public static Double TO_ACCOUNT_BALANCE = 0.00;
    public static Double AFTER_TRANSFER_FROM_ACCOUNT_BALANCE =0.00;
    public static Double AFTER_TRANSFER_TO_ACCOUNT_BALANCE=0.00;
    public static Double TRANSFER_AMOUNT=0.00;

    public void isTransferringAmountFromEverydayToBills(double amount) {
        payment.selectFromEveryDayAccount();
        payment.selectToBillsAccount();
        FROM_ACCOUNT_BALANCE = payment.fromAccountBalance();
        TO_ACCOUNT_BALANCE = payment.ToAccountBalance();
        TRANSFER_AMOUNT=amount;
        payment.setTransferAmount(String.valueOf(TRANSFER_AMOUNT));
        payment.transferTheMoney();
    }

    public void validatingSuccessfulTransferMsg(){
        assertThat(payment.getSuccessfulTransferAlert()).isEqualTo(config.getCustomProperty("PAYMENT_SUCCESSFUL"));
        Log.info("Step Passed: Alert present: "+ payment.getSuccessfulTransferAlert());
    }

    public void validatingTheBalanceAfterTransaction() {
        payment.selectFromEveryDayAccount();
        payment.selectToBillsAccount();
        AFTER_TRANSFER_FROM_ACCOUNT_BALANCE = payment.fromAccountBalance();
        AFTER_TRANSFER_TO_ACCOUNT_BALANCE = payment.ToAccountBalance();
        assertThat(AFTER_TRANSFER_FROM_ACCOUNT_BALANCE).isEqualTo(FROM_ACCOUNT_BALANCE-TRANSFER_AMOUNT);
        Log.info("Step Passed: Assertion Successful: Amount debited correctly");
        assertThat(AFTER_TRANSFER_TO_ACCOUNT_BALANCE).isEqualTo(TO_ACCOUNT_BALANCE+TRANSFER_AMOUNT);
        Log.info("Step Passed: Assertion Successful: Amount credited correctly");
    }
}
