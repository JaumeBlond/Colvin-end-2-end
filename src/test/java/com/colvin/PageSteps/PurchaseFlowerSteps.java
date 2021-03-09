package com.colvin.PageSteps;

import com.colvin.Actions.Actions;
import com.colvin.Driver.DriverFactory;
import com.colvin.PageObjects.PersonalPageObjects;
import com.colvin.PageObjects.PurchaseFlowerObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PurchaseFlowerSteps {
    private  WebDriver driver;
    private Actions actions;
    PurchaseFlowerObjects elements;

    public PurchaseFlowerSteps(){
        this.driver = DriverFactory.getDriver();
        elements = new PurchaseFlowerObjects();
        actions = new Actions();
    }

    @Then("i am redirected to the shop with my discount")
    public void iAmRedirectedToTheShopWithMyDiscount() {
        actions.waitForElementToLoad(elements.getDiscountLabel());
        assertThat("The discount is not added", elements.getDiscountLabel().isDisplayed(), is(true));
        System.out.println(elements.getDiscountLabel().getText());
    }
}
