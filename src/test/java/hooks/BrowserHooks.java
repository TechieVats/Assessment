package hooks;

import base.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BrowserHooks extends BaseDriver {

    @Before()
    public void launchingTheBrowser(){
        creatingTheSession();
    }

    @After()
    public void closingTheBrowser(){
        driver.quit();
    }
}
