package pages;

import base.BaseDriver;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Payee extends BaseDriver {

    List<String> list = new ArrayList<>();

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
    @FindBy(xpath = "//ul[contains(@aria-label,'payee found')]")
    private WebElement payeeSearchResult;
    @FindBy(xpath = "//p[contains(@class,'tooltip')]")
    private WebElement payeeNameError;
    @FindBy(xpath = "//h3[contains(@aria-label,'Sort by payee name')]")
    private WebElement nameHeader;
    @FindBy(css = "[class='js-payee-name']")
    private List<WebElement> payeeList;

    public String validatePayeeNameError() {
        return payeeNameError.getText();
    }

    public void clickOnAddANewPayee() {
        wait.until(ExpectedConditions.elementToBeClickable(addPayeeBtn)).click();
    }

    public void setPayeeName(String payeeName) {
        this.payeeName.sendKeys(payeeName);
        wait.until(ExpectedConditions.elementToBeClickable(payeeNameHover)).click();
    }

    public void setEmptyPayee() {
        try {
            addPayeeBtn.click();
        } catch (ElementClickInterceptedException e) {
            payeeName.sendKeys("");
            addToPayeeList.click();
        }
        payeeName.sendKeys("");
        addToPayeeList.click();

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

    public String getPayeeAddConfirmationMsg() {
        wait.until(ExpectedConditions.textToBePresentInElement(payeeAddSuccessfulText, "Payee added"));
        return payeeAddSuccessfulText.getText();
    }

    public boolean validateNewPayeeInThePayeeList(String payeeName) {
        wait.until(ExpectedConditions.elementToBeClickable(payeeSearch)).sendKeys(payeeName);
        return payeeSearchResult.isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return payeeNameError.isDisplayed();
    }

    public void clickOnNameHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(nameHeader)).click();
    }

    public boolean isPayeeListIsInAscendingOrder() {
        for (WebElement ele : payeeList) {
            list.add(ele.getText());
        }
        return list.stream().sorted().collect(Collectors.toList()).equals(list);
    }

    public boolean isPayeeListIsInDescendingOrder() {
        List<String> newList = new ArrayList<>();
        for (WebElement ele : payeeList) {
            newList.add(ele.getText());
        }
        Collections.reverse(list);
        return newList.equals(list);
    }

    public String isPayeePageLoaded() {
        return driver.getCurrentUrl();
    }
}
