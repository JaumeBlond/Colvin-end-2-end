package com.colvin.PageObjects;

import com.colvin.Driver.DriverFactory;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

@Getter
public class PersonalPageObjects {

    @FindBy(xpath = "//*[@class='user-profile-menu']")
    WebElement personalMenu;

    @FindBy(xpath = "//*[@class='user-profile-menu']/ul/li[2]")
    WebElement reminders;

    @FindBy(xpath = "//*[@class='user-profile-menu']/ul/li[3]")
    WebElement purchases;

    @FindBy(xpath = "//*[@class='user-profile-menu']/ul/li[6]")
    WebElement subscriptions;

    @FindBy(xpath = "//*[@class='user-profile-menu']/ul/li[4]")
    WebElement discounts;

    @FindBy(xpath = "//*[@class='user-profile-menu']/ul/li[5]")
    WebElement personalInfo;

    @FindBy(xpath = "//*[@class='cta--green cta--inline']")
    WebElement addReminder;

    @FindBy(xpath = "//*[@class='bh-button-modify-special-date links']")
    WebElement modifyReminder;

    @FindBy(xpath ="//*[@id='customer_special_date_name']")
    WebElement reminderNameInput;

    @FindBy(xpath ="//*[@id='customer_special_date_lastName']")
    WebElement reminderSurameInput;

    @FindBy(xpath = "//*[@id='customer_special_date_relation']/option[12]")
    WebElement reminderTypeInput;

    @FindBy(xpath = "//*[@id='customer_special_date_occasion']/option[6]")
    WebElement reminderOcasionInput;

    @FindBy(xpath = "//*[@id='customer_special_date_datePicker']")
    WebElement clickDates;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[5]")
    WebElement chooseDate;

    @FindBys(
            @FindBy(xpath = "//*[@class='cta cta--green bh-submit-button']")
    )
    WebElement submitButton;

    @FindBy(xpath = "//b[text() = 'Test Colvin']")
    WebElement reminderAdded;

    public PersonalPageObjects(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
}
