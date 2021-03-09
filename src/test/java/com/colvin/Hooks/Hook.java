package com.colvin.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.colvin.Driver.DriverFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Hook {
    WebDriver driver;
    @Before
    public void setup(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("detach", true);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        DriverFactory.addDriver(driver);
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        driver=DriverFactory.getDriver();
        if(scenario.isFailed()){
            takeSnapShot(driver, "target/generated-test-sources/screenshots/"+scenario.getName()+".png") ;
        }
            driver.quit();
        }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }
    public WebDriver getdriver(){
            return driver;
    }
}
