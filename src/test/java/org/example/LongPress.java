package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.http.HttpMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Map;

public class LongPress extends BaseTest {


@Test
public void LongPressGesture() throws MalformedURLException {

driver.findElement(AppiumBy.accessibilityId("Views")).click();
driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

// Andriod Long press can be done in two ways

    //1. Using Java script executor-Immutable Map-RemoteWebelem
    WebElement ele= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
    longPressActionMethod(ele);

    String menuText=driver.findElement(By.id("android:id/title")).getText();

    Assert.assertEquals(menuText,"Sample menu");

    Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

//
//    //2.Using Android Touch Action class
//    AndroidTouchAction t = new AndroidTouchAction(driver);
//
//    t.longPress(LongPressOptions.longPressOptions()
//                    .withElement(ElementOption.element(holdElement))
//                    .withDuration(Duration.ofMillis(5000)))
//            .release()
//            .perform();

}


}
