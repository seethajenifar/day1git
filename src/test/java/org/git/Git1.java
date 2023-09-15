package org.git;
import java.util.Date;
import org.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v114.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Git1 {
	
	@BeforeClass
	
	Browser Launch("chrome");
	urlLaunch("https://www.amazon.in/");
	implicitlywait(10);
	}
	@AfterClass
	
	private void afterclass() {
	quit();
	}
	@BeforeMethod
	
	private void beforemethod() {
	Date d = new Date();
	System.out.println("start time"+d);
	}
	@AfterMethod
	
	private void aftermethod() {
	Date d = new Date();
	System.out.println("end time"+d);
	}
	@Test
	
private void test() {
Login l = new Login();
sendkeys(l.getiphone(), "iphone");
click(l.getsearch());





//public static void main(String[] args) {
//	WebDriver driver = new EdgeDriver();   
//	driver.get("https://www.amazon.in/");   
//	WebElement txtUsername = driver.findElement(By.id("twotabsearchtextbox"));
//	txtUsername.sendKeys("iphone");
//	WebElement btnsearch = driver.findElement(By.id("nav-search-submit-button")); 
//	btnsearch.click();










}