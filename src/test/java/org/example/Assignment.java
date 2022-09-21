package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Assignment extends BaseTest {

    //{Click on APP
    // Click on Alert dialogs and click on cancel
    // Click on }

    @Test
    public void assignmentTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Alert Dialogs']")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button2")).click();
        driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
        driver.findElement(By.xpath("(//android.widget.CheckedTextView)[2]")).click();
        driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();

    }
}
