package com.example.core;

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
        String appPath = Paths.get("src", "test", "resources", "app", "Contacts.apk").toFile().getAbsolutePath();
        capabilities.setCapability("deviceName", "Redmi note 8 Pro");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("app", appPath);

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public static void dismissDriver() {
        driver.closeApp();
        driver.quit();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
