package com.busyqa.batch16.uitests.Batch16uiTest;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.busyqa.batch16.uitests.excelReader.ExcelReader;
import com.busyqa.batch16.uitest.pageClasses.LoginPage1;
import com.busyqa.batch16.uitest.screenShot.CaptureScreenshot;


@Listeners(com.busyqa.batch16.uitest.listeners.ListenerTest.class)
public class TC02_Login {
	
	public static final Logger log = Logger.getLogger(TC02_Login.class.getName());

	 WebDriver driver;
	 WebElement username;
	 WebElement password;
	 WebElement loginbtn;
	 int i;
	 ExcelReader excel;
	 String filepath=System.getProperty("user.dir") + "\\Resources2\\Data\\";
	 ArrayList<String> login_cred = new ArrayList<String>();
	 String user="";
	 String pass="";
	 String message="";
	 CaptureScreenshot screen;
     LoginPage1 login;
     
	 @BeforeTest
	 void setUp() {
		 	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources2\\Drivers\\chromedriver.exe\\");
			
		    driver = new ChromeDriver();
		    driver.get("https://opensource-demo.orangehrmlive.com/");
		    driver.manage().window().maximize();
		    
		    String log4jConfPath = System.getProperty("user.dir")+"\\Resources2\\ConfigFiles\\log4j.properties\\";
		    PropertyConfigurator.configure(log4jConfPath);
		   
		    excel = new ExcelReader(); //Excel_Reader Class
			screen = new CaptureScreenshot();
			login = new LoginPage1(driver);
		    
		    
		  
	}
	
     @Test
	 void loginTest02() {
		
		   
		   int row_num = 2;
		   
		   // 1. Get the login data from the excel 
		   
		    login_cred=excel.getCellData(filepath,"loginData.xlsx", "login",row_num);
		
			user=login_cred.get(0); // username
			pass=login_cred.get(1); // password
			log.info("User name for the TC " + row_num + " is: " + user);
			log.info("Password for the TC " + row_num + " is: " + pass); 
			
			message = login.loginInto(user, pass);
			log.info(message);
			
			screen.getScreenShot(driver, "InvalidLoginTest_01");
		  
             Assert.assertEquals(message, "Invalid credentials");
			
		    //  excel.writeCellData(filepath,"loginData.xlsx", "NewSheet", "Executed");	

			excel.updateCellData(filepath,"loginData.xlsx", "login",row_num, message);
		   
		    // excel.newSheet(filepath,"newSheet.xlsx", "test");
			
	}


	 
	 @AfterTest
   public void endTest() {
   	
   	driver.close();
   	
   }

}

