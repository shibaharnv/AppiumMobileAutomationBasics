package ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class IOSIBuiltBaseTest {

    public AppiumDriverLocalService service;
    public  IOSDriver driver;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {


        File myfile = new File("/Users/snagarajan/.appium/node_modules/appium/build/lib/main.js");
         service = new AppiumServiceBuilder().withAppiumJS(myfile)
                .withIPAddress("172.19.190.165").usingPort(4723).build();
        service.start();
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 13 Pro");
        options.setPlatformVersion("15.5");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

         driver = new IOSDriver (new URL("http://172.19.190.165:4723"),options);
         //Global wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void iosLongPressMethod(WebElement element)
    {
        Map<String,Object> params =new HashMap<>();
        params.put("element",((RemoteWebElement)element).getId());
        params.put("duration",5);
        driver.executeScript("mobile:touchAndHold",params);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
        service.stop();
    }
}
