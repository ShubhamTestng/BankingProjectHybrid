package com.bankingproject.loginpage;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.bankingproject.base.BaseClass;
import com.bankingutility.Utility;

public class MyListner extends BaseClass implements ITestListener {
	
	  @Override
	  public void onTestStart(ITestResult result) {
		
		 System.out.println(result.getName()+"test started");
		
	  }
	
	  @Override
      public void onTestSuccess(ITestResult result) {
		  
		  Utility utility = new Utility();
		 
		  try {
			  
			utility.getscreenshot("testSucess");
			
		  } 
		  
		  catch (IOException e) {
			  
			e.printStackTrace();
			
		  }
		
		System.out.println(result.getName()+"sucessfully executed");
		
		
	  }
	  
	  @Override
      public void onTestFailure(ITestResult result) {
		
		System.out.println(result.getName()+"failure not executed");
		
	  }
	  
	  @Override
	  public void onTestSkipped(ITestResult result) {
			
			System.out.println(result.getName()+" skipped ");
			
	  }
		  
	  
	  
	

}
