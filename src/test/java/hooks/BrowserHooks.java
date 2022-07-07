package hooks;

import base.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

public class BrowserHooks extends BaseDriver {

    @Before()
    public void init(Scenario scenario) throws MalformedURLException {
        if(scenario.getName().contains("BNZ")){
            creatingTheSession();
        }
    }

    @After()
    public void teardown(Scenario scenario){
        if(scenario.getName().contains("BNZ")){
            driver.quit();
        }
    }
}
