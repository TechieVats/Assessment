package actions;

import config.Configuration;
import org.assertj.core.api.Assertions;
import pages.Payment;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;

public class PaymentAction {

    Payment payment = new Payment();
    Configuration config = new Configuration();
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
        System.out.println("From Amount "+FROM_ACCOUNT_BALANCE );
        System.out.println("To Amount "+ TO_ACCOUNT_BALANCE);
    }

    public void validatingSuccessfulTransferMsg(){
        System.out.println("alert message: "+payment.getSuccessfulTransferAlert());
        assertThat(payment.getSuccessfulTransferAlert()).isEqualTo(config.getCustomProperty("PAYMENT_SUCCESSFUL"));
    }

    public void validatingTheBalanceAfterTransaction() {
        payment.selectFromEveryDayAccount();
        payment.selectToBillsAccount();
        AFTER_TRANSFER_FROM_ACCOUNT_BALANCE = payment.fromAccountBalance();
        AFTER_TRANSFER_TO_ACCOUNT_BALANCE = payment.ToAccountBalance();
        assertThat(AFTER_TRANSFER_FROM_ACCOUNT_BALANCE).isEqualTo(FROM_ACCOUNT_BALANCE-TRANSFER_AMOUNT);
        assertThat(AFTER_TRANSFER_TO_ACCOUNT_BALANCE).isEqualTo(TO_ACCOUNT_BALANCE+TRANSFER_AMOUNT);
    }
}
