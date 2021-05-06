package com.colvin.PageObjects;


import com.colvin.Driver.DriverFactory;
import com.colvin.PageSteps.HomepageSteps;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ProductObjects {

    @FindBy(xpath = "//*[@class='product-data']")
    WebElement productOptions;

    @FindBy(xpath = "//*[@class='product-galleries']")
    WebElement productPhotos;

    @FindBy(xpath = "//form[@id='deliveryPromiseForm']")
    WebElement productDP;
    
    @FindBy(xpath = "//div[@class='product-addon']/ul[contains(@class, 'js-addons-main')]")
    WebElement addonMain;

    @FindBy(xpath = "//div[@class='product-addon']/ul[contains(@class, 'js-addons-secondary')]")
    WebElement addonSecondary;

    @FindBys({
            @FindBy(xpath = "//a/span[contains(text(), 'Blumensträuße')] | //a/span[text()='Bouquet']")
    })
    WebElement collectionTab;

    @FindBy(xpath = "//*[@name='shippingAddress']")
    WebElement addressField;

    @FindBy(xpath = "//*[@name='deliveryDate']")
    WebElement dataPicker;

    @FindBy(xpath = "//*/div[@class='alert-delivery-promise alert alert--warning']")
    WebElement WarningDP;

    @FindBy(xpath = "//*/div[@class='alert-delivery-promise alert alert--success']")
    WebElement SuccessDP;

    public ProductObjects(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

}

