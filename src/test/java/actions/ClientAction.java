package actions;

import base.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.Client;
import util.APIUtility;

public class ClientAction {

    Client client = new Client();
    BaseDriver baseDriver = new BaseDriver();

    public void navigateToBnzClient(){
        baseDriver.navigateToUrl();
    }

    public void navigatingToThePayeePage() {
        client.clickOnMenuTab();
        client.selectPayeeOption();
    }

    public void navigatingToPaymentTransferPage(){
        client.clickOnMenuTab();
        client.SelectPaymentTransfer();
    }
}
