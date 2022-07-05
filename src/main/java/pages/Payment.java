package pages;

import base.BaseDriver;
import config.Configuration;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Payment extends BaseDriver {
    Configuration config = new Configuration();

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
        fromAccountSearch.sendKeys(config.getCustomProperty("ACCOUNT_TYPE"));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(fromAccountEveryday)).click();
        } catch (ElementClickInterceptedException e) {
            fromAccountEveryday.click();
        }
    }

    public void selectToBillsAccount() {
        toAccountOptions.click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(toAccountTab)).click();
        } catch (ElementClickInterceptedException e) {
            toAccountTab.click();
        }
        toAccountBills.click();
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
    }

    public void transferTheMoney() {
        transferBtn.click();
    }

    public String getSuccessfulTransferAlert() {
        wait.until(ExpectedConditions.textToBePresentInElement(successfulMsg, config.getCustomProperty("PAYMENT_SUCCESSFUL")));
        return successfulMsg.getText();
    }


}
