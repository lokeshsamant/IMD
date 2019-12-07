package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IframePage {
	
	public IframePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//iframe[@id='mce_0_ifr']")
	private WebElement textBox;
	
	public void accessingIFrame() throws InterruptedException {
		
		Assert.assertTrue(textBox.isDisplayed());
		textBox.click();
		textBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		textBox.sendKeys("I love pizza");
		Thread.sleep(2000);
	}
	
}
