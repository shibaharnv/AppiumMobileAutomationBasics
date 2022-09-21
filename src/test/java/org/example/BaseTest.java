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

public class BaseTest {

    public AppiumDriverLocalService service;
    public  AndroidDriver driver;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {


        File myfile = new File("/Users/snagarajan/.appium/node_modules/appium/build/lib/main.js");
         service = new AppiumServiceBuilder().withAppiumJS(myfile)
                .withIPAddress("172.19.190.165").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        //options.setDeviceName("Shibahar");//emulator
        options.setDeviceName("Android Device");//real device
        options.setChromedriverExecutable("/Users/snagarajan/Documents/chromedriver");
       // options.setApp("/Users/snagarajan/IdeaProjects/Appium/src/test/resources/ApiDemos-debug.apk");
        options.setApp("/Users/snagarajan/IdeaProjects/Appium/src/test/resources/General-Store.apk");
         driver = new AndroidDriver(new URL("http://172.19.190.165:4723"),options);
         //Global wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void longPressActionMethod(WebElement ele)
    {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId()
                ,"duration",2000));
    }

    public void SwipeAction(WebElement firstImage,String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)firstImage).getId()
                ,"direction",direction,
                "percent",0.75));
    }

    public void scrollToEnd()
    {

        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(

                    "left", 100, "top", 100, "width", 200, "height", 200,

                    "direction", "down",

                    "percent", 3.0

            ));
        }while (canScrollMore);

    }

    public void DragAndDropMethod(WebElement sourceElement,int x,int y)
    {
        {    ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",((RemoteWebElement)sourceElement).getId()
                    ,"endX",x,
                    "endY",y));}
    }






    @AfterClass
    public void tearDown()
    {
        driver.quit();
        service.stop();
    }
}
