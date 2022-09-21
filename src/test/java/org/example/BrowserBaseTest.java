package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {

    public AppiumDriverLocalService service;
    public  AndroidDriver driver;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {


        File myfile = new File("/Users/snagarajan/.appium/node_modules/appium/build/lib/main.js");
         service = new AppiumServiceBuilder().withAppiumJS(myfile)
                .withIPAddress("172.19.190.222").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("ShibaharChrome");
        options.setChromedriverExecutable("/Users/snagarajan/Documents/chromedriver");
        options.setCapability("browserName","Chrome");
        driver = new AndroidDriver(new URL("http://172.19.190.222:4723"),options);
         //Global wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
        service.stop();
    }
}
