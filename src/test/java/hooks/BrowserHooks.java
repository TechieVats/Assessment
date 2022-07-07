package hooks;

import base.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;

public class BrowserHooks extends BaseDriver {
    private static Logger Log = LogManager.getLogger(BrowserHooks.class.getName());
    @Before()
    public void init(Scenario scenario) throws MalformedURLException {
        if(scenario.getName().contains("BNZ")){
            Log.info("Scenario: "+scenario.getName()+" is started");
            creatingTheSession();
        }
    }

    @After()
    public void teardown(Scenario scenario){
        if(scenario.getName().contains("BNZ")){
            Log.info("Scenario: "+scenario.getName()+" is completed");
            driver.quit();
        }
    }
}
