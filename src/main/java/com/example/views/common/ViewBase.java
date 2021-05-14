package com.example.views.common;

import com.example.core.DriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class ViewBase {

    public ViewBase() {

    }

    public WebElement getElement(By locator) {
        return DriverService.getDriver().findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return DriverService.getDriver().findElements(locator);
    }

    public String getText(By locator){
        WebElement element = getElement(locator);
        return getText(element);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void setInput(By locator, String value) {
        WebElement element = getElement(locator);
        element.sendKeys(value);
    }

    public void click(By locator) {
        WebElement element = getElement(locator);
        element.click();
    }

    public boolean isPresent(By locator) {
        DriverService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            getElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            DriverService.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
    }
}
