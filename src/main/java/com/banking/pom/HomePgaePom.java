
package com.banking.pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingproject.base.BaseClass;

public class HomePgaePom extends BaseClass{
	
	public HomePgaePom() {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement emailid;

	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement submit;
	
	
	public void clickOnEmailButton(String email) {
		
		emailid.sendKeys(email);
		
	}
	
	public CredentialPagePom clickOnSubmitButton() {
		
		submit.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
		
		return new CredentialPagePom();
		
	}
	
	
	}
	


