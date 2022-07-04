package pages;

import base.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Client extends BaseDriver {

    public Client(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(@class,'MenuButton')]")
    private WebElement menuButton;

    @FindBy(css = "[href='/client/payees']")
    private WebElement menuPayee;

    public void clickOnMenuTab(){
        menuButton.click();
    }

    public void selectPayeeOption(){
        menuPayee.click();
    }

}