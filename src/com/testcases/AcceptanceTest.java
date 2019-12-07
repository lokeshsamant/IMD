package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Alertpage;
import com.pages.HomePage;
import com.pages.IframePage;
import com.pages.UploadPage;

public class AcceptanceTest {

	
	public WebDriver driver;
	HomePage home = new HomePage(driver);
	Alertpage alerts = new Alertpage(driver);
	UploadPage upload = new UploadPage(driver);
	IframePage iframe = new IframePage(driver);
	
	 @BeforeTest 
	 public void setProperty() throws InterruptedException {
		 
		 	System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
	 }
	 
	 @Test ( priority = 0 )
	 public void loginFailure() throws InterruptedException {
		 
		 //Scenario: Login failure
		 driver.get("http://the-internet.herokuapp.com/login");
		 Thread.sleep(2000);
		 home=new HomePage(driver);
		 home.login("UserName","Password");
		 
	}
	 
	@Test ( priority = 1 )
	public void loginSuccess() throws InterruptedException {
		 
		 //Scenario: Login success
		 driver.get("http://the-internet.herokuapp.com/login");
		 Thread.sleep(2000);
		 home=new HomePage(driver);
		 home.login("tomsmith","SuperSecretPassword!");
	}
	
	@Test ( priority = 2 )
	public void alertConfirm() throws InterruptedException {
		 
		 //Scenario: Alert - JS Confirm
		 driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		 Thread.sleep(2000);
		 alerts = new Alertpage(driver);
		 alerts.alertOk(driver);
	}
	
	@Test ( priority = 3 )
	public void PromptCancel() throws InterruptedException {
		 
		 //Scenario: Text Verification
		 driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		 Thread.sleep(2000);
		 alerts = new Alertpage(driver);
		 alerts.promptCancel(driver);
	}
	
	@Test ( priority = 4 )
	public void UploadImage() throws InterruptedException {
		 
		 //Scenario: File upload
		 driver.get("http://the-internet.herokuapp.com/upload");
		 Thread.sleep(2000);
		 upload = new UploadPage(driver);
		 upload.uploadImage();
	}
	
	@Test ( priority = 5 )
	public void AccessingiFrame() throws InterruptedException {
		 
		 //Scenario: Accessing iFrame
		 driver.get("http://the-internet.herokuapp.com/iframe");
		 Thread.sleep(2000);
		 iframe = new IframePage(driver);
		 iframe.accessingIFrame();
	}
	 

	@AfterTest
	public void CloseApp() throws InterruptedException {
			
			//Last but not least, close the application and end the test
		driver.quit();
	}
}
