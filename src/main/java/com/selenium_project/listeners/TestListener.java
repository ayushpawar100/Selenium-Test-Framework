package com.selenium_project.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.selenium_project.base.BaseClass;
import com.selenium_project.utilities.ExtentManager;
import com.selenium_project.utilities.RetryAnalyzer;

public class TestListener implements ITestListener, IAnnotationTransformer {

	
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

	//Triggered when a test starts
	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		ExtentManager.startTest(testName);
		ExtentManager.logStep("Test Started : "+testName);
	}

	//Triggered when a Test succeeds 
	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		ExtentManager.logStepWithScreenshot(BaseClass.getDriver(), "Test Passed Successfully!", "Test End: "+testName+" - ✔ Test Passed");
	}

	//Triggered when a Test Fails
	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String failureMessage = result.getThrowable().getMessage();
		ExtentManager.logStep(failureMessage);
		ExtentManager.logFailure(BaseClass.getDriver(), "Test Failed!", "Test End: "+testName+" - ✖ Test Passed");
	}

	//Triggered when a Test Skips
	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		ExtentManager.logSkip("Test Skipped "+testName);
	}

	//Triggered when a suite Starts
	@Override
	public void onStart(ITestContext context) {
		//Initilize the Extent Reports
		ExtentManager.getReporter();
		
	}

	//Triggered when the suite Ends
	@Override
	public void onFinish(ITestContext context) {
		//Flush the extent reports.
		ExtentManager.endTest();
	}
	
	

}
