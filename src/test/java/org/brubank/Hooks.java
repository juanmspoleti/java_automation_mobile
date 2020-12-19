package org.brubank;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.brubank.core.DriverService;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void beforeScenario() throws MalformedURLException {
        DriverService.createDriver();
    }

    @After
    public void afterScenario(){
        DriverService.dismissDriver();
    }
}
