package com.busyqa.batch16.uitest.pageClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	
	public static final Logger log = Logger.getLogger(LoginPage1.class.getName());
	
	// Approach 2: Page Object Model with Page Factory
	
	@FindBy(how=How.ID, using = "txtUsername")
	WebElement user;
	
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(how = How.ID, using = "btnLogin")
	WebElement btn;
	
	/* @FindBy(xpath="//span[text()='Invalid credentials']")
	@CacheLookup
	WebElement msgWithCache;
	
	@FindBy(xpath="//span[text()='Invalid credentials']")
	WebElement msgWithoutCache; */
	
	@FindBy(xpath="//span[text()='Invalid credentials']")
	WebElement msg;
	
	String message = null;
	
	public LoginPage1(WebDriver driver) {
		PageFactory.initElements(driver, this); // this implies the object of the current page class LoginPage1
	}
	
	public String loginInto(String emailId,String pass) {
		
		
		
	    user.sendKeys(emailId); 
	    
	    password.sendKeys(pass);
	    
	    btn.click();
	    
	    message = msg.getText();
	    
	    return message;    
	}
	
	public String loginSuccess(String emailId,String pass) {
		
		user.sendKeys(emailId); 
	    
	    password.sendKeys(pass);
	    
	    btn.click();
	    
	    message = "Success";
	    return message;
	}
}

