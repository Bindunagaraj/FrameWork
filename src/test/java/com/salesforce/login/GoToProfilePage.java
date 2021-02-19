package com.salesforce.login;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.utilities.TestBase;

import PageObjects.poHome;
import PageObjects.pologin;

public class GoToProfilePage extends TestBase {
pologin login;
poHome home;
boolean loggedIn=false;
	
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeTest
	public void settingUpEnvironment() throws Exception {
		sErrorMessage = "";
		sClassNameForScreenShot = getClass().getSimpleName();
		driver.get(oCons.getSalesforceURL());
		login = new pologin(driver);
		home=new poHome(driver);
	}
@Test(priority = 1)
public void login() throws Exception
{
	loggedIn=login.checkIfLoginSuccess();
	
	
	}
@Test(priority = 2)
public void myProfil() throws Exception
{
	if(loggedIn==true)
	{
		home.clickonMyProfile();
	}
	else
	{
		log.error("Couldnot click on MyProfile");
	}
	}
}
