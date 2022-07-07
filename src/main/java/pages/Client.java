package pages;

import base.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Client extends BaseDriver {

    private static Logger Log = LogManager.getLogger(Client.class.getName());
    public Client(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(@class,'MenuButton')]")
    private WebElement menuButton;

    @FindBy(css = "[href='/client/payees']")
    private WebElement menuPayee;

    @FindBy(xpath = "//li[contains(@class,'paytransfer')]")
    private WebElement paymentTransfer;

    public void clickOnMenuTab(){
        menuButton.click();
        Log.info("User clicks on Menu tab");
    }

    public void selectPayeeOption(){
        menuPayee.click();
        Log.info("User clicks on Payee option");
    }

    public void SelectPaymentTransfer(){
        paymentTransfer.click();
        Log.info("User clicks on PaymentTransfer option");
    }

}
