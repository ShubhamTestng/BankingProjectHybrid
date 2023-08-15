package com.bankingproject.loginpage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTestDemo {
	
	@Test(expectedExceptions = ArithmeticException )
	public void softassert() {
		
	SoftAssert assert2 = new SoftAssert();
	
	          assert2.assertTrue(10/0>5);
	
	      System.out.println("using softassert");
	      
	      assert2.assertEquals(10, 4, "we are getting same");
	      
	      
	      System.out.println("using softassert");
	      
	      assert2.assertAll();
	      
	}

}
