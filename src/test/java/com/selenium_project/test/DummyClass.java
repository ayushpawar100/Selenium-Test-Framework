package com.selenium_project.test;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.selenium_project.base.BaseClass;
import com.selenium_project.utilities.ExtentManager;

public class DummyClass extends BaseClass {
	
	@Test
	public void dummyTest() {
		
	//ExtentManager.startTest("DummyTest1 Test");	 -- This has been implemented in TestListener class
	String title =	getDriver().getTitle();
	ExtentManager.logStep("Verifying the Title");
	assert title.equals("OrangeHRM") : "Test Failed - Title is Not Matching";
	
	System.out.println("Test Passed - Title is Matching");
	//ExtentManager.logSkip("This case is skipped");
	//throw new SkipException("Skipping the test as part of Testing");
	}

}
