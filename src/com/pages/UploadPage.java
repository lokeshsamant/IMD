package com.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UploadPage {
	
	public UploadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "file-upload")
	private WebElement chooseFile;
	
	@FindBy(id = "file-submit")
	private WebElement uploadButton;
	
	@FindBy(id = "uploaded-files")
	private WebElement uploadedFile;
	
	public void uploadImage() throws InterruptedException {
		
		Assert.assertTrue(chooseFile.isDisplayed());
		File path = new File(".\\Input\\burrito.jpg");
		chooseFile.sendKeys(path.getAbsolutePath());
		Thread.sleep(2000);
		uploadButton.click();	
		Thread.sleep(2000);
		Assert.assertTrue(uploadedFile.getText().contains("burrito.jpg"));
		Thread.sleep(2000);
	}
	
}
