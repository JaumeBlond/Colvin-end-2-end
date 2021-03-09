package com.colvin.PageSteps;

import com.colvin.Actions.Actions;
import com.colvin.Driver.DriverFactory;
import com.colvin.Hooks.Hook;
import com.colvin.PageObjects.PersonalPageObjects;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Wait;
import com.colvin.PageObjects.HomepageObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import javax.swing.text.AbstractDocument;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Test
public class HomepageSteps {
    private HomepageObjects elems;
    private PersonalPageObjects personalObj;
    private Actions actions;
    public Wait wait;
    public WebDriver driver;

    @Given("Setup the browser")
    public void launchBrowser(){
        this.driver = DriverFactory.getDriver();
        elems = new HomepageObjects();
        personalObj = new PersonalPageObjects();
        actions = new Actions();
    }

    @Given("Hit {string} on your browser")
    public void getWebsite(String url){
        driver.get("https://"+url);
    }

    @Then("a user log-in using valid credentials")
    public void userDoLogin(){
        actions.waitForElementToLoad(elems.getPopupNotification());
        elems.getPopupNotification().click();
        elems.getUserButton().click();
        try {
            elems.getLoginSwitch().click();
            elems.getEmailInput().sendKeys(HomepageObjects.USER_EMAIL);
            elems.getPasswordInput().sendKeys(HomepageObjects.USER_PASSWORD);
            elems.getLoginButton().click();
        } catch (Exception e){
            System.out.println("Derived to the old login");
            elems.getOldEmailInput().sendKeys(HomepageObjects.USER_EMAIL);
            elems.getOldPasswordInput().sendKeys(HomepageObjects.USER_PASSWORD);
            elems.getOldLoginButton().click();
        }
        elems.getAcnkowledgeButton().click();
        assertThat("I did accessed to my personal account", personalObj.getPersonalMenu().isDisplayed(), is(true));
    }

    @And("Accept the cookies")
    public void acceptTheCookies() {
        actions.waitForPageToLoad(2);
        elems.getCookiesAccept().click();
    }


    @Then("the login page is shown")
    public void theLoginPageIsShown() {
        try {
            assertThat(elems.getLoginSwitch().isDisplayed(),is(true));
        } catch (Exception e){
            try{
                System.out.println("Derived to the old login");
                assertThat(elems.getOldEmailInput().isDisplayed(),is(true));
            } catch (Exception e2) {
                assertThat("Not on login page at all", is(false), is(true));
            }
        }

    }

    @And("I click on personalpage")
    public void clickOnPersonalpage() {
        elems.getUserButton().click();
    }

    @Then("I get to homepage")
    public void iGetToHomepage() {
        actions.waitForElementToLoad(elems.getPopupNotification());
        assertThat("Not redirected",elems.getPopupNotification().isDisplayed(),is(true));
        elems.getPopupNotification().click();
    }
}
