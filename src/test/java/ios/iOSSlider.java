package ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class iOSSlider extends IOSBaseTest {

    @Test
    public void IosSliderTest() throws InterruptedException {
        System.out.println("Test");

        WebElement slider=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == 'AppElem'`]"));

        slider.sendKeys("0%");
        System.out.println(slider.getAttribute("value")); //0%
        Thread.sleep(2000);
        slider.sendKeys("1%");
        Thread.sleep(2000);
        System.out.println(slider.getAttribute("value")); //100%
    }

}
