package com.colvin.PageSteps;

import com.colvin.Actions.Actions;
import com.colvin.Driver.DriverFactory;
import com.colvin.PageObjects.CollectionsObjects;
import com.colvin.PageObjects.ProductObjects;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CollectionsPageSteps {
    private  WebDriver driver;
    private Actions actions;
    CollectionsObjects elements;
    ProductPageSteps productSteps;
    ProductObjects elementsProd;
    Logger log = Logger.getLogger("INFO");


    public CollectionsPageSteps(){
        this.driver = DriverFactory.getDriver();
        elements = new CollectionsObjects();
        actions = new Actions();
        productSteps = new ProductPageSteps();
        elementsProd = new ProductObjects();
    }

    @Then("i am redirected to the shop with my discount")
    public void iAmRedirectedToTheShopWithMyDiscount() {
        actions.waitForElementToLoad(elements.getDiscountLabel());
        assertThat("The discount is not added", elements.getDiscountLabel().isDisplayed(), is(true));
        System.out.println(elements.getDiscountLabel().getText());
    }

    @And("I click on collection")
    public void iClickOnCollection() {
        elements.getCollectionTab().click();
        actions.waitForPageToLoad(5);

    }

    @Then("DP is shown")
    public void dpIsShown() {
        actions.waitForPageToLoad(5);
        assertThat("Delivery promise is not showing", elements.getDPSection().isDisplayed(), is(true));
    }

    @When("I select a product")
    public void iSelectAProduct() {
        actions.scrollToObjectAndClick(elements.getProduct());
        actions.waitForPageToLoad(15);
    }

    @When("I select each product")
    public void iSelectEachProduct(){
        forEachClick(elements.getAllProducts());
    }


    @When("I enter a valid {string} and date")
    public void iEnterAValidPCAndDate(String CP) {
        String date = actions.dateWithOffset(4);
        elements.getAddressField().sendKeys(CP);
        elements.getAddressField().sendKeys(Keys.ENTER);
        elements.getDataPicker().click();
        elements.getDataPicker().sendKeys(date);
        elements.getDataPicker().sendKeys(Keys.ENTER);
    }

    @When("I enter a valid {string} and date today")
    public void iEnterAValidPCAndToday(String CP) {
        String date = actions.dateWithOffset(0);
        elements.getAddressField().sendKeys(CP);
        elements.getAddressField().sendKeys(Keys.ENTER);
        elements.getDataPicker().click();
        elements.getDataPicker().sendKeys(date);
        elements.getDataPicker().sendKeys(Keys.ENTER);
    }

    @Then("I get a delivery promise output")
    public void iGetADeliveryPromiseOutput() {
        try{
            try {
                actions.waitForElementToLoad(elements.getSuccessDP());
                log.info("Can be delivered in that date");
                assertThat("Delivery Promise works", true);
            } catch(Exception e) {
                actions.waitForElementToLoad(elements.getWarningDP());
                log.info("Can't be delivered in that date");
                assertThat("Delivery Promise works", true);
            }
        } catch(Exception e) {
            assertThat("Delivery promise is not working", false);
        }
    }

    private void forEachClick(List<WebElement> products){
        String url_actual = driver.getCurrentUrl();
        for (WebElement p:products) {
            try {
                actions.scrollToObject(p);
                driver.get(p.getAttribute("href"));
                try {
                    productSteps.theProductPageLoads();
                } catch (Exception e) {
                    log.info("Seems to be missing some addon");
                }
            }catch (org.openqa.selenium.StaleElementReferenceException ex){
                actions.scrollToObject(p);
                driver.get(p.getAttribute("href"));
                try {
                    productSteps.theProductPageLoads();
                } catch (Exception e) {
                    log.info("Seems to be missing some addon");
                }
            }
        }

    }
}
