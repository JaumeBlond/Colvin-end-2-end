package com.colvin.PageSteps;

import com.colvin.Actions.Actions;
import com.colvin.Driver.DriverFactory;
import com.colvin.PageObjects.PersonalPageObjects;
import com.colvin.PageObjects.PurchaseFlowerObjects;
import com.colvin.PageObjects.SubscriptionPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SubscriptionPageSteps {
    private  WebDriver driver;
    private Actions actions;
    SubscriptionPageObjects elements;

    public SubscriptionPageSteps(){
        this.driver = DriverFactory.getDriver();
        elements = new SubscriptionPageObjects();
        actions = new Actions();
    }

    @Then("i am redirected to the subscription page")
    public void iAmRedirectedToTheShopWithMyDiscount() {
        actions.waitForElementToLoad(elements.getSubscriptionButton());
        assertThat("I don't get redirected", elements.getSubscriptionButton().isDisplayed(), is(true));
        System.out.println(elements.getSubscriptionButton().getText());
    }
}
