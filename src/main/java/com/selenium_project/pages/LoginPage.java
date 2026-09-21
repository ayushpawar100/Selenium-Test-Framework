package com.selenium_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium_project.actiondrivers.ActionDriver;
import com.selenium_project.base.BaseClass;

public class LoginPage {
	
	private ActionDriver actionDriver;
	
	//Define locators using By class
	private By userNameField = By.name("username");
	private By passwordField = By.cssSelector("input[type='password']");
	private By loginButton = By.xpath("//button[text()=' Login ']");
	private By errorMessage = By.xpath("//p[text()='Invalid credentials']");

	//Initialize the ActionDriver object by pass WebDriver instance
	/*public LoginPage(WebDriver driver) {
		this.actionDriver = new ActionDriver(driver);
	}
	*/
	
	public LoginPage(WebDriver driver) {
		this.actionDriver = BaseClass.getActionDriver();
		
	}
	
	//Method to perform login
	public void login(String userName, String password) {
		actionDriver.enterText(userNameField, userName);
		actionDriver.enterText(passwordField, password);
		actionDriver.click(loginButton);
	}
	
	//Method to check if error message is displayed
	public boolean isErrorMessageDisplayed() {
		return actionDriver.isDisplayed(errorMessage);
	}
	
	//Method to get the text from Error message
	public String getErrorMessageText() {
		return actionDriver.getText(errorMessage);
	}

	//Verify if error is correct or not -- return is changed
	public boolean verifyErrorMessage(String expectedError) {
		return actionDriver.compareText(errorMessage, expectedError);
	}
}
