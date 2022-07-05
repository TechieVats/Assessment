package actions;

import base.BaseDriver;
import pages.Client;

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
