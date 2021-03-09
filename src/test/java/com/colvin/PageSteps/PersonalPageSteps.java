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
    }

    @Then("a new reminder is added")
    public void aNewReminderIsAdded() {
        assertThat("A new reminder has been added", elements.getReminderAdded().isDisplayed(),is(true));
    }

    @When("I click on sign off")
    public void iClickOnSignOff() {

    }

    @Then("when i click again the information is updated")
    public void whenIClickAgainTheInformationIsUpdated() {

    }

    @And("click the save button")
    public void clickTheSaveButton() {

    }

    @And("fill the contact fields")
    public void fillTheContactFields() {

    }

    @And("click on modify")
    public void clickOnModify() {


    }

    @And("click on {string} badge")
    public void clickOnTwitterBadge() {

    }

    @Then("the RRSS is opened")
    public void theRRSSIsOpened() {
    }

    @And("click the use button")
    public void clickTheUseButton() {
    }

    @And("i click delete")
    public void iClickDelete() {
        
    }

    @Then("the reminder is deleted")
    public void theReminderIsDeleted() {
    }
}
