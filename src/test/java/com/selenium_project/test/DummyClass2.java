package com.selenium_project.test;

import org.testng.annotations.Test;

import com.selenium_project.base.BaseClass;
import com.selenium_project.utilities.ExtentManager;

public class DummyClass2 extends BaseClass {
	
	@Test
	public void dummyTest2() {
		
		//ExtentManager.startTest("DummyTest2 Test"); -- This has been implemented in TestListener class
	String title =	getDriver().getTitle();
	ExtentManager.logStep("Verifying the Title");
	assert title.equals("OrangeHRM") : "Test Failed - Title is Not Matching";
	
	System.out.println("Test Passed - Title is Matching");
	ExtentManager.logStep("Validation Successful!");	
	}

}
