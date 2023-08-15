package com.banking.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingproject.base.BaseClass;

public class CredentialPagePom extends BaseClass {
	
	public CredentialPagePom() {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//table[@border='1']/tbody/tr[4]/td[2]")
	WebElement userID;
	
	@FindBy(xpath="//table[@border='1']/tbody/tr[5]/td[2]")
	WebElement passwordfield;
	
	
	public void saveCredential() {
		
		String user = userID.getText();		
		
		String password = passwordfield.getText();
		
		System.out.println(user + " ,"+ password);
		
	}
	

}
