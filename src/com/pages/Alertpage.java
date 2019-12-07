package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Alertpage {
	
	public Alertpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "result")
	private WebElement result;
	
	@FindBy(xpath ="//button[contains(text(),'Click for JS Confirm')]")
	private WebElement jSConfirmButton;
	
	@FindBy(xpath ="//button[contains(text(),'Click for JS Prompt')]")
	private WebElement jSPromptButton;
	
	public void alertOk(WebDriver driver) throws InterruptedException {
		
		Assert.assertTrue(jSConfirmButton.isDisplayed());
		jSConfirmButton.click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(result.getText(), "You clicked: Ok");
		Thread.sleep(2000);
	}
	
	public void promptCancel(WebDriver driver) throws InterruptedException {
		
		Assert.assertTrue(jSPromptButton.isDisplayed());
		jSPromptButton.click();
		driver.switchTo().alert().dismiss();
		Assert.assertEquals(result.getText(), "You entered: null");
		Thread.sleep(2000);
	}
	
}
