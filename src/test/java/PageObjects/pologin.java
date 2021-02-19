package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.salesforce.utilities.TestBase;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;

public class pologin extends TestBase{

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public pologin(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement ph_username;
	@FindBy(id="password")
	WebElement ph_password;
	@FindBy(id="Login")
	WebElement button_loginToAccount;
	@FindBy(id="home_Tab")
	WebElement button_Home;
	@FindBy(id="error")
	WebElement error;
	
	public boolean loginToSalesforce() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, ph_username, 5);
		oBroUti.ufSendKeys(ph_username, System.getProperty("td_emailId"));
		oBroUti.ufSendKeys(ph_password, System.getProperty("td_password"));
		oBroUti.ufClick(button_loginToAccount);
		oBroUti.waitForElementVisible(driver, button_Home, 5);
		if(oBroUti.isDisplayed(button_Home))
			bRes_Flag=true;
		return bRes_Flag;
	}
	
	public Boolean checkIfLoginSuccess() throws Exception{
		
		boolean bRes_Flag=false;
		try {
		oBroUti.waitForElementVisible(driver, button_Home, 3);
		}catch(Exception ea) {log.error("By passing error when we run on suite case");}
		if(!oBroUti.isDisplayed(button_Home))
			bRes_Flag=loginToSalesforce();
		try {	
		if(bRes_Flag==true) {
			log.info("Login Success and Home page is visible");
			return bRes_Flag;
			}
		}catch(Exception e)
			{
			log.info("Login Success but Home page is not visible" + e);
			return false;
			}
		return false;
			
		
	
		
	}
	
	public void invalidloginToSalesforce() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, ph_username, 5);
		oBroUti.ufSendKeys(ph_username, System.getProperty("td_invalid_emailId"));
		oBroUti.ufSendKeys(ph_password, System.getProperty("td_invalid_password"));
		oBroUti.ufClick(button_loginToAccount);
		log.info("****************************");
		Thread.sleep(2000);
		log.info(error.getText());
		log.info("****************************");
		assertEquals(error.getText(),"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	}

}
