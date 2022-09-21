package ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iOSSwipe extends IOSIBuiltBaseTest {

    @Test
    public void iOSSwipeTest() throws InterruptedException {

        Map<String,String> params = new HashMap<String,String>();

        params.put("bundleId","com.apple.mobileslideshow");

        driver.executeScript("mobile:launchApp",params);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
        List<WebElement> allphotos =driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(allphotos.size());
        driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
        Map<String,Object> params1 =new HashMap<String,Object>();
        params1.put("direction","left");

        for(int i=0;i< allphotos.size();i++)
        {
            System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
            driver.executeScript("mobile:swipe",params1);
        }
        driver.navigate().back();
       // driver.executeScript("mobile:swipe",params1);
        driver.findElement(AppiumBy.accessibilityId("Albums")).click();

        


    }

}
