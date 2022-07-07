package pages;

import base.BaseDriver;
import config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Payment extends BaseDriver {
    Configuration config = new Configuration();
    private static Logger Log = LogManager.getLogger(Payment.class.getName());

    public Payment() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-testid='from-account-chooser']")
    private WebElement fromAccount;
    @FindBy(css = "[data-monitoring-label='Transfer Form Search']")
    private WebElement fromAccountSearch;
    @FindBy(css = "[data-testid='to-account-chooser']")
    private WebElement toAccountOptions;
    @FindBy(css = "[data-testid='to-account-accounts-tab']")
    private WebElement toAccountTab;
    @FindBy(xpath = "//div[@data-testid='to-accounts-list-results']//p[text()='Bills ']")
    private WebElement toAccountBills;
    @FindBy(css = "[alt='Everyday']")
    private WebElement fromAccountEveryday;
    @FindBy(name = "amount")
    private WebElement amount;
    @FindBy(xpath = "//button[@data-testid='from-account-chooser']//p[contains(@class,'balance')]")
    private WebElement accountBalance_From;
    @FindBy(xpath = "//button[@data-testid='to-account-chooser']//p[contains(@class,'balance')]")
    private WebElement accountBalance_to;
    @FindBy(css = "[data-monitoring-label='Transfer Form Submit']")
    private WebElement transferBtn;
    @FindBy(css = "[class='message']")
    private WebElement successfulMsg;

    public void selectFromEveryDayAccount() {
        fromAccount.click();
        Log.info("user click on from account option");
        fromAccountSearch.sendKeys(config.getCustomProperty("ACCOUNT_TYPE"));
        Log.info("user searching the account");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(fromAccountEveryday)).click();
            Log.info("user clicks on from everyday account");
        } catch (ElementClickInterceptedException e) {
            fromAccountEveryday.click();
            Log.info("user clicks on from everyday account");
        }
    }

    public void selectToBillsAccount() {
        toAccountOptions.click();
        Log.info("user clicks on account options");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(toAccountTab)).click();
            Log.info("user clicks on account tab");
        } catch (ElementClickInterceptedException e) {
            toAccountTab.click();
            Log.info("user clicks on account tab");
        }
        toAccountBills.click();
        Log.info("user selects on to account bill");
    }

    public Double fromAccountBalance() {
        String fromAmount = accountBalance_From.getText().replace(",", "").replace(" Avl.", "");
        return Double.valueOf(fromAmount.substring(1));
    }

    public Double ToAccountBalance() {
        String toAmount = accountBalance_to.getText().replace(",", "").replace(" Avl.", "");
        return Double.valueOf(toAmount.substring(1));
    }

    public void setTransferAmount(String amount) {
        this.amount.sendKeys(amount);
        Log.info("user entered the amount: " + amount);
    }

    public void transferTheMoney() {
        transferBtn.click();
        Log.info("user clicks on transfer button");
    }

    public String getSuccessfulTransferAlert() {
        wait.until(ExpectedConditions.textToBePresentInElement(successfulMsg, config.getCustomProperty("PAYMENT_SUCCESSFUL")));
        return successfulMsg.getText();
    }


}
