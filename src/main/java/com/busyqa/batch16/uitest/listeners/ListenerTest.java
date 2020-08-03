package com.busyqa.batch16.uitest.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.busyqa.batch16.uitest.extentReport.ExtentTestManager;
import com.busyqa.batch16.uitest.extentReport.ExtentManager;


public class ListenerTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+"Test Case Started");
		ExtentTestManager.startTest(result.getMethod().getMethodName()); // getmethod is getting the name of the test method name
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is :"+result.getName());
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(("The name of the testcase Failed is :"+result.getName()));
		 ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable()); // getThrowable - getting the failure logs from the test method
		 	 
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is :"+result.getName());
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		
	}

}


