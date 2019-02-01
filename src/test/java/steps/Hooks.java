package steps;

import cucumber.api.java.After;
import driver.DriverFactory;

public class Hooks {
    @After
    public void driverTearDown (){
        DriverFactory.tearDown();
    }
}
