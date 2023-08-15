package com.bankingproject.loginpage;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.banking.pom.CredentialPagePom;
import com.banking.pom.HomePgaePom;
import com.banking.pom.LogPagePom;
import com.bankingproject.base.BaseClass;
import com.bankingutility.Utility;

	public class HomePageTest extends BaseClass{
		
		HomePgaePom homepage;
			
		@Parameters({"browser"})
			@BeforeClass
			public void setUp(String browser) {
				
				launchwebsite(browser);
				
				//driver.get("https://demo.guru99.com/");
			}
			
			@AfterClass
			public void tearDown() {
				
				driver.close();
			}
			
			
			@Test
			public void clickOnCredential() throws InterruptedException, EncryptedDocumentException, IOException {
				
				LogPagePom logPagePom = new LogPagePom();
				
				HomePgaePom homepagepom = new HomePgaePom();
				
				homepagepom=logPagePom.clickOngetCredentialLink();
				
				Thread.sleep(2000);
				
				Utility utility = new Utility();
				
				String email = (String) utility.getSingleExcelValue(1,0,"emailButton");
				
				Thread.sleep(2000);
				
				homepagepom.clickOnEmailButton(email);
				
				Thread.sleep(4000);
				
				CredentialPagePom credentialPagePom = new CredentialPagePom();
				
				credentialPagePom = homepagepom.clickOnSubmitButton();
				
				Thread.sleep(2000);
				
				credentialPagePom.saveCredential();
			
				
				
		}

}



