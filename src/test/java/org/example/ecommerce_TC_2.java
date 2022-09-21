package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class ecommerce_TC_2 extends BaseTest{

    //Scrolling to a element find out the unique element if there are many elements

    @Test
    public void fillform() throws InterruptedException {
        
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shibahar");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

        int size=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i =0;i<size;i++)
        {
            String product_Name=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if(product_Name.equalsIgnoreCase("Jordan 6 Rings"))
            {
                    driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }


        // second add to cart


        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));


        int size2=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i =0;i<size2;i++)
        {
            String product_Name=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if(product_Name.equalsIgnoreCase("Jordan Lift Off"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }



        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(2000);

        //String firstPrice=driver.findElements(AppiumBy.className("android.widget.TextView")).get(0).getText();
        String firstPrice=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
        String secondPrice=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
        //String secondPrice=driver.findElements(AppiumBy.className("android.widget.TextView")).get(1).getText();
//com.androidsample.generalstore:id/productPrice
        System.out.println(firstPrice);
        System.out.println(secondPrice);
        //String firstPriceOnlyNumber="";

        Double firstPriceDouble =Double.parseDouble(firstPrice.substring(1));
        Double secondPriceDouble =Double.parseDouble(secondPrice.substring(1));

        System.out.println(firstPriceDouble.getClass().getName());

        Double totalPrice =firstPriceDouble+secondPriceDouble;

        System.out.println("total price "+totalPrice);
        System.out.println(totalPrice.getClass().getName());

        //driver.findElement(By.id("com.androidsample.generalstore:id/productPrice[1]"))
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")) ,"text","Cart" ));
//
//        String text=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//
//        Assert.assertEquals(text,"Jordan 6 Rings");


        String totalPriceDisplayed =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();


        Double totalPriceDisplayedDouble =Double.parseDouble(totalPriceDisplayed.substring(1));

        Assert.assertEquals(totalPrice,totalPriceDisplayedDouble);

        WebElement element =driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

        longPressActionMethod(element);

        Thread.sleep(2000);

        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(6000);

        Set<String> contexts =driver.getContextHandles();

        for(String s :contexts)
        {
            System.out.println(s);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Rahul shetty");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");


    }
}
