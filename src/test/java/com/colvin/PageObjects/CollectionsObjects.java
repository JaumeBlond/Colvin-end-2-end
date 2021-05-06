package com.colvin.PageObjects;

import com.colvin.Driver.DriverFactory;

import java.util.List;
import java.util.Random;

import com.colvin.PageSteps.ProductPageSteps;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

@Getter
public class CollectionsObjects {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='product-list-discount-label']")
    WebElement discountLabel;

    @FindBys({
            @FindBy(xpath = "//a/p[text()='Blumensträuße'] | //a/p[text()='Bouquet']")
    })
    WebElement collectionTab;

    @FindBy(xpath = "//form[@id='deliveryPromiseForm']")
    WebElement DPSection;

    @FindBy(xpath = "//ul[@class='product-list']/li[1]")
    WebElement firstProduct;

    @FindBy(xpath = "//*[@name='shippingAddress']")
    WebElement addressField;

    @FindBy(xpath = "//*[@name='deliveryDate']")
    WebElement dataPicker;

    @FindBy(xpath = "//*/div[@class='alert-delivery-promise alert alert--warning']")
    WebElement WarningDP;

    @FindBy(xpath = "//*/div[@class='alert-delivery-promise alert alert--success']")
    WebElement SuccessDP;


    public CollectionsObjects(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
        this.driver = DriverFactory.getDriver();
    }

    public WebElement getProduct(){
        Random rand = new Random();
        List<WebElement> forms = driver.findElements(By.xpath("//ul[@class='product-list']/li"));
        int count = forms.size()-1;
        int random_prod= rand.nextInt(count)+1;
        return driver.findElement(By.xpath("//ul[@class='product-list']/li["+random_prod+"]"));
    }


    public List<WebElement> getAllProducts() {
        return driver.findElements(By.xpath("//ul[@class='product-list']/li/a"));
    }
}
