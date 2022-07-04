package pages;

import base.BaseDriver;
import config.Configuration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class Payee extends BaseDriver {

    Configuration configuration = new Configuration();

    public Payee() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@class,'SearchInput')]")
    private WebElement payeeSearch;
    @FindBy(xpath = "//button[contains(@class,'add-payee')]")
    private WebElement addPayeeBtn;
    @FindBy(id = "ComboboxInput-apm-name")
    private WebElement payeeName;
    @FindBy(css = "[data-cb-type='new-payee']")
    private WebElement payeeNameHover;
    @FindBy(id = "apm-bank")
    private WebElement bankCode;
    @FindBy(id = "apm-branch")
    private WebElement branceCode;
    @FindBy(id = "apm-account")
    private WebElement accountNumber;
    @FindBy(id = "apm-suffix")
    private WebElement suffixDetails;
    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addToPayeeList;
    @FindBy(xpath = "//span[text()='Payee added']")
    private WebElement payeeAddSuccessfulText;

    public void validatePayeeNameError() {
        assertThat(payeeName.getAttribute("aria-label")).isEqualTo(configuration.getCustomProperty("PAYEE_NAME_MANDATORY_ERRMSG"));
    }

    public void clickOnAddANewPayee() {
        wait.until(ExpectedConditions.elementToBeClickable(addPayeeBtn)).click();
    }

    public void setPayeeName(String payeeName) {
        this.payeeName.sendKeys(payeeName);
        wait.until(ExpectedConditions.elementToBeClickable(payeeNameHover)).click();
    }

    public void setBankCode(String bankCode) {
        this.bankCode.sendKeys(bankCode);
    }

    public void setBranchCode(String branchCode) {
        this.branceCode.sendKeys(branchCode);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.sendKeys(accountNumber);
    }

    public void setSuffixDetails(String suffixDetails) {
        this.suffixDetails.sendKeys(suffixDetails);
    }

    public void addPayeeToList() {
        wait.until(ExpectedConditions.elementToBeClickable(addToPayeeList)).click();
    }

    public String getPayeeAddConfirmationMsg(){
        return payeeAddSuccessfulText.getText();
    }

}
