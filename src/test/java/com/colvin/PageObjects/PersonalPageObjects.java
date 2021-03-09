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

    @FindBy(xpath = "//*[@class='user-logout']")
    WebElement signOff;

    @FindBy(xpath = "//*[@class='bh-button-remove-special-date link mobile-hidden']")
    WebElement deleteReminder;

    @FindBy(xpath = "/html/body/main/div/div/section/div/div[3]/div/a")
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

    @FindBy(xpath = "//*[@class='info']/b")
    WebElement reminderAdded;

    @FindBy(xpath = "/html/body/main/div/div/section[3]/div/p")
    WebElement noPurchases;

    @FindBy(xpath = "//*[@class='promotion-use']")
    WebElement usePromotion;

    @FindBy(xpath ="//*[@id='gtm-referafriend-share-facebook']")
    WebElement isFacebook;

    @FindBy(xpath ="//*[@id='gtm-referafriend-share-email']")
    WebElement isEmail;

    @FindBy(xpath ="//*[@id='gtm-referafriend-share-whatsapp']")
    WebElement isWhatsapp;

    @FindBy(xpath ="//*[@class='gtm-referafriend-share-twitter']")
    WebElement isTwitter;

    @FindBy(xpath = "/html/body/main/div/div/section[2]/div/a[1]")
    WebElement modifyData;

    @FindBy(xpath = "//*[@id='settings_gender']")
    WebElement clickGeneder;

    @FindBy(xpath = "//*[@id=\"settings_gender\"]/option[2]")
    WebElement selectGender;

    @FindBy(xpath = "//*[@id='settings_address_street']")
    WebElement street;

    @FindBy(xpath = "//*[@id='settings_address_floor']")
    WebElement floor;

    @FindBy(xpath = "//*[@id='settings_address_city']")
    WebElement city;

    @FindBy(xpath = "//*[@id='settings_address_postalCode']")
    WebElement postalCode;

    @FindBy(xpath = "//*[@id='settings_address_countryCode']/option[2]")
    WebElement countryCode;

    @FindBy(xpath = "//*[@class='flash-text']")
    WebElement saved;

    @FindBy(xpath = "//*[@class='cta--inline cta--green subscribe-cta']")
    WebElement getSubscriptions;


    public PersonalPageObjects(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
}
