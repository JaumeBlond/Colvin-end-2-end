package com.colvin.Actions;

import com.colvin.Driver.DriverFactory;
import com.colvin.PageObjects.CollectionsObjects;
import com.colvin.PageSteps.HomepageSteps;
import com.colvin.PageSteps.ProductPageSteps;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Actions extends HomepageSteps {

    String strAllowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    Random random = new Random();
    Logger log = Logger.getLogger("INFO");
    ProductPageSteps checks;
    CollectionsObjects collectionsElems;



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

    @SneakyThrows
    public void scrollToObject(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    public String generateWord() {
        StringBuilder sbRandomString = new StringBuilder(12);
        for(int i = 0 ; i < 12; i++){
            int randomInt = random.nextInt(strAllowedCharacters.length());
            sbRandomString.append( strAllowedCharacters.charAt(randomInt) );
        }
        return sbRandomString.toString();
    }

    @SneakyThrows
    public void scrollToObjectAndClick(WebElement element) {
        log.info(element.getText());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        element.click();
    }

    public String dateWithOffset(int offset){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, offset);

        date = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }
}
