package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandCoding {
	
 private WebDriver driver;
 private String baseUrl;
 private boolean acceptNextAlert = true;
 private StringBuffer verificationErrors = new StringBuffer();

 
 @Before 
 public void setUp() throws Exception {

 System.setProperty("webdriver.firefox.marionette","/Users/Bob/Desktop/drivers/geckodriver");
 //  System.setProperty("webdriver.chrome.driver","/Users/Bob/Desktop/drivers/chromedriver");
   driver = new ChromeDriver();
 //  driver = new FirefoxDriver();
   baseUrl = "https://www.youtube.com/";
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }

 @Test
 public void testUntitled() throws Exception {
   driver.get(baseUrl + "/");
   driver.findElement(By.id("masthead-search-term")).clear();
   driver.findElement(By.id("masthead-search-term")).sendKeys("QTP");
   driver.findElement(By.id("search-btn")).click();
   driver.findElement(By.linkText("Music")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
   driver.findElement(By.id("Email")).clear();
   driver.findElement(By.id("Email")).sendKeys("ddd@gmail.com");
   driver.findElement(By.id("next")).click();
   driver.findElement(By.id("Email")).clear();
   driver.findElement(By.id("Email")).sendKeys("top.test@gmail.com");
   driver.findElement(By.id("next")).click();
   driver.findElement(By.id("Passwd")).clear();
   driver.findElement(By.id("Passwd")).sendKeys("asasd");
   driver.findElement(By.id("signIn")).click();
 }

 @After
 public void tearDown() throws Exception {
   driver.quit();
   String verificationErrorString = verificationErrors.toString();
   if (!"".equals(verificationErrorString)) {
     fail(verificationErrorString);
   }
 }

 private boolean isElementPresent(By by) {
   try {
     driver.findElement(by);
     return true;
   } catch (NoSuchElementException e) {
     return false;
   }
 }

 private boolean isAlertPresent() {
	 try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
