package ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IosLongPress extends IOSBaseTest {
    @Test
    public void IoslongPress()
    {
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        WebElement element=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Increment'`][3]"));
        iosLongPressMethod(element);


    }
}
