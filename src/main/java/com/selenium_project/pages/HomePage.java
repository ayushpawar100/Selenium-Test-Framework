package com.selenium_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium_project.actiondrivers.ActionDriver;
import com.selenium_project.base.BaseClass;

public class HomePage {
	
	public ActionDriver actionDriver;
	
	//Define locators using By class
	private By adminTab = By.xpath("//span[text()='Admin']");
	private By userIdButton = By.className("oxd-userdropdown-tab");
	private By logoutButton = By.xpath("//a[text()='Logout']");
	private By orangeHRMlogo = By.xpath("//div[@class='oxd-brand-banner']//img");

	
	/*
	//Initialize the ActionDriver object by pass WebDriver instance
		public HomePage(WebDriver driver) {
			this.actionDriver = new ActionDriver(driver);
		}
		*/
	
		
		public HomePage(WebDriver driver) {
			this.actionDriver = BaseClass.getActionDriver();
			
		}

	//Method to verify if Admin tab is visible
		public boolean isAdminTabVisible() {
			return actionDriver.isDisplayed(adminTab);
		}
		
		public boolean verifyOrangeHRMlogo() {
			return actionDriver.isDisplayed(orangeHRMlogo);
		}
		
		//Method to perform logout operation
		public void logout() {
			actionDriver.click(userIdButton);
			actionDriver.click(logoutButton);
		}
		
		
}
