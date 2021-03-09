package com.colvin.PageObjects;

import com.colvin.Driver.DriverFactory;
import com.colvin.PageSteps.HomepageSteps;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomepageObjects extends HomepageSteps {

    public static final String USER_EMAIL = "jaume.ros.97@gmail.com";
    public static final String USER_PASSWORD = "ColvinTest1";


    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement cookiesAccept;

    @FindBy(xpath = "//a[text()='Mi cuenta']")
    WebElement UserButton;

    @FindBy(xpath = "//*[@href='javascript:void(0)']")
    WebElement loginSwitch;

    @FindBy(xpath = "//*[@data-functional-id='emailInput']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@data-functional-id='passwordInput']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@class='loginButton  sc-ifAKCX lpryiD']")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id='username']")
    WebElement oldEmailInput;

    @FindBy(xpath = "//*[@id='password']")
    WebElement oldPasswordInput;

    @FindBy(xpath = "//*[@id='header']/div/h1/a/svg[@class='colvin']")
    WebElement title;

    @FindBy(xpath = "//*[@class='cta cta--green bh-submit-button']")
    WebElement oldLoginButton;

    @FindBy(xpath = "//*[@class='cta--inline cta--green js-close-modal']")
    WebElement acnkowledgeButton;

    public HomepageObjects(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
}

