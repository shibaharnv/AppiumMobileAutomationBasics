package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DirectAppPage extends BaseTest {


@Test
public void CopyClipBoardTest() throws MalformedURLException {

    //In order to open the app page directly use Activity class and create an object with
    //parameters App package & App activity
    //In emulator navigate to the required page and run the below command in mac
    //{For Mac/Linux:
    //
    //adb shell dumpsys window | grep -E 'mCurrentFocus'
    //For Windows:
    //
    //adb shell dumpsys window | find "mCurrentFocus"}
    Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
    driver.startActivity(activity);
//    driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//    driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
    driver.findElement(By.id("android:id/checkbox")).click();
    DeviceRotation landscape = new DeviceRotation(0,0,90);
    driver.rotate(landscape);
    driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
    String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
    Assert.assertEquals(alertTitle,"WiFi settings");


    driver.setClipboardText("Shibaharwifi");
    driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
    driver.pressKey(new KeyEvent(AndroidKey.ENTER));
   driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

   driver.pressKey(new KeyEvent(AndroidKey.BACK));
    driver.pressKey(new KeyEvent(AndroidKey.HOME));





}


}
