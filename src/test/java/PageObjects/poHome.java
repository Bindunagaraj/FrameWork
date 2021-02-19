package PageObjects;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.utilities.TestBase;

public class poHome extends TestBase {
	Logger log=Logger.getLogger(getClass().getSimpleName());
	public poHome(WebDriver driver)
	{
		TestBase.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="userNavLabel")
	WebElement UserMenu;
	@FindBy(xpath="//a[@title =\"My Profile\"]")
	WebElement MyProfile;
	boolean result=false;
	
	public boolean clickonUserMenu() throws Exception
	{
		try {
		oBroUti.waitForElementVisible(driver,UserMenu,3);
		oBroUti.ufClick(UserMenu);
		log.info("Could click on UserMenu");
		return true;
		}catch(Exception e) {
			log.info("couldn't click on UserMenu"+e);
		return false;}
	}
	 public void clickonMyProfile() throws Exception
	 {
		 result=clickonUserMenu();
		 try {
			 if(result=true) {
		 oBroUti.waitForElementVisible(driver,MyProfile,3);
		 oBroUti.mouseOver(driver,MyProfile);
		 log.info("Successfully clicked on MyProfile");}
		 }catch(Exception e)
		 {
			 oBroUti.screenShotBrowser(driver, getClass().getName());
			 log.error("couldn't click on Myprofile");
		 }
	 }
	

}
