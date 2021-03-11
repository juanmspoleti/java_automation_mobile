package org.brubank.core;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class DriverService {

    private static AppiumDriver driver;

    public static void createDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //TODO: para implementar con ios, deberiamos crear un archivo config.properties y 2 perfiles en el pom (ios y android) para indicar que se va a ejecutar, luego usar esas properties en las capabilities dependiendo la plataforma
        String appPath = Paths.get("BruContacts.apk").toFile().getAbsolutePath();
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("app", "bs://2bb943b2d30d587cc1cb57d47c69294b3b78f63a");
        capabilities.setCapability("browserstack.user", "juanspoleti1");
        capabilities.setCapability("browserstack.key", "CSSfGLerGDEzVX4PsGYL");

        driver = new AppiumDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
    }

    public static void dismissDriver() {
        driver.closeApp();
        driver.quit();
    }

    public static AppiumDriver getDriver(){
        return driver;
    }
}
