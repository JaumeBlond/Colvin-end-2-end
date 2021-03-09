package com.colvin.PageObjects;

import com.colvin.Driver.DriverFactory;
import com.colvin.PageSteps.HomepageSteps;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SubscriptionPageObjects {

    @FindBy(xpath = "//*[@class='cta--inline cta--green tm-click-subscription']")
    WebElement subscriptionButton;

    public SubscriptionPageObjects(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
}
