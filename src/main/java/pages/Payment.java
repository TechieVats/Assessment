package pages;

import base.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment extends BaseDriver {

    public Payment(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ComboboxInput-apm-name")
    private WebElement payeeNameError;


}
