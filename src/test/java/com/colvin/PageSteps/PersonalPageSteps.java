package com.colvin.PageSteps;

import com.colvin.Actions.Actions;
import com.colvin.Driver.DriverFactory;
import com.colvin.Hooks.Hook;
import com.colvin.PageObjects.HomepageObjects;
import com.colvin.PageObjects.PersonalPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonalPageSteps {
    private  WebDriver driver;
    private Actions actions;
    PersonalPageObjects elements;

    public PersonalPageSteps(){
        this.driver = DriverFactory.getDriver();
        elements = new PersonalPageObjects();
        actions = new Actions();
    }

    @When("i click the {string} button")
    public void clickButton(String action){
        switch (action.toUpperCase()){
            case "ADD":
                elements.getAddReminder().click();
                break;
            case "MODIFY":
                elements.getModifyReminder().click();
                break;
        }
    }

    @When("I go to {string}")
    public void iGoToMyReminders(String section) {
        switch (section.toUpperCase()){
            case "INFORMATION":
                elements.getPersonalInfo().click();
                break;
            case "REMINDERS":
                elements.getReminders().click();
                break;
            case "PURCHASES":
                elements.getPurchases().click();
                break;
            case "DISCOUNTS":
                elements.getDiscounts().click();
                break;
            case "SUBSCRIPTIONS":
                elements.getSubscriptions().click();
        }

    }

    @And("i fill the fields")
    public void iFillTheFields() {
        elements.getReminderNameInput().sendKeys("Test");
        elements.getReminderSurameInput().sendKeys("Colvin");
        elements.getReminderTypeInput().click();
        elements.getReminderOcasionInput().click();
        elements.getClickDates().click();
        elements.getChooseDate().click();
    }

    @And("click on submit")
    public void clickOnSubmit() {
        elements.getSubmitButton().click();
        elements.getReminders().click();
    }

    @Then("the reminder is {string}")
    public void aNewReminderIsAdded(String action) {
        switch (action.toUpperCase()){
            case "ADDED":
                assertThat("A new reminder hasn't been added", elements.getReminderAdded().getText().equals("Test Colvin"),is(true));
                System.out.println("A new reminder has been added");
                break;
            case "DELETED":
                assertThat("A new reminder hasn't been deleted", elements.getReminderAdded().getText().equals("Test Colvin"),is(false));
                System.out.println("A new reminder has been deleted");
                break;
        }
    }

    @When("I click on sign off")
    public void iClickOnSignOff() {
        elements.getSignOff().click();
    }

    @And("click the save button")
    public void clickTheSaveButton() {
        elements.getSubmitButton().click();
        actions.waitForElementToLoad(elements.getSaved());
        assertThat("Not saved", elements.getSaved().getText().equals("Información del perfil actualizada"), is(true));
    }

    @And("fill the contact fields")
    public void fillTheContactFields() {
        elements.getClickGeneder().click();
        elements.getSelectGender().click();
        elements.getStreet().clear();
        elements.getCity().clear();
        elements.getFloor().clear();
        elements.getPostalCode().clear();
        elements.getStreet().sendKeys(actions.generateWord());
        elements.getFloor().sendKeys(actions.generateWord());
        elements.getCity().sendKeys(actions.generateWord());
        elements.getPostalCode().sendKeys("08020");
        elements.getCountryCode().click();
    }

    @And("click on modify")
    public void clickOnModify() {
        elements.getModifyData().click();
    }

    @And("click on {string} badge")
    public void clickOnTwitterBadge(String rrss) {
        switch (rrss.toUpperCase()){
            case "WHATSAPP":
                elements.getIsWhatsapp().click();
                break;
            case "TWITTER":
                elements.getIsTwitter().click();
                break;
            case "FACEBOOK":
                elements.getIsFacebook().click();
                break;
            case "EMAIL":
                elements.getIsEmail().click();
                break;
        }
    }

    @Then("{string} is opened")
    public void theRRSSIsOpened(String rrss) {
        ArrayList<String> tabs= new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());
        assertThat("Tab Do not open",driver.getCurrentUrl().contains(rrss),is(true));
    }

    @And("click the use button")
    public void clickTheUseButton() {
        elements.getUsePromotion().click();
    }

    @And("i click delete")
    public void iClickDelete() {
        elements.getDeleteReminder().click();
    }

    @Then("the reminder is deleted")
    public void theReminderIsDeleted() {
    }

    @Then("check i don't have purchases")
    public void checkIDonTHavePurchases() {
        assertThat("I have purchased something", elements.getNoPurchases().getText().equals("No hay pedidos concluidos."), is(true));
        System.out.println("I haven't purchased something");

    }

    @And("Click on subscriptions")
    public void clickOnSuscriptions() {
        elements.getGetSubscriptions().click();
    }
}
