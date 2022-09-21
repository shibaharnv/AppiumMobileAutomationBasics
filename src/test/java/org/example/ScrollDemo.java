package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollDemo extends BaseTest {


@Test
public void ScrollDemoTest() throws MalformedURLException,InterruptedException {

driver.findElement(AppiumBy.accessibilityId("Views")).click();

//Scroll using Google UI automator method to scroll till element
//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

// Scroll using co ordinates with out element - Do while is to scroll till the end

    scrollToEnd();



Thread.sleep(2000);

//// Andriod Scroll
//
//    //1. Using Java script executor-Immutable Map-RemoteWebelem
//    WebElement ele= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
//    longPressActionMethod(ele);
//
//    String menuText=driver.findElement(By.id("android:id/title")).getText();
//
//    Assert.assertEquals(menuText,"Sample menu");
//
//    Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());


}


}
