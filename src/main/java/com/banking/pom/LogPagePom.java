

package com.banking.pom;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bankingproject.base.BaseClass;
import com.bankingutility.Utility;

public class LogPagePom extends BaseClass{
	
	
	public LogPagePom() {
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement user ;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement psword ;
	
	@FindBy(xpath= "//input[@name='btnLogin']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement resetButton;
	
	@FindBy(xpath="//a[text()='here']")
	WebElement getCredeitialLink ;
	
	public void sendKeysTouserid(String userid) throws InterruptedException {
		
		user.sendKeys(userid);
		
		
		
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
	     
	     wait.until(ExpectedConditions.visibilityOf(user));
	}
	
	public void sendKeysTopassword(String password) throws InterruptedException {
		
		psword.sendKeys(password);
		
		Thread.sleep(2000);
		
	}
	
	public BankManagerPagePom clickOnLoginButton() {
		
		loginButton.click();
		
		return new BankManagerPagePom();
	}
	
	public HomePgaePom clickOngetCredentialLink() throws InterruptedException {
	
		getCredeitialLink.click();
		
		Thread.sleep(5000);
		
		HandleiFrame();
		
		return new HomePgaePom();
		
	}
	
	public void clickOnAlert() {
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		System.out.println("alert handle");

	}
	
public void HandleiFrame () {
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='3rd party ad content']"));

	       if(iframe.isDisplayed()) {
	    	   
	    	   driver.switchTo().frame(iframe);
	    	   
	    	   driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]")).click();
	    	   
	    	   driver.switchTo().defaultContent();
	    	   
		}
}
}
