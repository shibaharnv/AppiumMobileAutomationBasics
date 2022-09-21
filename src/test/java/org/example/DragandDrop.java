package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DragandDrop extends BaseTest {


@Test
public void DragandDropTest() throws MalformedURLException,InterruptedException {

driver.findElement(AppiumBy.accessibilityId("Views")).click();
driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
WebElement sourceElement =driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

//    ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",((RemoteWebElement)sourceElement).getId()
//            ,"endX",824,
//            "endY",735));
    DragAndDropMethod(sourceElement,824,735);
    String text=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
    Thread.sleep(3000);
    Assert.assertEquals(text,"Dropped!");




}


}
