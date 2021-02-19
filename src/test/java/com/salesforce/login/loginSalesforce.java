package com.salesforce.login;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.salesforce.utilities.TestBase;

import PageObjects.pologin;

public class loginSalesforce extends TestBase{

	pologin login;
	
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeTest
	public void settingUpEnvironment() throws Exception {
		sErrorMessage = "";
		sClassNameForScreenShot = getClass().getSimpleName();
		driver.get(oCons.getSalesforceURL());
		login = new pologin(driver);
		//login.checkIfLoginSuccess();
		
	}
	/*
	 
	 */
	@AfterMethod
	public void settingReqURL() throws Exception {
		driver.get(oCons.getSalesforceURL());
	}

	/*
	Precondetion - Test Steps : Expected condetion 
	 
	 */
	
	@Test(priority = 2)
	public void to_Check_Whether_Login_Happening_Or_Not() throws Exception {
		
		 login.checkIfLoginSuccess();
	}

	@Test(priority = 1)
	public void To_check_Error_For_Invalid_Login() throws Exception {
		login.invalidloginToSalesforce();
		SoftAssert sa = new SoftAssert();
		sa.assertAll();
		}
	 	
}
