package com.colvin.PageSteps;

import com.colvin.Actions.Actions;
import com.colvin.Driver.DriverFactory;
import com.colvin.PageObjects.CollectionsObjects;
import com.colvin.PageObjects.ProductObjects;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductPageSteps {
    private  WebDriver driver;
    private Actions actions;
    Logger log = Logger.getLogger("INFO");
    ProductObjects elements;

    public ProductPageSteps(){
        this.driver = DriverFactory.getDriver();
        elements = new ProductObjects();
        actions = new Actions();
    }


    @Then("The product page loads")
    public void theProductPageLoads() {
        actions.waitForPageToLoad(2);
        assertThat("The options are not displayed", !elements.getProductOptions().isDisplayed(), is(false));
        assertThat("The gallery is not displayed", !elements.getProductPhotos().isDisplayed(), is(false));
        try {
            assertThat("The DP is not shown", !elements.getProductDP().isDisplayed(), is(false));
        }catch (Exception e){
            log.info("This product seems to be a plant, check it");
        }

        try {
            actions.waitForElementToLoad(elements.getAddonMain());
            assertThat("The addons is not loaded", !elements.getAddonMain().isDisplayed(), is(false));
        }catch (Exception e){
            log.info("This product it's a pack, it won't have jars");
        }

        try {
            actions.waitForElementToLoad(elements.getAddonSecondary());
            assertThat("The addons is not loaded", elements.getAddonSecondary().isDisplayed(), is(true));
        }catch (Exception e){
            log.info("This product seems to have missing the secondary addon, check if it should");
        }
    }

    @When("I enter a valid {string} and date for the product")
    public void iEnterAValidPCAndDate(String CP) {
        try {
            String date = actions.dateWithOffset(4);
            elements.getAddressField().sendKeys(CP);
            elements.getAddressField().sendKeys(Keys.ENTER);
            elements.getDataPicker().click();
            elements.getDataPicker().sendKeys(date);
            elements.getDataPicker().sendKeys(Keys.ENTER);
        }catch (Exception e){
            log.info("This product seems to be a plant, check it");
        }
    }

}
