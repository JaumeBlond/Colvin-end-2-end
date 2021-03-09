package com.colvin.Actions;

import com.colvin.Driver.DriverFactory;
import com.colvin.PageSteps.HomepageSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Actions extends HomepageSteps {


    public Actions() {
        this.driver = DriverFactory.getDriver();
    }

    public void waitForPageToLoad(int time) {
        this.setImplicitWait(time);
    }

    public void waitForElementToLoad(WebElement element) {
        wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void setImplicitWait(int secondsToWait) {
        this.driver.manage().timeouts().implicitlyWait(secondsToWait, TimeUnit.SECONDS);
    }
}
