package com.busyqa.batch16.uitests.Batch16uiTest;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.busyqa.batch16.uitests.excelReader.ExcelReader;
import com.busyqa.batch16.uitest.pageClasses.LoginPage1;
import com.busyqa.batch16.uitest.screenShot.CaptureScreenshot;
import com.busyqa.batch16.uitest.testBase.TestBase;


@Listeners(com.busyqa.batch16.uitest.listeners.ListenerTest.class)
public class TC01_Login extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC01_Login.class.getName());

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
     
     @Parameters({"env", "browser"})
	 @BeforeTest
	 void setUp(String env, String browser) {
		 	init(env, browser);
		    
		   
		    excel = new ExcelReader(); //Excel_Reader Class
			screen = new CaptureScreenshot();
			login = new LoginPage1(driver);
		    
		    
		  
	}
	
     @Test
	 void loginTest01() {
		
		   
		   int row_num = 1;
		   
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
			
			screen.getScreenShot(driver, "InvalidLoginTest_02");
		  
             Assert.assertEquals(message, "Invalid credentials");
			
		    //  excel.writeCellData(filepath,"loginData.xlsx", "NewSheet", "Executed");	

			excel.updateCellData(filepath,"loginData.xlsx", "login",row_num, message);
		   
		    // excel.newSheet(filepath,"newSheet.xlsx", "test");
			
	}
     
     @Test
	 void loginTest03() {
		
		   
		   int row_num = 3;
		   
		   // 1. Get the login data from the excel 
		   
		    login_cred=excel.getCellData(filepath,"loginData.xlsx", "login",row_num);
		
			user=login_cred.get(0); // username
			pass=login_cred.get(1); // password
			log.info("User name for the TC " + row_num + " is: " + user);
			log.info("Password for the TC " + row_num + " is: " + pass); 
			
			message = login.loginInto(user, pass);
			log.info(message);
			
			screen.getScreenShot(driver, "InvalidLoginTest_03");
		  
             Assert.assertEquals(message, "Invalid credentials");
			
		    //  excel.writeCellData(filepath,"loginData.xlsx", "NewSheet", "Executed");	

			excel.updateCellData(filepath,"loginData.xlsx", "login",row_num, message);
		   
		    // excel.newSheet(filepath,"newSheet.xlsx", "test");
			
	}
     
     @Test
	 void loginTest04() {
		
		   
		   int row_num = 4;
		   
		   // 1. Get the login data from the excel 
		   
		    login_cred=excel.getCellData(filepath,"loginData.xlsx", "login",row_num);
		
			user=login_cred.get(0); // username
			pass=login_cred.get(1); // password
			log.info("User name for the TC " + row_num + " is: " + user);
			log.info("Password for the TC " + row_num + " is: " + pass); 
			
			message = login.loginSuccess(user, pass);
			log.info(message);
			
			screen.getScreenShot(driver, "ValidLogin");
		  
             Assert.assertEquals(message, "Success");
			
		    //  excel.writeCellData(filepath,"loginData.xlsx", "NewSheet", "Executed");	

			excel.updateCellData(filepath,"loginData.xlsx", "login",row_num, message);
		   
		    // excel.newSheet(filepath,"newSheet.xlsx", "test");
			
	}
     
     @Test
	 void failed_TC1() {
		  
    	  Assert.assertEquals(false, true); // intentially failing
	}

     
     @AfterTest
     public void endTest() {
     	
     	driver.close();
     	
     }

}

