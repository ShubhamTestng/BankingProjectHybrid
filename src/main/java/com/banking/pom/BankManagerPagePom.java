package com.banking.pom;

import org.openqa.selenium.support.PageFactory;

import com.bankingproject.base.BaseClass;

public class BankManagerPagePom extends BaseClass{
	
	public BankManagerPagePom() {
		
		PageFactory.initElements(driver,this);
	}

	public void Hello() {
		
		System.out.println("hiii");
	}
	
}
