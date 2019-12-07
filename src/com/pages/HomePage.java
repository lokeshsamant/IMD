package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath ="//i[@class='fa fa-2x fa-sign-in']")
	private WebElement loginButton;
	
	@FindBy(xpath ="//div[@id='flash']")
	private WebElement loginError;
	
	public void login(String UserName , String Password) throws InterruptedException {
		
		Assert.assertTrue(userName.isDisplayed());
		userName.sendKeys(UserName);
		password.sendKeys(Password);
		Thread.sleep(1000);
		loginButton.click();	
		Thread.sleep(2000);
		if(loginError.getText().contains("Your username is invalid!"))
		{
			System.out.println(" Login Failed ! Due to "+loginError.getText());
		}
		else if(loginError.getText().contains("You logged into a secure area!"))
		{
			System.out.println(" Login Successful ! and "+loginError.getText());
		}
	}
	
}
