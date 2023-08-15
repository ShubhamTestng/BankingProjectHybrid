package com.bankingproject.loginpage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.banking.pom.BankManagerPagePom;
import com.banking.pom.HomePgaePom;
import com.banking.pom.LogPagePom;
import com.bankingproject.base.BaseClass;
import com.bankingutility.Utility;

@Listeners(MyListner.class)
public class LoginPageTest extends BaseClass {
	
	
	
	LogPagePom logPagePom ;
	
     ExtentSparkReporter extentSparkReporter ;
     ExtentReports extentReports;
     ExtentTest extentTest;
     
     
     
     @Parameters({"browser"})
    @BeforeClass
	public void setUp(String browser) throws FileNotFoundException {
    	 
    	 launchwebsite(browser);
		
		driver.manage().window().maximize();
		
		extentSparkReporter = new ExtentSparkReporter(projectpath+"//extentReport//extent.html");
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(extentSparkReporter);
	}
	
    
    @AfterClass
	public void tearDown() {
		
    	extentReports.flush();
		driver.close();
	}
	
	@Test
	public void testUrl() throws IOException {
		
		extentTest = extentReports.createTest("testUrl");
		
		String pagetile = driver.getCurrentUrl();
		
		extentTest.log(Status.PASS, pagetile);
		
	    Utility utility = new Utility();
		
		extentTest.addScreenCaptureFromPath(utility.getscreenshot("testUrl"),pagetile);
		
		Assert.assertEquals(pagetile,"https://demo.guru99.com/V1/index.", "we are on correct webpage of url");
		
	}

	@Test
	 public void testTitle() throws IOException, InterruptedException {
		 
		 String  pagetitle = driver.getTitle();
		 
		 Utility utility = new Utility();
		 
		 utility.getscreenshot(pagetitle);
		 
	     Assert.assertEquals(pagetitle,"GTPL Bank Home Page");		 
	}
	
	@DataProvider(name="logindata")
	public Object[][] getAllExcelsheetData() throws EncryptedDocumentException, IOException {
		
		Utility utility = new Utility();
		
		return utility.getAllExcelSheetData("login");
		
	}
    
	/*public void clickLogin() {
		LogPagePom logPagePom1 = new LogPagePom();
		logPagePom1.clickOnLoginButton();
		
		logPagePom1.clickOnAlert();
	}
      */
     
     @Test(dataProvider = "logindata")
     public void clickloginWithCorrect(Map<String, String> logindataprovider) throws EncryptedDocumentException, IOException, InterruptedException {
    	 
    	 LogPagePom logPagePom = new LogPagePom();
    	 
    	 Utility utility2 = new Utility();
    		
    		//String userid = (String) utility2.getSingleExcelValue(1,0,"saveCredential");
    		
    		//logPagePom.sendKeysTouserid(null).sendKeys(logindataprovider.get("username"));
    		
    		//logPagePom.sendKeysTopassword();
    		
    		Utility utility3 = new Utility();
    		
    		//String password = (String) utility3.getSingleExcelValue(1,1,"saveCredential");
    		
    		//logPagePom.sendKeysTopassword(password);
    		
    		Thread.sleep(2000);
    		
    	//	BankManagerPagePom bankManagerPagePom = logPagePom.clickOnLoginButton();
    		 
    		              //bankManagerPagePom.Hello();
    		
     }

	   
}
