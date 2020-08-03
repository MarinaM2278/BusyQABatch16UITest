package com.busyqa.batch16.uitest.pageClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	WebDriver driver; // global variable for the page class/instance variable
	
   // Approach 1: Page Object Model
	By user = By.id("txtUsername");
	
	By password = By.id("txtPassword");
	
	By btn = By.id("btnLogin");
	
	By msg = By.xpath("//span[text()='Invalid credentials']");

	
	public LoginPage(WebDriver driver) {
		this.driver = driver; // object of the current page class LoginPage.driver
	}
	
	public String loginInto(String emailId,String pass) { // page method
		
	
	    driver.findElement(user).sendKeys(emailId);
	    
	    driver.findElement(password).sendKeys(pass);
	    
	    driver.findElement(btn).click();
	    
	    String message = driver.findElement(msg).getText();
	    
	    return message;    
	}
}
